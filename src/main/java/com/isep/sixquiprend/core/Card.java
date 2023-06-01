package com.isep.sixquiprend.core;

import java.util.*;

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
        for (int i = 1; i <= 104; i++) {
            int headofbeef=calculheadofbeef(i);
            Card card = new Card(i, headofbeef);
            generatecards.add(card);
        }
        return generatecards;
    }
    private static int calculheadofbeef(int cardnumber){
        int headofbeef = 0;
        if (cardnumber % 10 == 5) {
            headofbeef += 2;
        } else if (cardnumber % 10 == 0) {
            headofbeef += 3;
        } else if (cardnumber % 11 == 0) {
            headofbeef += 5;
        }
        return headofbeef;
    }

}
