package com.example.sixquiprend;
import java.util.ArrayList;
import java.util.List;
public class Players {

    public static List<String> players = new ArrayList<String>();
    public static void playersList(){
        List<String> players = (HelloController.getPlayersListView().getItems());

    }

}
