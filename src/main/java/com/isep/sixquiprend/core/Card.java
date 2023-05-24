package com.isep.sixquiprend.core;

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
}
