package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Card> cardsonboard;

    public void setCardsonboard(List<Card> cardsonboard) {
        this.cardsonboard = cardsonboard;
    }

    public List<Card> getCardsonboard() {
        return cardsonboard;
    }

    public Board(){
        this.cardsonboard= new ArrayList<>();
    }

    public void clearBoard(){
        cardsonboard.clear();
    }

}
