package com.example.uno;

import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.uno.tttActionMessage.actions.unoExit;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;

public class UnoLocalGame extends LocalGame {

    public UnoLocalGame() {
        super();

        super.state = new UnoState();
    }

    public UnoLocalGame(UnoState unoState) {

        super();
        super.state = unoState;
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
        return null;



    }

    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof unoPlayCard) {
           unoPlayCard playCard = (unoPlayCard) action;
           UnoState state = (UnoState) super.state;
           int cardPlayed = playCard.getCardtoPlay();
           int playerID = getPlayerIdx(playCard.getPlayer());

           if(playerID == 0 ) {
               (state.getDiscardPile()).add(state.getCardsInHandP1().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
               state.getCardsInHandP1().remove(0);
               state.getCardsInHandP1().trimToSize();
               state.setPlayerTurn(2);

               return true;
           }
            if(playerID == 1) {
                (state.getDiscardPile()).add(state.getCardsInHandP2().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP2().remove(0);
                state.getCardsInHandP2().trimToSize();
                state.setPlayerTurn(3);
                return true;
            }
            if(playerID == 2) {
                (state.getDiscardPile()).add(state.getCardsInHandP3().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP3().remove(0);
                state.getCardsInHandP3().trimToSize();
                state.setPlayerTurn(4);
                return true;
            }
            if(playerID == 3) {
                (state.getDiscardPile()).add(state.getCardsInHandP4().get(cardPlayed); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP4().remove(0);
                state.getCardsInHandP4().trimToSize();
                state.setPlayerTurn(1);
                return true;
            }
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

        }
        return false;
    }
}
