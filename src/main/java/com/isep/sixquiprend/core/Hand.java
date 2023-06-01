package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cardsinhand;

    public Hand(){
        this.cardsinhand=new ArrayList<>();
    }

    public List<String> getCardsinhandAsString() {
        List<String> cards=new ArrayList<>();
        for (Card card:cardsinhand){
            cards.add("card number "+ card.getCardsnumber()+" ( "+card.getHeadofbeef()+" head of beef )");
        }
        return cards;
    }
    public Card getNumbercardinhand(int cardnumber){
        for (Card card:cardsinhand){
            if (card.getCardsnumber()==cardnumber){
                return card;
            }
        }return null;
    }

    public boolean hascardinhishand(int cardnumber){
        for (Card card:cardsinhand){
            if(card.getCardsnumber()==cardnumber){
                return true;
            }
        }return false;
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
