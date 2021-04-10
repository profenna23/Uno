package com.example.uno.uno.tttActionMessage.actions;

import android.widget.Button;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoExit extends GameAction {

    //Tag for logging
    private static final String TAG = "unoExit";

    /**
     * Constructor for GameAction
     *
     * @param player - player who created the action
     */

    public unoExit(GamePlayer player) {
        super(player);
    }

}
