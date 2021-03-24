package com.example.uno.game.GameFramework.utilities;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * A SurfaceView which allows which that implements a 'flash' operation.
 *
 * @author Steve Vegdahl
 * @version 23 September 2016
 *
 *
 */
public class FlashSurfaceView extends SurfaceView {
    //Tag for logging
    private static final String TAG = "FlashSurfaceView";
    // handler for our creator's thread
    private Handler mainHandler;

    // flasher object, which is null unless a "flash" is in progress
    private Flasher flasher;

    /**
     * Constructor for the TTTSurfaceView class.
     *
     * @param context - a reference to the activity this animation is run under
     */
    public FlashSurfaceView(Context context) {
        super(context);
        init();
    }// ctor

    /**
     * An alternate constructor for use when a subclass is directly specified
     * in the layout.
     *
     * @param context - a reference to the activity this animation is run under
     * @param attrs   - set of attributes passed from system
     */
    public FlashSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }// ctor

    /**
     * Helper-method for the constructors
     */
    private void init() {
        mainHandler = new Handler();
    }// init

    /**
     * Flashes the SurfaceView.
     *
     * @param color color to flash
     * @param millis duration of flash, in milliseconds
     */
    public void flash(int color, int millis) {
        // save the old background, so that we can restore it
        Drawable saveDrawable = this.getBackground();

        // if a flash is already in progress, abort this flash. Otherwise, create
        // a flasher object
        synchronized(this) {
            if (flasher == null) {
                flasher = new Flasher(new ColorDrawable(color), saveDrawable, millis);
            }
            else {
                return;
            }
        }

        // start the flash in a new thread
        new Thread(flasher).start();
    }

    /**
     * helper method: sleeps
     * @param millis duration of sleep, in milliseconds
     */
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException ix) {
        }
    }

    /**
     * helper class to perform the flash
     */
    private class Flasher implements Runnable {

        // Drawable that we should flash
        private Drawable flashDraw;

        // Drawable that is the old background, so that we can restore it
        private Drawable restoreDraw;

        // number of milliseconds for the flash
        private int millis;

        // whether the flash has compeleted
        private boolean done;

        /**
         * constructor
         * @param flashDraw the background drawable for the flash
         * @param restoreDraw the background drawable to restore after the flash
         * @param millis duration of flash, in milliseconds
         */
        public Flasher(Drawable flashDraw, Drawable restoreDraw, int millis) {
            this.flashDraw = flashDraw;
            this.restoreDraw = restoreDraw;
            this.millis = millis;
        }

        /**
         * run method for the Runnable
         */
        public void run() {
            // create two Runnables--one each for flashing and unflashing
            Runnable newRunner1 = new Runnable() {
                public void run() {
                    if (flashDraw != null) {
                        // effect the flash by setting the background and invalidating
                        FlashSurfaceView.this.setBackground(flashDraw);
                        FlashSurfaceView.this.invalidate();
                    }
                }
            };
            Runnable newRunner2 = new Runnable() {
                public void run() {
                    if (restoreDraw != null) {
                        // effect the flash by resetting the background and invalidating
                        FlashSurfaceView.this.setBackground(restoreDraw);
                        FlashSurfaceView.this.invalidate();
                        // let outer thread know we are done
                    }
                    done = true;
                }
            };

            // perform the flash
            mainHandler.post(newRunner1);
            // wait
            sleep(millis <= 0 ? 1 : millis);
            // perform the unflash
            mainHandler.post(newRunner2);
            // wait for the unflash to finish
            while (!done) {
                sleep(10);
            }
            // allow another flash
            flasher = null;
        }

    }
}