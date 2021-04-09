package com.example.uno.game.GameFramework.utilities;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.uno.game.GameFramework.infoMessage.GameState;

/**
 * Helper-class for writing and reading save files
 * @author Eric Imperio
 * @version January 2020
 *
 */
public class Saving {
    private static final String TAG = "Saving";

    // These are convenient separator between values for your toString methods
    public static final String SEPARATOR = ":-:";
    public static final String ARRAY_SEPARATOR = ":=:";
    public static final String SECOND_ARRAY_SEPARATOR = ":~:";
    public static final String OBJECT_SEPARATOR = ":_:";
    public static final String SUB_OBJECT_SEPARATOR = ":`:";
    public static final String SECOND_SUB_OBJECT_SEPARATOR = ":--:";


    /**
     * writeToFile, this saves a given string to a file. Designed to save gameStates
     * @param gameState
     *              The String representation of the gameState to save
     * @param fileName
     *              This Name of the file to write to
     * @param context
     *              The current context. (Must not be null).
     */
    public static void writeToFile(GameState gameState, String fileName, Context context) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            out.writeObject(gameState);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            Logger.log(TAG, "File write failed" + e.toString(), Logger.ERROR);
        }
    }

    /**
     * readFromFile, designed to read a file and return the string representation of a gameState
     *
     * @param fileName
     *              The name of the file to read
     * @param context
     *              The current context. (Must not be null).
     * @return String represantion of the gameState to load
     */
    public static GameState readFromFile(String fileName, Context context) {
        try {
            ObjectInputStream in = new ObjectInputStream(context.openFileInput(fileName));
            GameState gameState = (GameState) in.readObject();
            in.close();
            return gameState;
        }
        catch (FileNotFoundException e) {
            Logger.log(TAG, "File not Found: " + e.toString() , Logger.ERROR);
        } catch (IOException e) {
            Logger.log(TAG, "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Logger.log(TAG, "Object not found: " + e.toString());
        }

        return null;
    }

    /**
     * deleteFromFile, designed to delete a file and return whether or not it was deleted successfully
     *
     * @param fileName
     *              The name of the file to read
     * @param context
     *              The current context. (Must not be null).
     * @return String representation of the gameState to load
     */
    public static boolean deleteFromFile(String fileName, Context context) {
        File file = new File(context.getFilesDir().getPath(), fileName);
        return file.delete();
    }
}
