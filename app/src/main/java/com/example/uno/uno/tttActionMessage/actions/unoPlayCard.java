package com.example.uno.uno.tttActionMessage.actions;

import com.example.uno.Card;
import com.example.uno.UnoLocalGame;
import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoPlayCard extends GameAction {
    private GamePlayer playerID;
    private int cardPlayed;

    /**
     * constructor for GameAction
     *
     * @param playerID the player who created the action
     */
    public unoPlayCard(GamePlayer playerID, int cardPlayed) {
        super(playerID);
        //2 getters
        //player - who's playing,
        //onclick sends that command -- how do i implement this
        //local game will use the info to set the game
        this.playerID = playerID;
        this.cardPlayed = cardPlayed;
    }
    public GamePlayer playerID(){
        return playerID;
    }
    public int cardPlayed(){
        return cardPlayed;
    }

}


