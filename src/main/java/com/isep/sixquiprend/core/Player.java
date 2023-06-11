package com.isep.sixquiprend.core;

public class Player {

    private String name;
    private Hand hand;
    private Card selectedCard;
    ;


    public Player(String name){
        this.name=name;
        this.hand= new Hand();
        this.selectedCard =null ;
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

    public Card getSelectedCard() {
        return selectedCard;

    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }
}
