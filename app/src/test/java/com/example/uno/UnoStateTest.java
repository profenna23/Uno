package com.example.uno;

import android.graphics.Point;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UnoStateTest {

    @Test
    public void getPlayerTurn() {
        // Chiara
        UnoState state = new UnoState();
        state.setPlayerTurn(1);
        int turn = state.getPlayerTurn();
        assertEquals(turn, 1);
    }

    @Test
    public void getCardsInHandP1() {
        // Chiara
        UnoState state = new UnoState();
        // create 3 new cards
        Card card1 = new Card(0, 1, "normal");
        Card card2 = new Card(1, 2, "normal");
        Card card3 = new Card(-1, 3, "skip");

        // add the cards manually
        state.getCardsInHandP1().set(0, card1);
        state.getCardsInHandP1().set(1, card2);
        state.getCardsInHandP1().set(2, card2);

        // call the getter to get the cards in hand
        ArrayList<Card> handP1 = state.getCardsInHandP1();

        // check if the cards in hand match the manually entered cards
        assertEquals(handP1.get(0), card1);
        assertEquals(handP1.get(1), card2);
        assertEquals(handP1.get(2), card3);
    }

    @Test
    public void getCardsInHandP2() {
        // Chiara
        UnoState state = new UnoState();
        // create 3 new cards
        Card card1 = new Card(2, 3, "normal");
        Card card2 = new Card(3, 4, "normal");
        Card card3 = new Card(-2, 1, "reverse");

        // add the cards manually
        state.getCardsInHandP2().set(0, card1);
        state.getCardsInHandP2().set(1, card2);
        state.getCardsInHandP2().set(2, card2);

        // call the getter to get the cards in hand
        ArrayList<Card> handP2 = state.getCardsInHandP2();

        // check if the cards in hand match the manually entered cards
        assertEquals(handP2.get(0), card1);
        assertEquals(handP2.get(1), card2);
        assertEquals(handP2.get(2), card3);
    }

    @Test
    public void getCardsInHandP3() {
        // Chiara
        UnoState state = new UnoState();
        // create 3 new cards
        Card card1 = new Card(4, 2, "normal");
        Card card2 = new Card(5, 3, "normal");
        Card card3 = new Card(-3, 4, "draw2");

        // add the cards manually
        state.getCardsInHandP3().set(0, card1);
        state.getCardsInHandP3().set(1, card2);
        state.getCardsInHandP3().set(2, card2);

        // call the getter to get the cards in hand
        ArrayList<Card> handP3 = state.getCardsInHandP3();

        // check if the cards in hand match the manually entered cards
        assertEquals(handP3.get(0), card1);
        assertEquals(handP3.get(1), card2);
        assertEquals(handP3.get(2), card3);
    }

    @Test
    public void getCardsInHandP4() {
        // Chiara
        UnoState state = new UnoState();
        // create 3 new cards
        Card card1 = new Card(6, 1, "normal");
        Card card2 = new Card(-4, -1, "wild");
        Card card3 = new Card(-5, 11, "wild+4");

        // add the cards manually
        state.getCardsInHandP4().set(0, card1);
        state.getCardsInHandP4().set(1, card2);
        state.getCardsInHandP4().set(2, card2);

        // call the getter to get the cards in hand
        ArrayList<Card> handP4 = state.getCardsInHandP4();

        // check if the cards in hand match the manually entered cards
        assertEquals(handP4.get(0), card1);
        assertEquals(handP4.get(1), card2);
        assertEquals(handP4.get(2), card3);
    }

}
