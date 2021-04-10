package com.example.uno.actions;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoHelp extends GameAction {

    //Tag for logging
    private static final String TAG = "unoHelp";

    /**
     * Constructor for unoHelp
     *
     * @param player - the player making the action
     */
    public unoHelp(GamePlayer player) {
        super(player);
    }

}
