package com.isep.sixquiprend.console;

import com.isep.sixquiprend.core.Player;
import com.isep.sixquiprend.core.Sixquiprend;

import java.util.List;

public class Main {
    Player  player;
    Sixquiprend sixquiprend;

    public static void main(String[] args){
        Sixquiprend sixquiprend=new Sixquiprend();
        sixquiprend.Startofgame();
        List<Player>players=sixquiprend.getPlayers();
        for (Player player:players){
        //sixquiprend.PlayingcardSelection(player);
        }
    }
}
