package com.example.uno.game.GameFramework;

import java.util.LinkedList;
import java.util.Queue;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.game.GameFramework.utilities.IPCoder;
import com.example.uno.game.GameFramework.utilities.NetworkObjectPasser;
import com.example.uno.game.GameFramework.utilities.Logger;

/**
 * A Game object that is used as a proxy for the real game that is on another
 * machine on the network.  Each ProxyGame is associated with exactly one
 * Player object.  Whenever a message is sent to the ProxyGame object,
 * it serializes the message and sends it across the network; when
 * the ProxyGame object receives a message from the network, it
 * unserializes the message and sends it to its player.
 *
 * @author Steven R. Vegdahl
 * @author Eric Imperio
 * @version January 2020
 */
public class ProxyGame implements Game {
    //Tag for logging
    private static final String TAG = "ProxyGame";

    // the player associated with this game
    private GamePlayer player;

    // a queue of objects that are collected, which might have been sent over the
    // network before we are connected to a player
    private Queue<GameInfo> queuedObjectsForPlayer = new LinkedList<GameInfo>();

    // the network-connection object
    private NetworkObjectPasser networkPasser;

    /**
     * Static method used instead of a constructor, so that null can be returned if
     * the creation was unsuccessful.
     *
     * @param portNum
     * 			the port number for connecting to the host
     * @param ipCode
     * 			the IP code of the server where the game is hosted
     * @return
     */
    public static ProxyGame create(int portNum, String ipCode) {
        // create the game object
        ProxyGame rtnVal = new ProxyGame(portNum, ipCode);

        // see if a connection becomes established; if so, return
        // the object, otherwise null
        boolean isReady = rtnVal.networkPasser.isReady();
        if (isReady) {
            return rtnVal;
        }
        else {
            return null;
        }
    }

    /**
     * ProxyGame constructor (private)
     *
     * @param portNum
     * 		the port number on the server to connect to
     * @param ipCode
     * 		the IP code of the remote site to where the actual
     *  	game is running
     */
    private ProxyGame(int portNum, String ipCode) {

        // set instance variables to their initial values
        player = null;
        ipCode = IPCoder.decodeIp(ipCode); // convert to IP address

        Logger.debugLog(TAG, "Creating Network Connection");

        // create the network-connector object
        networkPasser = new NetworkObjectPasser(ipCode, portNum) {

            // callback method, called whenever an object is sent to us from
            // across the network
            public void onReceiveObject(Object obj) {
                Logger.debugLog(TAG, "Received object: "+obj.getClass());
                try {
                    boolean b = obj instanceof GameInfo;
                    if (b) {
                        // object is a GameState object
                        GameInfo gs = (GameInfo)obj;
                        gs.setGame(ProxyGame.this);
                        synchronized(this) {
                            if (player == null) {
                                // if the player has not been connected, save the
                                // object in a queue
                                Logger.debugLog(TAG, "Adding object to queue");
                                queuedObjectsForPlayer.add(gs);
                            }
                            else {
                                // if the player has been connected, send the object
                                // directly to the player
                                Logger.debugLog(TAG, "About to send state to player");
                                player.sendInfo(gs);
                                Logger.debugLog(TAG, "... done sending state");
                            }
                        }
                    }
                    else {
                        // ignore if the object is not a GameInfo object
                        Logger.debugLog(TAG, "Object NOT being sent to player");
                    }
                }
                catch (Exception x) {
                    // if any other exception occurs, log it
                    Logger.log(TAG, "Class: "+x.getClass().toString()+ "   Message: " + x.getMessage(), Logger.ERROR);
                }
            }
        };
    }

    /**
     * Method used by player to send an action to this Game object.
     *
     * @param action  the action object to apply
     */
    public final void sendAction(GameAction action) {
        // Send the action across the socket, nulling out the player in
        // the action so that the entire player is not serialized.
        if (action != null) {
            action.setPlayer(null);
            networkPasser.sendObject(action);
        }
    }

    /**
     * Starts the game. In this context, we know that the array will
     * contain exactly one player.
     */
    public void start(GamePlayer[] players) {
        Logger.debugLog(TAG, "Starting");

        // if player has already been bound, ignore
        if (player != null){
            Logger.debugLog(TAG, "Player "+player.getClass()+" already bound");
            return;
        }

        // if the player array somehow something other than
        // a single element, ignore
        if (players.length != 1){
            Logger.debugLog(TAG, "The Player array is the incorrect size");
            return;
        }

        // start the player
        if (players[0] != null) {
            Logger.debugLog(TAG, "Starting Player");
            players[0].start(); // start our player
        }

        // loop through and empty (and send) the objects that might have
        // accumulated in the queue before the player was bound
        for (;;) {
            GameInfo unqueuedObject;
            synchronized (this) {
                if (queuedObjectsForPlayer.isEmpty()) {
                    // queue is finally empty: bind player and return
                    player = players[0];
                    return;
                }
                else {
                    // queue not empty, so remove an object from the queue
                    unqueuedObject = queuedObjectsForPlayer.remove();
                }
            }

            // send the just=unqueued object to the player
            Logger.debugLog(TAG, "Sending queued object to player: "+unqueuedObject.getClass());
            players[0].sendInfo(unqueuedObject);
        }
    }

    /**
     * returns null because network saving is not implemented yet.
     *
     * @return GameState
     */
    @Override
    public GameState getGameState(){
        return null;
    }
}

