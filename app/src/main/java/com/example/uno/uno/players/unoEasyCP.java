package com.example.uno.uno.players;

import com.example.uno.Card;
import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;
import com.example.uno.uno.tttActionMessage.actions.unoDrawCard;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;

import java.util.ArrayList;
import java.util.Random;

/**
 * Easy uno computer player -
 * Randomly chooses a playable card from their hand
 * to place on top of the discard pile.
 *
 * @author Chiara Profenna
 * @version April 2021
 */
public class unoEasyCP extends GameComputerPlayer {

    /**
     * Constructor for the unoEasyCP class
     */
    public unoEasyCP(String name) {
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

        // random number chooses which card to play
        Random rndCard = new Random();
        int number = rndCard.nextInt(numPlayable);

        // sets cardToPlay to be random one chosen
        Card cardToPlay = playableCards.get(number);

        // sends action
        game.sendAction(new unoPlayCard(this, number));

    }
}
