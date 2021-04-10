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
        //2 getters
        //player - who's playing,
        //onclick sends that command
        //local game will use the info to set the game
        super(player);
    }

}

