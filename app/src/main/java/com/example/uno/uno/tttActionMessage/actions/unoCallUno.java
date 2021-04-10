package com.example.uno.uno.tttActionMessage.actions;

import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoCallUno extends GameAction{
    /*
    public int player;
    public int getPlayerTurn(){
        return player;
    }
    /*

     */

    //TAG
    private static final String TAG = "unoCallUno";
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public unoCallUno(GamePlayer player) {
        super(player);

    }
        //GamePlayer unoHumanPlayer = null;
        /*
        if (getPlayerTurn() == 1){
            if(getPlayerTurn().cardsInHandP1.size() == 1){
                System.out.println("Uno!");
            }
        }
        if (getPlayerTurn() == 2){
            if(getPlayerTurn().cardsInHandP2.size() == 1){
                System.out.println("Uno!");
            }
        }
        else {
            System.out.println("You have more than one card left in your hand!");
        }

         */

}
