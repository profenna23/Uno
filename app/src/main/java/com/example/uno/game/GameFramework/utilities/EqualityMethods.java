package com.example.uno.game.GameFramework.utilities;
/* Methods to make your life easier when write equals methods
 *
 * @author Eric Imperio
 * @version Spring 2020
 */
public class EqualityMethods {

    //Compares two general object arrays by using their equals method
    //NOTE: If this will compare classes you wrote, you have to write the equal method for that class
    //NOTE: Will not compare primitive types below is the comparison for int and boolean arrays
    public static <T> boolean arrayEquals(T[] arr1, T[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == null && arr2[i] == null){ continue; }
            if(!arr1[i].equals(arr2[i])){
                return false;
            }
        }
        return true;
    }

    //This compares arrays of ints because Java doesn't accept primitives as general objects
    public static boolean arrayEquals(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    //This compares arrays of booleans because Java doesn't accept primitives as general objects
    public static boolean arrayEquals(boolean[] arr1, boolean[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    //Compares two general object arrays of two dimensions by using their equals method
    //NOTE: If this will compare classes you wrote, you have to write the equal method for that class
    //NOTE: Will not compare primitive types below is the comparison for int and boolean arrays
    public static <T> boolean doubleArrayEquals(T[][] arr1, T[][] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(!arrayEquals(arr1[i],arr2[i])){
                return false;
            }
        }
        return true;
    }

    //This compares double arrays of ints because Java doesn't accept primitives as general objects
    public static boolean doubleArrayEquals(int[][] arr1, int[][] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(!arrayEquals(arr1[i],arr2[i])){
                return false;
            }
        }
        return true;
    }

    //This compares double arrays of booleans because Java doesn't accept primitives as general objects
    public static boolean doubleArrayEquals(boolean[][] arr1, boolean[][] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(!arrayEquals(arr1[i],arr2[i])){
                return false;
            }
        }
        return true;
    }
}
