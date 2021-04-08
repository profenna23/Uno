package com.example.uno.uno.players;

import com.example.uno.game.GameFramework.players.GameComputerPlayer;

public class unoHardCP extends GameComputerPlayer {

    /*
     * Constructor for the unoHardCP class
     */
    public unoHardCP(String name) {
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

    }
}
