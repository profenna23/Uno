package com.example.uno;

import com.example.uno.game.GameFramework.Game;
import com.example.uno.game.GameFramework.GameMainActivity;
import com.example.uno.game.GameFramework.gameConfiguration.GameConfig;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GamePlayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * UnoState class
 *
 * @@authors Chiara Profenna, John Nicholson, Saylene Hernandez, Megan Ly
 * @version April 2021
 */
public class UnoState extends GameState {
    // ArrayList representing each players hands, needs to find out how many players there are
    private ArrayList<Card> cardsInHandP1;
    private ArrayList<Card> cardsInHandP2;
    private ArrayList<Card> cardsInHandP3;
    private ArrayList<Card> cardsInHandP4;

    // All the deckOfCards as an ArrayList
    // Not needed during play as drawPile is used
    private ArrayList<Card> deckOfCards;
    // Where all the cards go after they're played
    private ArrayList <Card> discardPile;
    private ArrayList<Card> drawPile;



    private int playerTurn;

    




    public UnoState() {

        deckOfCards = new ArrayList<Card>(108);
        // Set each card in deck
        // Loop for each normal color card from 1-9
        for (int i = 0; i < 72; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 9; k++) {
                    Card temp = new Card(k, j, "normal");
                    deckOfCards.add(temp);
                }

            }


        }

        // Sets zero cards
        for (int i = 72; i < 76; i++) {
            Card temp = new Card(0, i - 72, "normal");
            deckOfCards.add(temp);
        }

        // Sets the Skip Cards
        for (int i = 76; i < 84; i++) {
            for (int j = 1; j <= 4; j++) {
                Card temp = new Card(-1, j, "skip");
                deckOfCards.add(temp);
            }
        }

        // Sets the reverse Cards
        for (int i = 84; i < 92; i++) {
            for (int j = 1; j <= 4; j++) {
                Card temp = new Card(-2, j, "reverse");
                deckOfCards.add(temp);
            }
        }

        // Sets the draw 2 cards
        for (int i = 92; i < 100; i++) {
            for (int j = 1; j <= 4; j++) {
                Card temp = new Card(-3, j, "draw2");
                deckOfCards.add(temp);
            }
        }
        // Sets the wild cards
        for (int i = 100; i < 104; i++) {
            Card temp = new Card(-4, -1, "wild");
            deckOfCards.add(temp);
        }
        // Sets the wildDraw4 cards
        for (int i = 104; i < 108; i++) {
            Card temp = new Card(-5, -1, "wildDraw4");
            deckOfCards.add(temp);
        }


        // Shuffle
        Random rand = new Random();
        for (int i = 0; i < deckOfCards.size(); i++) {
            int randomIdx = rand.nextInt(deckOfCards.size());
            Card temp = deckOfCards.get(randomIdx);
            deckOfCards.set(randomIdx, deckOfCards.get(i));
            deckOfCards.set(i, temp);
        }


        discardPile.set(0, deckOfCards.get(0));

        // Cards in hand equal [1-8]
        cardsInHandP1 = new ArrayList<Card>(7);
        for (int i = 0; i < cardsInHandP1.size(); i++) {
            cardsInHandP1.set(i, deckOfCards.get(1+i));

        }


        cardsInHandP2 = new ArrayList<Card>(7);
        for (int i = 0; i < cardsInHandP2.size(); i++) {
            cardsInHandP2.set(i, deckOfCards.get(9 + i));

        }
        // Cards in cpHand = [9-16]

        // Cards in cp3Hand = [17-24]
        cardsInHandP3 = new ArrayList<Card>(7);
        for (int i = 0; i < cardsInHandP2.size(); i++) {
            cardsInHandP2.set(i, deckOfCards.get(17 + i));

        }
        // Cards in cp3Hand = [17-24]

        // Cards in cp3Hand = [25-32]
        cardsInHandP4 = new ArrayList<Card>(7);
        for (int i = 0; i < cardsInHandP2.size(); i++) {
            cardsInHandP2.set(i, deckOfCards.get(25 + i));

        }
        // Cards in cpHand - [25-32]


        drawPile = new ArrayList<Card>(76);
        for (int i = 0; i < drawPile.size(); i++) {
            drawPile.set(i, deckOfCards.get(33 + i));

        }


        playerTurn = 1;

    }

    public UnoState(UnoState other) {
        playerTurn = other.playerTurn;
        for(int i = 0; i < other.cardsInHandP1.size(); i++) {
            cardsInHandP1.set(i, other.cardsInHandP1.get(i));
        }
        for(int i = 0; i < other.cardsInHandP2.size(); i++) {
            cardsInHandP2.set(i, other.cardsInHandP2.get(i));
        }
        for(int i = 0; i < other.cardsInHandP3.size(); i++) {
            cardsInHandP3.set(i, other.cardsInHandP3.get(i));
        }
        for(int i = 0; i < other.cardsInHandP4.size(); i++) {
            cardsInHandP4.set(i, other.cardsInHandP4.get(i));
        }
        for(int i = 0; i < other.discardPile.size(); i++) {
            discardPile.set(i, other.discardPile.get(i));
        }
        for(int i = 0; i < other.drawPile.size(); i++) {
            drawPile.set(i, other.drawPile.get(i));
        }







    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public ArrayList<Card> getCardsInHandP1() {
        return cardsInHandP1;
    }


    public ArrayList<Card> getCardsInHandP2() {
        return cardsInHandP2;
    }

    public ArrayList<Card> getCardsInHandP3() {
        return cardsInHandP3;
    }

    public ArrayList<Card> getCardsInHandP4() {
        return cardsInHandP4;
    }

    public void setDiscardPile(Card card, int idx) {
        discardPile.set(idx, card);
        discardPile.trimToSize();
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }
    public void setPlayerTurn(int turn) {
        playerTurn = turn;
    }

    public ArrayList<Card> getDrawPile() {
        return drawPile;
    }
    public void reshuffle() {
        // Call when drawDeck is empty

        Random rand = new Random();
        for (int i = 1; i < discardPile.size(); i++) {
            int randomIdx = rand.nextInt(discardPile.size());
            Card temp = discardPile.get(randomIdx);
            discardPile.set(randomIdx, discardPile.get(i));
            discardPile.set(i, temp);

            drawPile.add(discardPile.get(i));
            discardPile.remove(i);
        }

    }
}
