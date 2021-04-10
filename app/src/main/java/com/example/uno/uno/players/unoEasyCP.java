package com.example.uno.uno.players;

import com.example.uno.Card;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;

import java.util.ArrayList;
import java.util.Random;

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
        // if gameinfo is a gamestate obj
        // randomly pick card from hand
        // take game, send new playcard action

        /**
         * Implementation:
         * - read the card on top of discard pile
         * - make a new list of all playable cards
         * - if list is empty:
         *      - draw a card from the draw pile
         * - else:
         *      - create a new random that will pick a number from 0-size of playable cards list
         *      - Play the card that corresponds to the number
         */

        // 1. verify gameinfo is a gamestate obj
        if (!(info instanceof GameState)) return;
        GameState myState = (GameState)info;

        // 2. read card on top of discard pile
        // find last item in discardPile

        // first item in discardPile is the last card played
        // NEED TO ACCESS LAST CARD PLAYED
        Card lastCardPlayed = myState.discardPile[0];

        // 3. make a list of playable cards
        ArrayList<Card> playableCards = new ArrayList<>();

        // 4. go through players card & add to arraylist
        // use an array of players cards

        // find number of cards in hand
        // NEED TO ACCESS CP PLAYER HAND
        int numCards = getCardsInHandP2.size();


        for (int i=0; i<numCards; i++){
            // if color or number of cardsInHandP1[i] matches lastCardPlayed
            if (lastCardPlayed.getColor() == getCardsInHandP2[i].getColor()){
                // color matches - add card
                playableCards.add(getCardsInHandP2[i]);
            } else if (lastCardPlayed.getNum() == getCardsInHandP2[i].getNum()){
                // number matches - add card
                playableCards.add(getCardsInHandP2[i]);
            } else if (getCardsInHandP2[i].getNum() == -4 || getCardsInHandP2[i].getNum() == -5){
                // wild card - add card
                playableCards.add(getCardsInHandP2[i]);
            } else {
                // card is not playable
                continue;
            }
        }

        // number of playable cards
        int numPlayable = playableCards.size();

        // random number chooses which card to play
        Random rndCard = new Random();
        int number = rndCard.nextInt(numPlayable);

        // sends cardToPlay to be random one chosen
        Card cardToPlay = playableCards.get(number);

        // sends action
        game.sendAction(new unoPlayCard(this, cardToPlay));

    }
}
