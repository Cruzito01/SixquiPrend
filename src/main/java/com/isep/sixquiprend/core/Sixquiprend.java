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
        this.board= new Board ();
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
        // affichage de la main du joueur
        for(Player player:players){
            System.out.println(player.getName()+"'s"+player.getHand().getCardsinhandAsString());
        }

        //distribution des 4carte sur le plateau
        for(int i=0;i<4;i++){
            Card card = drawcard.remove(0);
            board.getCardsonboard().add(card);
        }
        System.out.println("card on board:\n");
        for (Card card: board.getCardsonboard()){
            System.out.println("card number "+card.getCardsnumber()+" ( "+ card.getHeadofbeef()+" head of beef )\n");
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    // choix de la carte qu'ils vont jouer

    public void PlayingcardSelection(Player player){
        System.out.println(player.getName()+" choose the card you want to play this round");
        System.out.println("your hand consists of : "+ player.getHand().getCardsinhandAsString());

        Scanner scanner=new Scanner(System.in);
        int cardnumber;
        boolean validcard;
        do {
            System.out.println("Enter your choice");
            cardnumber= scanner.nextInt();
            validcard=player.getHand().hascardinhishand(cardnumber);
            if (!validcard){
                System.out.println("your selection is not in your hand! Please choose again");
            }
        }while (!validcard);
        Card selectedcard=player.getHand().getNumbercardinhand(cardnumber);
        System.out.println("you have selected card number: "+selectedcard.getCardsnumber()+" with "+selectedcard.getHeadofbeef()+" head of beef");


    }
    public void placeofcardinboard(Player player, Card selectedCard) {
        List<Card> cardsOnBoard = board.getCardsonboard();

        // Trouver la carte sur le plateau avec la plus petite différence
        Card nearestCard = findNearestCard(cardsOnBoard, selectedCard);

        // Insérer la carte sélectionnée près de la carte la plus proche
        int insertionIndex = cardsOnBoard.indexOf(nearestCard) + 1;
        cardsOnBoard.add(insertionIndex, selectedCard);

        // Afficher les cartes sur le plateau après l'insertion
        System.out.println("Cards on board after placing the selected card:");
        for (Card card : cardsOnBoard) {
            System.out.println("Card number " + card.getCardsnumber() + " (" + card.getHeadofbeef() + " head of beef)");
        }

        // Retirer la carte de la main du joueur
        player.getHand().removeCard(selectedCard);
    }

    private Card findNearestCard(List<Card> cardsOnBoard, Card selectedCard) {
        // Trouver la carte sur le plateau avec la plus petite différence
        Card nearestCard = cardsOnBoard.get(0);
        for (Card card : cardsOnBoard) {
            if (Math.abs(card.getCardsnumber() - selectedCard.getCardsnumber()) < Math.abs(nearestCard.getCardsnumber() - selectedCard.getCardsnumber())) {
                nearestCard = card;
            }
        }
        return nearestCard;
    }




}
