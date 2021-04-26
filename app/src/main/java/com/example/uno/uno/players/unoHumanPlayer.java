package com.example.uno.uno.players;

import android.graphics.Canvas;
import android.util.Log;
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
     * @param name
     * 		the player's name
     * @param layoutId
     *      the id of the layout to use
     */
    public unoHumanPlayer(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
    }

    /**
     * returns the GUI's top view
     *
     * @return
     * 		the GUI's top view
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
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // draw method - updates screen
        // if gameinfo instanceof gamestate

        if (info instanceof GameState){
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

        //surfaceView = myActivity.findViewById(R.id.unoSurfaceView)

        //setting the hand's on click listeners
        ImageButton firstCard = (ImageButton)activity.findViewById(R.id.p1card1);
        ImageButton secondCard = (ImageButton)activity.findViewById(R.id.p1card2);
        ImageButton thirdCard = (ImageButton)activity.findViewById(R.id.p1card3);
        ImageButton fourthCard = (ImageButton)activity.findViewById(R.id.p1card4);
        ImageButton fifthCard = (ImageButton)activity.findViewById(R.id.p1card5);
        ImageButton sixthCard = (ImageButton)activity.findViewById(R.id.p1card6);
        ImageButton seventhCard = (ImageButton)activity.findViewById(R.id.p1card7);
        firstCard.setOnClickListener(this);
        secondCard.setOnClickListener(this);
        thirdCard.setOnClickListener(this);
        fourthCard.setOnClickListener(this);
        fifthCard.setOnClickListener(this);
        sixthCard.setOnClickListener(this);
        seventhCard.setOnClickListener(this);
        Log.e("setAsGUI", "finished linking clicks");
    }

    /**
     * callback method when the a button is played. We're
     * looking for a button clicked
     *
     */
    @Override
    public void onClick(View v) {
        // which view, which button pressed
        // if button = card1
        // then send action to game that plays card

        if (v.getId() == R.id.exitButton){
            // send action to exit
            game.sendAction(new unoExit(this));
        }

        if (v.getId() == R.id.restartButton){
            // send action to restart game
            game.sendAction(new unoRestart(this));
        }

        if (v.getId() == R.id.helpButton){
            // send action to pull up help menu
            game.sendAction(new unoHelp(this));
        }

        if(v.getId() == R.id.p1card1){
            Log.e("onClick", "sending human card 0");
            game.sendAction(new unoPlayCard(this, 0));
        }
        Log.e("onClick", "did nothign w click");

        //same for all cards




        //game.sendAction(new unoPlayCard(this, cardToPlay));

    }


}
