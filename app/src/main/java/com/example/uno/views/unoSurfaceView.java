package com.example.uno.views;

import android.content.Context;
import android.util.AttributeSet;

import com.example.uno.UnoState;
import com.example.uno.game.GameFramework.utilities.FlashSurfaceView;

public class unoSurfaceView extends FlashSurfaceView {
    //from Tic Tac Toe (tag for logging)
    private static final String TAG = "UnoSurfaceView";

    //the game's state
    protected UnoState state;

    //look at height/width/base parameters - what do we need from these?

    /**
     * Constructor for unoSurfaceView class.
     *
     * @param context - a reference to the activity this "animation is run under"
     *
     */

    public unoSurfaceView(Context context) {
        super(context);
        init();
    } //ctor

    /**
     * An alternate constructor for use when a subclass is directly specified
     * in the layout.
     *
     * @param context - a reference to the activity this "animation is run under"
     * @param attrs - set of attributes passed from system
     */

    public unoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Helper-method for the constructors
     */
    private void init() {
        setBackgroundColor(backgroundColor()); //init
    }


    /**
     * callback method, called whenever
     */
}