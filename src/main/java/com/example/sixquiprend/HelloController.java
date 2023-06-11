package com.example.sixquiprend;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class HelloController {


    @FXML
    private Button btnPlay;
    @FXML
    private Button BackButton;


    @FXML
    private void onPlayButtonClick(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == btnPlay) {
            stage = (Stage) btnPlay.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageInscription.fxml")));
        } else {
            stage = (Stage) BackButton.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Page1.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ListView<String> playersListView;
    @FXML
    private ArrayList<String> players = new ArrayList<>();



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
    private Button NextPlayer;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void handleGoToBoardButton(ActionEvent event) throws IOException {
        //ObservableList<String> items = playersListView.getItems();
        //int numPlayers = items.size();
        int numPlayers = players.size();
        if (numPlayers >= 1 && numPlayers <= 10) {
            PlayersClone playersClone = new PlayersClone();
            playersClone.allPlayers.addAll(players);
            root = FXMLLoader.load(getClass().getResource("PageBoard.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            errorLabel.setVisible(true);
            // Afficher un message d'erreur ou une notification indiquant les conditions requises
        }
    }

    List<String> nextPlayers = new ArrayList<>();
    private int p;

    @FXML
    public void handleStartButton(ActionEvent event) {
        nextPlayers.addAll(PlayersClone.allPlayers);
        StartButton.setDisable(true);
        StartButton.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);


        Image hideSideImage = new Image(Objects.requireNonNull(
                getClass().getResource("/images/cards/backside.png")
        ).toExternalForm());

        handCard1.setImage(hideSideImage);
        handCard2.setImage(hideSideImage);
        handCard3.setImage(hideSideImage);
        handCard4.setImage(hideSideImage);
        handCard5.setImage(hideSideImage);
        handCard6.setImage(hideSideImage);
        handCard7.setImage(hideSideImage);
        handCard8.setImage(hideSideImage);
        handCard9.setImage(hideSideImage);
        handCard10.setImage(hideSideImage);
        p = 0;
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
    public void handleContinueButton(ActionEvent event) {
        ContinueButton.setDisable(true);
        ContinueButton.setOpacity(0);
        NextPlayer.setDisable(false);
        NextPlayer.setOpacity(1);
    }

    @FXML
    public void handlenextPlayerButton(ActionEvent event) {
        Namelabel.setText(nextPlayers.get(p));
        p++;
        if (p == 3) {
            p = 0;
        }
        NextPlayer.setDisable(true);
        NextPlayer.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);
    }


    @FXML
    private RadioButton hideCardsRadioButton;

    @FXML
    public void handleRadioButtonAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageBoard.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (hideCardsRadioButton.isSelected()) {
            // Afficher l'image hideside.png pour toutes les cartes
            Image hideSideImage = new Image(Objects.requireNonNull(
                    getClass().getResource("/images/cards/backside.png")
            ).toExternalForm());

            // getClass().getResourceAsStream("backside.png"));
            handCard1.setImage(hideSideImage);
            handCard2.setImage(hideSideImage);
            handCard3.setImage(hideSideImage);
            handCard4.setImage(hideSideImage);
            handCard5.setImage(hideSideImage);
            handCard6.setImage(hideSideImage);
            handCard7.setImage(hideSideImage);
            handCard8.setImage(hideSideImage);
            handCard9.setImage(hideSideImage);
            handCard10.setImage(hideSideImage);
        }
    }

}


