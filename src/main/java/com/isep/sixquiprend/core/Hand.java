package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cardsinhand;

    public Hand(){
        this.cardsinhand=new ArrayList<>();
    }

    public List<Card> getCardsinhand() {
        return cardsinhand;
    }

    public void setCardsinhand(List<Card> cardsinhand) {
        this.cardsinhand = cardsinhand;
    }

    public void addCard(Card card){
        cardsinhand.add(card);
    }

    public void removeCard(Card card){
        cardsinhand.remove(card);
    }
}
