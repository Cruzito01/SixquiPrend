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
            ObservableList<String> items = getPlayersListView().getItems();
            items.add(playerName);
            players.add(nameInput.getText());
            nameInput.clear();

        }
    }

    @FXML
    public void handleRemoveLastPlayerButton(ActionEvent event) {
        ObservableList<String> items = getPlayersListView().getItems();
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
    @FXML
    public void handleGoToBoardButton(ActionEvent event) throws IOException {
        //ObservableList<String> items = playersListView.getItems();
        //int numPlayers = items.size();
        int numPlayers = players.size();
        if (numPlayers >= 1 && numPlayers <= 10) {
            Players.playersList();
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

    private int p;
    //private final ArrayList<String> Allplayers = new ArrayList<String>();

    @FXML
    public void handleStartButton(ActionEvent event) {
        StartButton.setDisable(true);
        StartButton.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);
        /*Allplayers.add(0, "Alexandre");
        Allplayers.add(1, "Sherine");
        Allplayers.add(2, "Martin");
         */
        p=0;
    }

    private ImageView getHandCardImageView(int index){
        switch (index){
            case 0:
                return handCard1;
            case 1:
                return handCard2;
            case 2:
                return handCard3;
            case 3:
                return handCard4;
            case 4:
                return handCard5;
            case 5:
                return handCard6;
            case 6:
                return handCard7;
            case 7:
                return handCard8;
            case 8:
                return handCard9;
            case 9:
                return handCard10;
            default:
                return null;

        }
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
        Namelabel.setText(Players.players.get(p));
        p++;
        if(p==3){
            p=0;
        }
        NextPlayer.setDisable(true);
        NextPlayer.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);
    }



    @FXML
    private  RadioButton hideCardsRadioButton;

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

    public static ListView<String> getPlayersListView() {
        return playersListView;
    }

    public void setPlayersListView(ListView<String> playersListView) {
        this.playersListView = playersListView;
    }
}


