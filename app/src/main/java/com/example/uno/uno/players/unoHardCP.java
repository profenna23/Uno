package com.example.uno.uno.players;

import com.example.uno.Card;
import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;
import com.example.uno.uno.tttActionMessage.actions.unoDrawCard;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;

import java.util.ArrayList;

/**
 * Hard uno computer player -
 * Chooses a playable card from their hand according to a preset order:
 * draw 2, skip, reverse, wild draw 4, wild, facecard
 * to place on top of the discard pile.
 *
 * @author Chiara Profenna
 * @version April 2021
 */
public class unoHardCP extends GameComputerPlayer {

    /**
     * Constructor for the unoHardCP class
     */
    public unoHardCP(String name) {
        // invoke superclass constructor
        super(name);
    }

    /**
     * Called when the player receives a game-state (or other info) from the
     * game.
     *
     * @param info
     * 		the message from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {

        int cardToPlayNum = -1;

        // verify info is an unoState object
        if (!(info instanceof GameState)) return;
        UnoState myState = (UnoState)info;

        // find last card played - on top of discard pile
        Card lastCardPlayed = myState.getDiscardPile().get(0);

        // new arrayList of playable cards
        ArrayList<Card> playableCards = new ArrayList<>();

        // get number of cards in the correct computer player's hand
        int numCards = 0;
        if (playerNum == 1){
            numCards = myState.getCardsInHandP1().size();
        } else if (playerNum == 2){
            numCards = myState.getCardsInHandP2().size();
        } else if (playerNum == 3){
            numCards = myState.getCardsInHandP3().size();
        } else {
            numCards = myState.getCardsInHandP4().size();
        }

        // go through players cards & add playable cards to arrayList
        for (int i=0; i<numCards; i++){

            // gets current card from correct player's deck
            Card currentCard = null;
            if (playerNum == 1){
                currentCard = myState.getCardsInHandP1().get(i);
            } else if (playerNum == 2){
                currentCard = myState.getCardsInHandP2().get(i);
            } else if (playerNum == 3){
                currentCard = myState.getCardsInHandP3().get(i);
            } else {
                currentCard = myState.getCardsInHandP4().get(i);
            }

            // finds all playable cards and adds to list
            if (lastCardPlayed.getColor() == currentCard.getColor()){
                // color matches - add card
                playableCards.add(currentCard);
            } else if (lastCardPlayed.getNum() == currentCard.getNum()){
                // number matches - add card
                playableCards.add(currentCard);
            } else if (currentCard.getNum() == -4 ||currentCard.getNum() == -5){
                // wild card - add card
                playableCards.add(currentCard);
            } else {
                // card is not playable
                continue;
            }
        }

        // number of playable cards
        int numPlayable = playableCards.size();

        if (numPlayable == 0){
            // no playable cards - draw card & turn over
            // NEED DRAWCARD METHOD TO BE COMPLETE
            game.sendAction(new unoDrawCard(this));
        }

        // card object holds the card to be played
        Card cardToPlay = null;

        // loops through playable cards looking for a draw 2 card
        for (int i=0; i<numPlayable; i++) {

            if (playableCards.get(i).getNum()  == -3){
                // if there is a draw 2 card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // loops through playable cards looking for a skip card
        for (int i=0; i<numPlayable; i++) {

            if (cardToPlay == null && playableCards.get(i).getNum() == -1){
                // if there is a skip card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // loops through playable cards looking for a reverse card
        for (int i=0; i<numPlayable; i++) {

            if (cardToPlay == null && playableCards.get(i).getNum() == -2){
                // if there is a reverse card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // loops through playable cards looking for a wild draw 4 card
        for (int i=0; i<numPlayable; i++) {

            if (cardToPlay == null && playableCards.get(i).getNum() == -5){
                // if there is a wild draw 4 card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // loops through playable cards looking for a wild card
        for (int i=0; i<numPlayable; i++) {

            if (cardToPlay == null && playableCards.get(i).getNum() == -4){
                // if there is a wild card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // loops through playable cards looking for a face card
        for (int i=0; i<numPlayable; i++) {

            if (cardToPlay == null && playableCards.get(i).getNum() > 0){
                // if there is a face card - play it
                cardToPlay = playableCards.get(i);
                cardToPlayNum = i;
            }

        }

        // sends action
        game.sendAction(new unoPlayCard(this, cardToPlayNum));

    }

}
