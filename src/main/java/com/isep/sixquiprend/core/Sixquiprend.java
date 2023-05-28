package com.isep.sixquiprend.core;

import java.util.ArrayList;
import java.util.Collections;
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
        board.clearBoard();

        // pioche

        List<Card> drawcard=Card.generatecards();
        //melange pioche pour distribution
        Collections.shuffle(drawcard);
        // distribution
        for (Player player:players){
            for(int i=0;i<10; i++){
                Card card=drawcard.remove(0);
                player.getHand().addCard(card);
            }


        }
        // affichage de la main
        for(Player player:players){
            System.out.println(player.getName()+"'s"+player.getHand().getCardsinhand());
        }

        for(int i=0;i<4;i++){
            Card card = drawcard.remove(0);
            board.getCardsonboard().add(card);
        }
        System.out.println("card on board:");
        for (Card card: board.getCardsonboard()){
            System.out.println(card);
        }

    }


}
