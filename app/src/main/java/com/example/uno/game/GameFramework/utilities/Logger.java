package com.example.uno.game.GameFramework.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Logger is a class used for all logging purposes.
 * It can perform regular logging as well as toast logging.
 *
 * @author: Nicole Kister
 */
public class Logger {
    //Tag for logging
    private static final String TAG = "Logger";
    //Switch for knowing if we are in debug mode or not. We assume by default we are not in debug mode
    private static boolean debug = true;
    //Toast only happens after the game starts
    private static boolean toast = false;
    //Context for Toast Logging
    private static Context context = null;
    //How Long should the Toast be Displayed
    private static int LENGTH = Toast.LENGTH_SHORT;
    //Variables for the other types of logging available to students
    public static final int DEBUG = 0;
    public static final int WARN = 1;
    public static final int ERROR = 2;
    public static final int FAILURE = 3;
    //These should be used to set the LENGTH variable for Toasting Length
    public static final int SHORT = Toast.LENGTH_SHORT;
    public static final int LONG = Toast.LENGTH_LONG;


    /**
     * This is for regular logging. All that needs to be passed in are the logging tag and the message
     * Example usage: log("In method of recieveMessage", "Got this far!");
     *
     * @param loggingTag
     * @param logMessage
     */
    public static void log(String loggingTag, String logMessage){
        if(loggingTag.length() > 23){
            Log.wtf("LOGGING ERROR", "Logging Tag ("+loggingTag+") cannot exceed 23 characters");
        }
        else {
            Log.i(loggingTag, logMessage);
        }
        //Toast Logging
        if(toast) {
            Toast.makeText(context, logMessage, LENGTH).show();
        }
    }

    /**
     * This is for logging where the user specifies what type of logging they wish to have
     * Options include error, debug (which is different than our debugLog method), and warn
     * If none of these specific words are passed in then the regular Log.i will be used and a
     * message will be supplied saying the default was used because the word they passed in was not
     * one of the valid logging options.
     * The options to pass in are found in the logger object.
     * Example usage: l.log("In method of recieveInfo", "This shouldn't happen!", "l.ERROR");
     *
     * @param loggingTag
     * @param logMessage
     * @param logType
     */
    public static void log(String loggingTag, String logMessage, int logType){
        switch (logType){
            //Debug logging
            case DEBUG:
                if(debug){
                    Log.d(loggingTag, logMessage);
                }
                break;
            //Warning logging
            case WARN:
                Log.w(loggingTag, logMessage);
                break;
            //Error logging
            case ERROR:
                Log.e(loggingTag, logMessage);
                break;
            //Failure logging
            case FAILURE:
                Log.wtf(loggingTag, logMessage);
                break;
            //If something other than the three cases is passed in, use default logging
            default:
                Log.i(loggingTag, logMessage);
                Log.w("LOGGER WARNING:", "The optional logging parameter passed in did not" +
                        "match one of the given logging types. See the Logger Class for more information.");
                break;
        }
        //Toast logging
        if(toast && (debug || !debug && logType != DEBUG)) {
            Toast.makeText(context, logMessage, LENGTH).show();
        }
    }

    /**
     * The debug logging will use Log.i logging, however it the messages will only appear if the
     * debug mode checkbox is selected.
     * If the logger object is created with no information about if we are in debug mode or not, we
     * assume by default the game is not in debug mode (this is the case where the student doesn't
     * pass in the game.debug to the Logger's constructor).
     *
     * @param loggingTag
     * @param logMessage
     */
    public static void debugLog(String loggingTag, String logMessage){
        if (debug){
            Log.d(loggingTag, logMessage);
        }

        //If debug mode isn't selected, we won't do anything.
    }

    //Getters and setters
    public static boolean getDebugValue(){
        return debug;
    }

    public static boolean getToastValue(){
        return toast;
    }

    public static void setDebugValue(boolean newDebug){
        debug = newDebug;
    }

    public static void setToastValue(boolean newToast){
        toast = newToast;
    }

    public static void setContext(Context newContext){
        context = newContext;
    }

    public static void setLength(int length){
        LENGTH = length;
    }
}
