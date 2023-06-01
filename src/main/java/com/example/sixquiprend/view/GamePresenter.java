package com.example.sixquiprend.view;

import com.example.sixquiprend.HelloApplication;
import com.isep.sixquiprend.core.Board;
import com.isep.sixquiprend.core.Sixquiprend;
public class GamePresenter {
    HelloApplication application;
    GameView gameview;
    Sixquiprend sixquiprend;

    public GamePresenter(GameView gameview,Sixquiprend sixquiprend,HelloApplication application){
        this.gameview= gameview;
        this.sixquiprend=sixquiprend;
        this.application=application;
    }
}
