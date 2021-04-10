package com.example.uno.uno.tttActionMessage.actions;

import com.example.uno.Card;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoPlayCard extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public unoPlayCard(GamePlayer player, Card cardToPlay) {
        super(player);
    }

    // constructor - takes cardToPlay & player
    // 2 getters (2 instance variables)
}


