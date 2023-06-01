package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<String> cardsonboardAsstring;
    List<Card> cardsonboard;
    public Board(){
        cardsonboard=new ArrayList<>();
        cardsonboardAsstring=new ArrayList<>();
    }

    public List<Card> getCardsonboard() {
        return cardsonboard;
    }

    public void setCardsonboard(List<Card> cardsonboard) {
        this.cardsonboard = cardsonboard;
    }

    public List<String> getCardsonboardAsstring() {
        return getCardsonboardAsstring();
    }

    public void clearBoard(){
        cardsonboard.clear();
    }

}
