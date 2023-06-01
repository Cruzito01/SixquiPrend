package com.example.sixquiprend;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
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

    @FXML
    private ListView<String> playersListView;
    @FXML
    private ArrayList<String> players= new ArrayList<>();

    @FXML
    private TextField nameInput;

    public void handleAddPlayerButton(ActionEvent event) {
        String playerName = nameInput.getText();
        if (!playerName.isEmpty()) {
            ObservableList<String> items = playersListView.getItems();
            items.add(playerName);
            players.add(nameInput.getText());
            nameInput.clear();

        }
    }

    @FXML
    public void handleRemoveLastPlayerButton(ActionEvent event) {
        ObservableList<String> items = playersListView.getItems();
        if (!items.isEmpty()) {
            int lastIndex = items.size() - 1;
            players.remove(lastIndex);
            items.remove(lastIndex);

        }
    }

    @FXML
    private Button buttonGoToBoard;
    @FXML
    private Label errorLabel;
    @FXML
    private Button StartButton;
    @FXML
    private Button ContinueButton;
    @FXML
    private Label Namelabel;
    @FXML
    public void handleGoToBoardButton(ActionEvent event) throws IOException {
        //ObservableList<String> items = playersListView.getItems();
        //int numPlayers = items.size();
        int numPlayers = players.size();

        if (numPlayers >= 1 && numPlayers <= 10) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PageBoard.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            // Fermer la fenêtre actuelle si nécessaire
            Stage currentStage = (Stage) buttonGoToBoard.getScene().getWindow();
            currentStage.close();
        } else {
            errorLabel.setVisible(true);
            // Afficher un message d'erreur ou une notification indiquant les conditions requises
        }
    }

    @FXML
    public void handleStartButton(ActionEvent event) throws IOException {
        StartButton.setDisable(true);
        StartButton.setOpacity(0);
        ContinueButton.setDisable(false);
    }



    //affichage des cartes

    @FXML
    private ImageView handCard1;
    @FXML
    private ImageView handCard2;
    @FXML
    private ImageView handCard3;
    @FXML
    private ImageView handCard4;
    @FXML
    private ImageView handCard5;
    @FXML
    private ImageView handCard6;
    @FXML
    private ImageView handCard7;
    @FXML
    private ImageView handCard8;
    @FXML
    private ImageView handCard9;
    @FXML
    private ImageView handCard10;

    @FXML
    public void handleContinueButton(ActionEvent event) throws IOException {
        ArrayList<String> Allplayers = new ArrayList<>();
        Allplayers.add(0, "Alexandre");
        Allplayers.add(1, "Sherine");
        Allplayers.add(2, "Martin");
        Namelabel.setText(Allplayers.get(0));
    }




    @FXML
    public void handleRadioButtonAction(ActionEvent event) {

    }

}