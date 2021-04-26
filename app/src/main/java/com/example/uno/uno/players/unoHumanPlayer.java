package com.example.uno.uno.players;

import android.graphics.Canvas;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.uno.R;
import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.GameMainActivity;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GameHumanPlayer;
import com.example.uno.uno.tttActionMessage.actions.unoExit;
import com.example.uno.uno.tttActionMessage.actions.unoHelp;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;
import com.example.uno.uno.tttActionMessage.actions.unoRestart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class unoHumanPlayer extends GameHumanPlayer implements View.OnClickListener {

    // on clicks/taps - send the game a move (as in cp)
    // this class is the actual GUI interface - links to surfaceView

    //Tag for logging
    private static final String TAG = "UnoHumanPlayer";

    // the surface view
    //private unoSurfaceView surfaceView;

    // the ID for the layout to use
    private int layoutId;

    //the game's state
    protected UnoState state;

    /**
     * constructor
     *
     * @param name     the player's name
     * @param layoutId the id of the layout to use
     */
    public unoHumanPlayer(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
    }

    /**
     * returns the GUI's top view
     *
     * @return the GUI's top view
     */
    @Override
    public View getTopView() {

        return myActivity.findViewById(R.id.top_gui_layout);
    }

    //set's the class state
    public void setState(UnoState state) {
        this.state = state;
    }

    /**
     * callback method, called whenever it's time to redraw frame
     *
     * @param g - the canvas to draw on
     */

    public void onDraw(Canvas g) {
        //not sure what to pull here because tic tac toe has a board (we don't have that)

        //state.getPlayerHandP1.get(i).getColor();

        //if we don't have any state, nothing to draw so its null
        if (state == null) {
            return;
        }

    }

    /**
     * Callback method, called when player gets a message
     *
     * @param info the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // draw method - updates screen
        // if gameinfo instanceof gamestate

        if (info instanceof GameState) {
            // then look at gamestate to figure out what screen should display
            // anything to be drawn - in this method
            UnoState theState = (UnoState)info;

                if (theState.getCardsInHandP1().size() >= 1){
                    ImageButton cardButton = myActivity.findViewById(R.id.p1card1);
                    cardButton.setImageResource(theState.getCardsInHandP1().get(0).getResId());
                }

        }

    }

    /**
     * sets the current player as the activity's GUI
     */
    @Override
    public void setAsGui(GameMainActivity activity) {
        // onCreate method - need to set content view & set listeners
        this.myActivity = activity;
        myActivity.setContentView(layoutId);

        Button exitButton = myActivity.findViewById(R.id.exitButton);
        exitButton.setOnClickListener(this);

        Button restartButton = myActivity.findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);

        Button helpButton = myActivity.findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);

        Button drawButton = myActivity.findViewById(R.id.drawButton);
        drawButton.setOnClickListener(this);


        //surfaceView = myActivity.findViewById(R.id.unoSurfaceView)

        //sets list for card numbers and colors
        List<String> cardValues, cardColors;
        cardValues = new ArrayList<>();
        cardColors = new ArrayList<>();

        //add all the card numbers
        cardValues.add("0");
        cardValues.add("1");
        cardValues.add("2");
        cardValues.add("3");
        cardValues.add("4");
        cardValues.add("5");
        cardValues.add("6");
        cardValues.add("7");
        cardValues.add("8");
        cardValues.add("9");
        cardValues.add("Skip");
        cardValues.add("Reverse");
        cardValues.add("+2");
        cardValues.add("WILD");
        cardValues.add("WILD DRAW FOUR");

        //add all the card colors and wild
        cardColors.add("Blue");
        cardColors.add("Red");
        cardColors.add("Yellow");
        cardColors.add("Green");

        Button cardOne;


        //setting the hand's on click listeners

        Button firstCard = (Button)activity.findViewById(R.id.p1card1);
        Button secondCard = (Button)activity.findViewById(R.id.p1card2);
        Button thirdCard = (Button)activity.findViewById(R.id.p1card3);
        Button fourthCard = (Button)activity.findViewById(R.id.p1card4);
        Button fifthCard = (Button)activity.findViewById(R.id.p1card5);
        Button sixthCard = (Button)activity.findViewById(R.id.p1card6);
        Button seventhCard = (Button)activity.findViewById(R.id.p1card7);

        firstCard.setOnClickListener(this);
        secondCard.setOnClickListener(this);
        thirdCard.setOnClickListener(this);
        fourthCard.setOnClickListener(this);
        fifthCard.setOnClickListener(this);
        sixthCard.setOnClickListener(this);
        seventhCard.setOnClickListener(this);
    }

    /**
     * callback method when the a button is played. We're
     * looking for a button clicked
     */
    public void onClick(View v) {
        // which view, which button pressed
        // if button = card1
        // then send action to game that plays card

        if (v.getId() == R.id.exitButton) {
            // send action to exit
            game.sendAction(new unoExit(this));
        }

        if (v.getId() == R.id.restartButton) {
            // send action to restart game
            game.sendAction(new unoRestart(this));
        }

        if (v.getId() == R.id.helpButton) {
            // send action to pull up help menu
            game.sendAction(new unoHelp(this));
        }

        if(v.getId() == R.id.p1card1){
            game.sendAction(new unoPlayCard(this, 0));
        }


        //same for all cards



        /**
         * Tried to make onClick method so that when the user clicks the draw button
         * it automatically changes the buttons to new cards,
         * not sure how John had this implemented in local game so couldn't figure it out.
         *
         * SIDE NOTE:
         *      For the actual cards the player starts with we need a button to start the game that will
         *      initialize these cards so that we can randomize the button text?
         *
         *      Youtube VID: https://www.youtube.com/watch?v=Jn1e7Vkd2tk
         */


        //game.sendAction(new unoPlayCard(this, cardToPlay));


    }
}
