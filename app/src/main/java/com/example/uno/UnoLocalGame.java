package com.example.uno;

import android.util.Log;

import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.uno.tttActionMessage.actions.unoDrawCard;
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
           int cardPlayed = playCard.cardPlayed();
           int playerID = getPlayerIdx(playCard.getPlayer());
           
           // get num of players
           GamePlayer[] players = getPlayers();
           int playersNum = players.length;

           if(playerID == 0) {
               (state.getDiscardPile()).add(state.getCardsInHandP1().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
               state.getCardsInHandP1().remove(cardPlayed);
               state.getCardsInHandP1().trimToSize();

               // if 2,3, or 4 players:
               state.setPlayerTurn(1);

               return true;
           }
            if(playerID == 1) {
                (state.getDiscardPile()).add(state.getCardsInHandP2().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP2().remove(cardPlayed);
                state.getCardsInHandP2().trimToSize();

                if (playersNum == 2){
                    // if only 2 players:
                    state.setPlayerTurn(0);
                } else {
                    // if 3 or 4 players:
                    state.setPlayerTurn(2);
                }

                return true;
            }
            if(playerID == 2) {
                (state.getDiscardPile()).add(state.getCardsInHandP3().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP3().remove(cardPlayed);
                state.getCardsInHandP3().trimToSize();

                if (playersNum == 3){
                    // if 3 players:
                    state.setPlayerTurn(0);
                } else if (playersNum == 4){
                    // if 4 players:
                    state.setPlayerTurn(3);
                }

                return true;
            }
            if(playerID == 3) {
                (state.getDiscardPile()).add(state.getCardsInHandP4().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                state.getCardsInHandP4().remove(cardPlayed);
                state.getCardsInHandP4().trimToSize();

                // if 4 players:
                state.setPlayerTurn(0);

                return true;
            }
        }
        if(action instanceof unoDrawCard) {
            unoDrawCard playCard = (unoDrawCard) action;
            UnoState state = (UnoState) super.state;
            if(state.getDrawPile().size() == 0) {
                state.reshuffle();
            }
            int playerID = getPlayerIdx(playCard.getPlayer());

            // get num of players
            GamePlayer[] players = getPlayers();
            int playersNum = players.length;

            if(playerID == 0 ) {
                state.getCardsInHandP1().add(state.getDrawPile().get(0));
                state.getDrawPile().remove(0);
                state.getDrawPile().trimToSize();

                // if 2,3, or 4 players:
                state.setPlayerTurn(1);

                return true;
            }
            if(playerID == 1) {
                state.getCardsInHandP2().add(state.getDrawPile().get(0));
                state.getDrawPile().remove(0);
                state.getDrawPile().trimToSize();

                if (playersNum == 2){
                    // if only 2 players:
                    state.setPlayerTurn(0);
                } else {
                    // if 3 or 4 players:
                    state.setPlayerTurn(2);
                }

                return true;
            }
            if(playerID == 2) {
                state.getCardsInHandP3().add(state.getDrawPile().get(0));
                state.getDrawPile().remove(0);
                state.getDrawPile().trimToSize();

                if (playersNum == 3){
                    // if 3 players:
                    state.setPlayerTurn(0);
                } else if (playersNum == 4){
                    // if 4 players:
                    state.setPlayerTurn(3);
                }

                return true;
            }
            if(playerID == 3) {
                state.getCardsInHandP4().add(state.getDrawPile().get(0));
                state.getDrawPile().remove(0);
                state.getDrawPile().trimToSize();

                // if 4 players:
                state.setPlayerTurn(0);

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
            //if action is unoExit
            //then use constructor to get player

            }

        return false;
    }

    @Override
    protected boolean unoRestart(GameAction action) {
        return false;
    }

    @Override
    protected boolean unoHelp(GameAction action) {
        return false;
    }

}
