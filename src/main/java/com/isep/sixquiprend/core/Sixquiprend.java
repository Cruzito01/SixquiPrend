package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sixquiprend {

    private Board board;
    private List<Card> cardinhand;
    private List<Player> players;

    public Sixquiprend(){
        this.players= new ArrayList<>();
        this.board= new Board();
        this.cardinhand= new ArrayList<>();
    }

    public void Startofgame(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("choose the number players ho who is play into 1 and 10");
        int numPlayers=scanner.nextInt();

        if (numPlayers<1 || numPlayers>10){
            System.out.println("invalid player numbers");
            return;
        }
        for (int i=0;i<numPlayers;i++){
            System.out.println("enter the name of player"+(i+1) );
            String playername=scanner.next();
            Player player=new Player(playername);
            players.add(player);
        }
        System.out.println("the game can begin!!!");

    }
}
