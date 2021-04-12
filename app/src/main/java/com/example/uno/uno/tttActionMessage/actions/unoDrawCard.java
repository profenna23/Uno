package com.example.uno.uno.tttActionMessage.actions;

import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;

public class unoDrawCard extends GameAction {
    //public int player;
    //public int getPlayerTurn(){
      //  return player;
    //}
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public unoDrawCard(GamePlayer player) {
        //drawcard method in gamestate
        //which player is requesting, and this is who they are

        super(player);


    }
}
