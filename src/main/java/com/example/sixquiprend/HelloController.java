package com.example.sixquiprend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Button btnPlay;
    @FXML
    private Button BackButton;
    @FXML
    private void onPlayButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if(event.getSource()==btnPlay){
            stage=(Stage) btnPlay.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageInscription.fxml")));
        }
        else{
            stage=(Stage) BackButton.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Page1.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}