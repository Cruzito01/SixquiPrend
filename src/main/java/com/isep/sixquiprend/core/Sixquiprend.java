package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Sixquiprend {

    private Board board;
    private List<Card> cardinhand;
    private List<Player> players;

    public Sixquiprend(){
        this.players= new ArrayList<>();
        this.board= new Board();
        this.cardinhand= new ArrayList<>();
    }
}
