package com.example.uno.actions;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoRestart extends GameAction {

    //Tag for logging
    public static final String TAG = "unoRestart";


    /**
     * Constructor for unoRestart
     *
     * @param player - player making the action
     */
    public unoRestart(GamePlayer player) {
        super(player);
    }

}
