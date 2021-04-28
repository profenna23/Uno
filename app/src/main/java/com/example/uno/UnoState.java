package com.example.uno;

import com.example.uno.game.GameFramework.infoMessage.GameState;

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
        discardPile = new ArrayList<>();

        // Set each card in deck
        // Loop for each normal color card from 1-9
        /*for (int i = 0; i < 72; i++) {
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
        }*/

        // adding every card

        // 1:0, 2: 1-9, 2: each action card

        
        // yellow cards:
        for (int i = 0; i < 1; i++) {
            // 1 yellow 0
            Card yellow_0 = new Card(0, 4, "normal");
            deckOfCards.add(yellow_0);
            deckOfCards.get(i).setResId(R.drawable.yellow_0);
        }

        for (int i = 1; i < 3; i++) {
            // 2 yellow 1's
            Card yellow_1 = new Card(1, 4, "normal");
            deckOfCards.add(yellow_1);
            deckOfCards.get(i).setResId(R.drawable.yellow_1);
        }

        for (int i = 3; i < 5; i++) {
            // 2 yellow 2's
            Card yellow_2 = new Card(2, 4, "normal");
            deckOfCards.add(yellow_2);
            deckOfCards.get(i).setResId(R.drawable.yellow_2);
        }

        for (int i = 5; i < 7; i++) {
            // 2 yellow 3's
            Card yellow_3 = new Card(3, 4, "normal");
            deckOfCards.add(yellow_3);
            deckOfCards.get(i).setResId(R.drawable.yellow_3);
        }

        for (int i = 7; i < 9; i++) {
            // 2 yellow 4's
            Card yellow_4 = new Card(4, 4, "normal");
            deckOfCards.add(yellow_4);
            deckOfCards.get(i).setResId(R.drawable.yellow_4);
        }

        for (int i = 9; i < 11; i++) {
            // 2 yellow 5's
            Card yellow_5 = new Card(5, 4, "normal");
            deckOfCards.add(yellow_5);
            deckOfCards.get(i).setResId(R.drawable.yellow_5);
        }

        for (int i = 11; i < 13; i++) {
            // 2 yellow 6's
            Card yellow_6 = new Card(6, 4, "normal");
            deckOfCards.add(yellow_6);
            deckOfCards.get(i).setResId(R.drawable.yellow_6);
        }

        for (int i = 13; i < 15; i++) {
            // 2 yellow 7's
            Card yellow_7 = new Card(7, 4, "normal");
            deckOfCards.add(yellow_7);
            deckOfCards.get(i).setResId(R.drawable.yellow_7);
        }

        for (int i = 15; i < 17; i++) {
            // 2 yellow 8's
            Card yellow_8 = new Card(8, 4, "normal");
            deckOfCards.add(yellow_8);
            deckOfCards.get(i).setResId(R.drawable.yellow_8);
        }

        for (int i = 17; i < 19; i++) {
            // 2 yellow 9's
            Card yellow_9 = new Card(9, 4, "normal");
            deckOfCards.add(yellow_9);
            deckOfCards.get(i).setResId(R.drawable.yellow_9);
        }

        for (int i = 19; i < 21; i++) {
            // 2 yellow skips
            Card yellow_skip = new Card(-1, 4, "skip");
            deckOfCards.add(yellow_skip);
            deckOfCards.get(i).setResId(R.drawable.yellow_skip);
        }

        for (int i = 21; i < 23; i++) {
            // 2 yellow reverse
            Card yellow_reverse = new Card(-2, 4, "reverse");
            deckOfCards.add(yellow_reverse);
            deckOfCards.get(i).setResId(R.drawable.yellow_reverse);
        }

        for (int i = 23; i < 25; i++) {
            // 2 yellow draw2's
            Card yellow_draw2 = new Card(-3, 4, "draw2");
            deckOfCards.add(yellow_draw2);
            deckOfCards.get(i).setResId(R.drawable.yellow_draw2);
        }


        // blue int 25-49 - megan
        //blue 0 (only 1)
        for (int i = 0; i < 1; i++) {
            Card blue_0= new Card(0, 3, "normal");
            deckOfCards.add(blue_0);
            deckOfCards.get(i).setResId(R.drawable.blue_0);
        }
        //blue 1
        for (int i = 1; i < 3; i++) {
            Card blue1 = new Card(1, 3, "normal");
            deckOfCards.add(blue1);
            deckOfCards.get(i).setResId(R.drawable.blue_1);
        }
        //blue 2
        for (int i = 3; i < 5; i++) {
            Card blue_2 = new Card(2, 3, "normal");
            deckOfCards.add(blue_2);
            deckOfCards.get(i).setResId(R.drawable.blue_2);
        }
        //blue 3
        for (int i = 5; i < 7; i++) {
            Card blue_3 = new Card(3, 3, "normal");
            deckOfCards.add(blue_3);
            deckOfCards.get(i).setResId(R.drawable.blue_3);
        }
        //blue 4
        for (int i = 7; i < 9; i++) {
            Card blue_4 = new Card(4, 3, "normal");
            deckOfCards.add(blue_4);
            deckOfCards.get(i).setResId(R.drawable.blue_4);
        }
        //blue 5
        for (int i = 9; i < 11; i++) {
            Card blue_5 = new Card(5, 3, "normal");
            deckOfCards.add(blue_5);
            deckOfCards.get(i).setResId(R.drawable.blue_5);
        }
        //blue 6
        for (int i = 11; i < 13; i++) {
            Card blue_6 = new Card(6, 3, "normal");
            deckOfCards.add(blue_6);
            deckOfCards.get(i).setResId(R.drawable.blue_6);
        }
        //blue 7
        for (int i = 13; i < 15; i++) {
            Card blue_7 = new Card(7, 3, "normal");
            deckOfCards.add(blue_7);
            deckOfCards.get(i).setResId(R.drawable.blue_7);
        }
        //blue 8
        for (int i = 15; i < 17; i++) {
            Card blue_8 = new Card(8, 3, "normal");
            deckOfCards.add(blue_8);
            deckOfCards.get(i).setResId(R.drawable.blue_8);
        }
        //blue 9
        for (int i = 17; i < 19; i++) {
            Card blue_9 = new Card(9, 3, "normal");
            deckOfCards.add(blue_9);
            deckOfCards.get(i).setResId(R.drawable.blue_9);
        }
        //blue skip
        for (int i = 21; i < 23; i++) {
            Card blue_skip = new Card(-1, 3, "skip");
            deckOfCards.add(blue_skip);
            deckOfCards.get(i).setResId(R.drawable.blue_skip);
        }
        //blue reversee
        for (int i = 19; i < 21; i++) {
            Card blue_reverse = new Card(-2, 3, "reverse");
            deckOfCards.add(blue_reverse);
            deckOfCards.get(i).setResId(R.drawable.blue_reverse);
        }


        // red int 50-74 - john

        // green int 75-99 - saylene


        // Sets the wild cards
        for (int i = 100; i < 104; i++) {
            Card wild = new Card(-4, -1, "wild");
            deckOfCards.add(wild);
            deckOfCards.get(i).setResId(R.drawable.wild);
        }

        // Sets the wildDraw4 cards
        for (int i = 104; i < 108; i++) {
            Card wildDraw4 = new Card(-5, -1, "wildDraw4");
            deckOfCards.add(wildDraw4);
            deckOfCards.get(i).setResId(R.drawable.wild_draw4);
        }

        // set all cards & images ^^^^
        // no capitals/spaces in file names



        // Shuffle
        Random rand = new Random();
        for (int i = 0; i < deckOfCards.size(); i++) {
            int randomIdx = rand.nextInt(deckOfCards.size());
            Card temp = deckOfCards.get(randomIdx);
            deckOfCards.set(randomIdx, deckOfCards.get(i));
            deckOfCards.set(i, temp);
        }

        discardPile.add(deckOfCards.get(0));

        // Cards in cpHand = [1-8]
        cardsInHandP1 = new ArrayList<Card>(7);
        for (int i = 0; i < 7; i++) {
            cardsInHandP1.add(i, deckOfCards.get(1+i));

        }

        // Cards in cpHand = [9-16]
        cardsInHandP2 = new ArrayList<Card>(7);
        for (int i = 0; i < 7; i++) {
            cardsInHandP2.add(i, deckOfCards.get(9 + i));

        }

        // Cards in cp3Hand = [17-24]
        cardsInHandP3 = new ArrayList<Card>(7);
        for (int i = 0; i < 7; i++) {
            cardsInHandP3.add(i, deckOfCards.get(17 + i));

        }

        // Cards in cp3Hand = [25-32]
        cardsInHandP4 = new ArrayList<Card>(7);
        for (int i = 0; i < 7; i++) {
            cardsInHandP4.add(i, deckOfCards.get(25 + i));

        }

        drawPile = new ArrayList<Card>(76);
        for (int i = 0; i < 76; i++) {
            drawPile.add(i, deckOfCards.get(33 + i));

        }

        playerTurn = 0;

        // to do: remove this code
        // sets every image to green reverse
        for(int i=0; i<deckOfCards.size(); i++){
            deckOfCards.get(i).setResId(R.drawable.green_reverse);
        }

    }

    public UnoState(UnoState other) {
        playerTurn = other.playerTurn;

        cardsInHandP1 = new ArrayList<>();
        for(int i = 0; i < other.cardsInHandP1.size(); i++) {
            cardsInHandP1.add(new Card(other.cardsInHandP1.get(i)));
            //cardsInHandP1.set(i, other.cardsInHandP1.get(i));
        }

        // same as P1
        cardsInHandP2 = new ArrayList<>();
        for(int i = 0; i < other.cardsInHandP2.size(); i++) {
            cardsInHandP2.add(new Card(other.cardsInHandP2.get(i)));
        }

        cardsInHandP3 = new ArrayList<>();
        for(int i = 0; i < other.cardsInHandP3.size(); i++) {
            cardsInHandP3.add(new Card(other.cardsInHandP3.get(i)));
        }

        cardsInHandP4 = new ArrayList<>();
        for(int i = 0; i < other.cardsInHandP4.size(); i++) {
            cardsInHandP4.add(new Card(other.cardsInHandP4.get(i)));
        }

        deckOfCards = new ArrayList<>();
        for(int i = 0; i < other.deckOfCards.size(); i++) {
            deckOfCards.add(new Card(other.deckOfCards.get(i)));
            //deckOfCards.set(i, other.deckOfCards.get(i));
        }

        discardPile = new ArrayList<>();
        for(int i = 0; i < other.discardPile.size(); i++) {
            discardPile.add(new Card(other.discardPile.get(i)));
            //discardPile.set(i, other.discardPile.get(i));
        }

        drawPile = new ArrayList<>();
        for(int i = 0; i < other.drawPile.size(); i++) {
            drawPile.add(new Card(other.drawPile.get(i)));
            //drawPile.set(i, other.drawPile.get(i));
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

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }
}
