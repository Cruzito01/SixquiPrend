package com.example.sixquiprend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onPlayButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}