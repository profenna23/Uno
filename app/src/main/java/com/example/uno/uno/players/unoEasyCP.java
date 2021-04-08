package com.example.uno.uno.players;

import com.example.uno.Card;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.players.GameComputerPlayer;

import java.util.Random;

public class unoEasyCP extends GameComputerPlayer {

    /*
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
        if (info != gamestate obj){
            // if not, exit - else, continue
            exit;
        }

        // 2. read card on top of discard pile
        // find last item in discardPile
        Card lastCardPlayed = // insert last item in discardPile

        // 3. make a list of playable cards
        ArrayList <Card> playableCards;

        // 4. go through players card & add to arraylist
        // use an array of players cards
        // find number of cards in hand
        int numCards;
        for (int i=0; i<numCards; i++){
            // if color or number of cardsInHandP1[i] matches lastCardPlayed
                // add to playableCards list
            // else
                // continue
        }

        // choose random card from playableCards
        Random rndCard = new Random();
        int number = rndCard.nextInt(sizeof(playableCards));
        Card cardToPlay = playableCards[number];


        // sends action - last line
        game.sendAction(new unoPlayCard(cardToPlay));

    }
}
