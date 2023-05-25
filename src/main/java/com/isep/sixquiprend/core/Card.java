package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    private int cardsnumber;
    private int headofbeef;

    public Card(int cardsnumber,int headofbeef) {
        this.cardsnumber= cardsnumber;
        this.headofbeef=headofbeef;
    }
    public int getCardsnumber(){
        return cardsnumber;
    }

    public void setCardsnumber(int cardsnumber) {
        this.cardsnumber = cardsnumber;
    }

    public int getHeadofbeef() {
        return headofbeef;
    }

    public void setHeadofbeef(int headofbeef) {
        this.headofbeef = headofbeef;
    }

    public static List<Card> generatecards() {
        List<Card> generatecards = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            numbers.add(i);
        }
        Random random = new Random();
        for (int i = 1; i <= 104; i++) {
            int number = numbers.get(i);
            int headofbeef = 0;
            if (number % 10 == 5) {
                headofbeef += 2;
            } else if (number % 10 == 0) {
                headofbeef += 3;
            } else if (number % 11 == 0) {
                headofbeef += 5;
            }
            Card card = new Card(number, headofbeef);
            generatecards.add(card);
        }

        return generatecards;
    }
}
