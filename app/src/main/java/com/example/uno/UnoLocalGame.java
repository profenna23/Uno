package com.example.uno;

import com.example.uno.game.GameFramework.LocalGame;
import com.example.uno.game.GameFramework.actionMessage.GameAction;
import com.example.uno.game.GameFramework.players.GamePlayer;
import com.example.uno.uno.tttActionMessage.actions.unoDrawCard;
import com.example.uno.uno.tttActionMessage.actions.unoExit;
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

        if(state.getCardsInHandP1().size() == 0) { //&& state.getCardsInHandP1().get(0) != null
            return "Player 1 has won!";
        }
        if(state.getCardsInHandP2().size() == 0) {
            return "Player 2 has won!";
        }
        if(state.getCardsInHandP3().size() == 0) {
            return "Player 3 has won!";
        }
        if(state.getCardsInHandP4().size() == 0) {
            return "Player 4 has won!";
        }
        return null;



    }

    public boolean isValid(Card desiredPlay, Card lastPlayed){

        if (lastPlayed.getNum() == -4 || lastPlayed.getNum() == -5){
            // previous was a wild, anything is valid
            return true;
        }
        if (desiredPlay.getNum() == lastPlayed.getNum()){
            // number matches; valid move
            return true;
        } else if (desiredPlay.getColor() == lastPlayed.getColor()){
            // color matches; valid move
            return true;
        } else if (desiredPlay.getNum() == -4 || desiredPlay.getNum() == -5){
            // wild card; valid move
            return true;
        } else {
            // card is not valid
            return false;
        }
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

           // get the last card played
           int lastCardPlayed = state.getDiscardPile().size() -1;
           Card lastPlayed = state.getDiscardPile().get(lastCardPlayed);

           // get the card the player wants to play
           Card playersCard = null;
           if(playerID == 0) {
               playersCard = state.getCardsInHandP1().get(cardPlayed);
           } else if (playerID == 1){
               playersCard = state.getCardsInHandP2().get(cardPlayed);
           } else if (playerID == 2){
               playersCard = state.getCardsInHandP3().get(cardPlayed);
           } else {
               playersCard = state.getCardsInHandP4().get(cardPlayed);
           }

            int numRed = 0;
            int numGreen = 0;
            int numBlue = 0;
            int numYellow = 0;
            int changeColorTo = 0;

           if(playerID == 0) {

               if (isValid(playersCard, lastPlayed) == true){

                   /*// wild card function:
                   if (playersCard.getNum() == -4 ||  playersCard.getNum() == -5){
                       // read cards and change color for them
                       for (int i = 0; i < state.getCardsInHandP1().size(); i++){
                           // loop through cards in hand
                           if (state.getCardsInHandP1().get(i).getColor() == 1){
                               numRed++;
                           } else if (state.getCardsInHandP1().get(i).getColor() == 2){
                               numGreen++;
                           } else if (state.getCardsInHandP1().get(i).getColor() == 3){
                               numBlue++;
                           } else if ((state.getCardsInHandP1().get(i).getColor() == 4)){
                               numYellow++;
                           } else {
                               // wild card
                               continue;
                           }
                       }
                       if (numRed >= numGreen && numRed >= numBlue && numRed >= numYellow){
                           changeColorTo = 1;
                           // play another card?
                       } else if (numGreen >= numRed && numGreen >= numBlue && numGreen >= numYellow){
                           changeColorTo = 2;
                       } else if (numBlue >= numRed && numBlue >= numGreen && numBlue >= numYellow){
                           changeColorTo = 3;
                       } else {
                           changeColorTo = 4;
                       }
                   }*/

                   (state.getDiscardPile()).add(state.getCardsInHandP1().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                   state.getCardsInHandP1().remove(cardPlayed);
                   state.getCardsInHandP1().trimToSize();
               }
               else {
                   return false;
               }

               // if 2,3, or 4 players:
               state.setPlayerTurn(1);
               return true;
           }
            if(playerID == 1) {

                if (isValid(playersCard, lastPlayed) == true){
                    (state.getDiscardPile()).add(state.getCardsInHandP2().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                    state.getCardsInHandP2().remove(cardPlayed);
                    state.getCardsInHandP2().trimToSize();
                }

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

                if (isValid(playersCard, lastPlayed) == true){
                    (state.getDiscardPile()).add(state.getCardsInHandP3().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                    state.getCardsInHandP3().remove(cardPlayed);
                    state.getCardsInHandP3().trimToSize();
                }

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

                if (isValid(playersCard, lastPlayed) == true){
                    (state.getDiscardPile()).add(state.getCardsInHandP4().get(cardPlayed)); // 0 needs to be where in the hand the card has been played
                    state.getCardsInHandP4().remove(cardPlayed);
                    state.getCardsInHandP4().trimToSize();
                }

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
        if(action instanceof unoRestart){
            //restart the game
            //Log.e("today", "Restarted");
            //super.state = new UnoState();


        }
        if (action instanceof unoExit) {
            //if action is unoExit
            //exit the game completely
            System.exit(0);
            return true;
        }

        return false;

    }

    @Override
    protected boolean exitGame(GameAction action) { return false; }

    @Override
    protected boolean unoRestart(GameAction action) { return false; }


}
