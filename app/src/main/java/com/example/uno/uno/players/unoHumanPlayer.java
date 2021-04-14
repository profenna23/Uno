package com.example.uno.uno.players;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.uno.R;
import com.example.uno.game.GameFramework.GameMainActivity;
import com.example.uno.game.GameFramework.infoMessage.GameInfo;
import com.example.uno.game.GameFramework.infoMessage.GameState;
import com.example.uno.game.GameFramework.players.GameHumanPlayer;
import com.example.uno.uno.tttActionMessage.actions.unoExit;
import com.example.uno.uno.tttActionMessage.actions.unoHelp;
import com.example.uno.uno.tttActionMessage.actions.unoPlayCard;
import com.example.uno.uno.tttActionMessage.actions.unoRestart;
import com.example.uno.views.unoSurfaceView;

public class unoHumanPlayer extends GameHumanPlayer implements View.OnClickListener {

    // on clicks/taps - send the game a move (as in cp)
    // this class is the actual GUI interface - links to surfaceView

    //Tag for logging
    private static final String TAG = "UnoHumanPlayer";

    // the surface view
    private unoSurfaceView surfaceView;

    // the ID for the layout to use
    private int layoutId;

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

        //surfaceView = myActivity.findViewById(R.id.unoSurfaceView)
    }

    /**
     * callback method when the a button is played. We're
     * looking for a button clicked
     *
     */
    public void onClick(View v) {
        // which view, which button pressed
        // if button = card1
        // then send action to game that plays card

        if (v.getId() == R.id.exitButton){
            // send action to exit
        }


        game.sendAction(new unoPlayCard(this, cardToPlay));


        game.sendAction(new unoExit(this));
        game.sendAction(new unoRestart(this));
        game.sendAction(new unoHelp(this));
    }


}
