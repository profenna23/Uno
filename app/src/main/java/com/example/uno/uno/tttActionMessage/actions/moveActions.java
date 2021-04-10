package com.example.uno.actions;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class moveActions extends GameAction {
    //public int getPlayer;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public moveActions(GamePlayer player) {
        super(player);

    }
}
