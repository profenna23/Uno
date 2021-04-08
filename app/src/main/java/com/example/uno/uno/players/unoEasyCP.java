package com.example.uno.uno.players;

import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;

public class unoEasyCP extends GameComputerPlayer {

    /*
     * Constructor for the unoEasyCP class
     */
    public unoEasyCP(String name) {
        // invoke superclass constructor
        super(name);
    }

    /**
     * Called when the player receives a game-state (or other info) from the
     * game.
     *
     * @param info
     * 		the message from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // if gameinfo is a gamestate obj
        // randomly pick card from hand
        // take game, send new playcard action

        game.sendAction(new unoPlayCard(cardToPlay));

    }
}
