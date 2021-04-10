package com.example.uno;

public class Card {
    private int numOnCard;
    private int colorOnCard; // 1 is Red, 2 is Green, 3 is Blue, 4 is Yellow
    private String typeOfCard;

    public Card(int num, int color, String type) {
        numOnCard = num; // num is -1 for skip, -2 for reverse, -3  for draw2, -4 for wild, -5 for wild+4
        colorOnCard = color;
        typeOfCard = typeOfCard;
    }

    public Card(Card other){
        this.numOnCard = other.numOnCard;
        this.colorOnCard = other.colorOnCard;
        this.typeOfCard = other.typeOfCard;
    }

    public int getNum() {
        return numOnCard;
    }

    public int getColor() {
        return colorOnCard;
    }
    public void setColor(int newColor) {
        colorOnCard = newColor;
    }
    public String getType() {
        return typeOfCard;
    }


    @Override
    public String toString() {
        return String.valueOf(numOnCard) + String.valueOf(colorOnCard) + " " + typeOfCard;
    }
}
