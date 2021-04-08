package com.example.uno.uno.players;

import com.example.uno.game.GameFramework.players.GameComputerPlayer;

public class unoHardCP extends GameComputerPlayer {

    /*
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
        /**
         * Implementation:
         * - read the card on top of discard pile
         * - make a new list of all playable cards
         * - if list is empty:
         *      - draw a card from the draw pile
         * - else:
         *      - if there is a special card, use that first following this order:
         *          - Draw 2
         *          - Skip
         *          - Reverse
         *      - if there are no special cards, try a wild in this order:
         *          - Wild draw 4
         *          - Wild regular color change
         *      - if there are no special or wild cards, use a face card
         */

        // sends action - last line
        game.sendAction(new unoPlayCard(cardToPlay));
    }
}
