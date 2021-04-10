package com.example.uno;

import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.uno.tttActionMessage.actions.unoExit;
import com.example.uno.uno.tttActionMessage.actions.unoHelp;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;
import com.example.uno.uno.tttActionMessage.actions.unoRestart;


public class UnoLocalGame extends LocalGame {

    public UnoLocalGame() {
        super();

        super.state = new UnoState();
    }

    public UnoLocalGame(UnoState unoState) {

        super();
        super.state = new UnoState(unoState);
    }
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new UnoState(((UnoState) state)));

    }

    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == ((UnoState)state).getPlayerTurn();

    }

    @Override
    protected String checkIfGameOver() {

        UnoState state = (UnoState) super.state;

        if(state.getCardsInHandP1().size() == 0 && state.getCardsInHandP1().get(0) != null ) {
            return "Player 1 has won!";
        }
        if(state.getCardsInHandP2().size() == 0 && state.getCardsInHandP2().get(0) != null) {
            return "Player 2 has won!";
        }
        if(state.getCardsInHandP3().size() == 0 && state.getCardsInHandP3().get(0) != null) {
            return "Player 2 has won!";
        }
        if(state.getCardsInHandP4().size() == 0 && state.getCardsInHandP4().get(0) != null) {
            return "Player 2 has won!";
        }



    }

    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof unoPlayCard) {

        }
        // if action is unoPlayCard
        // then use getters to get player & cardToPlay
        // if this players turn
        // then ask gamestate to play card & return true if valid
        return false;
    }

    @Override
    protected boolean exitGame(GameAction action) {
        if (action instanceof unoExit) {
            //if action is unoExit
            //then use constructor to get player

            }

        return false;
    }

    @Override
    protected boolean getHelp(GameAction action) {
        if(action instanceof unoHelp) {

        }
        return false;
    }

    @Override
    protected boolean gameRestart(GameAction action) {
        if(action instanceof unoRestart){

        }
        return false;
    }

}
