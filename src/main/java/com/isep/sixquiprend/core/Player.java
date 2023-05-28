package com.isep.sixquiprend.core;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name){
        this.name=name;
        this.hand= new Hand();
    }

    public Hand getHand() {

        return hand;
    }

    public void setHand(Hand hand) {

        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
