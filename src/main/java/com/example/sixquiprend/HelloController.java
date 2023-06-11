package com.example.sixquiprend;

import com.isep.sixquiprend.core.Card;
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

import static com.example.sixquiprend.Game.*;


public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //vars
    private int p;
    // Buttons
    @FXML
    private Button btnPlay;
    @FXML
    private Button BackButton;
    @FXML
    private Button StartButton;
    @FXML
    private Button ContinueButton;
    @FXML
    private Button NextPlayer;
    @FXML
    private RadioButton hideCardsRadioButton;

    //label
    @FXML
    private Label errorLabel;
    @FXML
    private Label Namelabel;
    @FXML
    private TextField nameInput;

    //lists
    List<String> nextPlayers = new ArrayList<>();
    @FXML
    private ListView<String> playersListView;
    @FXML
    private ArrayList<String> players = new ArrayList<>();

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
    public void handleGoToBoardButton(ActionEvent event) throws IOException {
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
        }
    }


    @FXML
    public void handleStartButton(ActionEvent event) {
        nextPlayers.addAll(PlayersClone.allPlayers);
        StartButton.setDisable(true);
        StartButton.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);
        Namelabel.setText(nextPlayers.get(p));

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

        cardsPlayer0.add(77);
        cardsPlayer0.add(36);
        cardsPlayer0.add(22);
        cardsPlayer0.add(2);
        cardsPlayer0.add(18);
        cardsPlayer0.add(99);
        cardsPlayer0.add(75);
        cardsPlayer0.add(63);
        cardsPlayer0.add(86);
        cardsPlayer0.add(35);

        cardsPlayer1.add(73);
        cardsPlayer1.add(31);
        cardsPlayer1.add(29);
        cardsPlayer1.add(8);
        cardsPlayer1.add(45);
        cardsPlayer1.add(11);
        cardsPlayer1.add(40);
        cardsPlayer1.add(102);
        cardsPlayer1.add(79);
        cardsPlayer1.add(52);

        cardsPlayer2.add(50);
        cardsPlayer2.add(34);
        cardsPlayer2.add(100);
        cardsPlayer2.add(80);
        cardsPlayer2.add(4);
        cardsPlayer2.add(13);
        cardsPlayer2.add(45);
        cardsPlayer2.add(41);
        cardsPlayer2.add(57);
        cardsPlayer2.add(92);

        card00.setImage(new Image(Objects.requireNonNull(
                getClass().getResource("/images/cards/61.png")
        ).toExternalForm()));
        card01.setImage(new Image(Objects.requireNonNull(
                getClass().getResource("/images/cards/37.png")
        ).toExternalForm()));
        card02.setImage(new Image(Objects.requireNonNull(
                getClass().getResource("/images/cards/7.png")
        ).toExternalForm()));
        card03.setImage(new Image(Objects.requireNonNull(
                getClass().getResource("/images/cards/83.png")
        ).toExternalForm()));
        p = 1;
    }



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
        if (p == nextPlayers.size()) {
            p = 0;
        }
        NextPlayer.setDisable(true);
        NextPlayer.setOpacity(0);
        ContinueButton.setDisable(false);
        ContinueButton.setOpacity(1);
        if (hideCardsRadioButton.isSelected()) {
            // Afficher l'image hideside.png pour toutes les cartes
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
        } else {
            if (p == 0) {
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(0) + ".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(1) + ".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(2) + ".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(3) + ".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(4) + ".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(5) + ".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(6) + ".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(7) + ".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(8) + ".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer0.get(9) + ".png")
                ).toExternalForm()));
            } else if (p == 1) {
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(0) + ".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(1) + ".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(2) + ".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(3) + ".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(4) + ".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(5) + ".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(6) + ".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(7) + ".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(8) + ".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer1.get(9) + ".png")
                ).toExternalForm()));
            } else {
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(0) + ".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(1) + ".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(2) + ".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(3) + ".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(4) + ".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(5) + ".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(6) + ".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(7) + ".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(8) + ".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/" + cardsPlayer2.get(9) + ".png")
                ).toExternalForm()));
            }
        }
    }

    @FXML
    public void handleRadioButtonAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageBoard.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (hideCardsRadioButton.isSelected()) {
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
        } else{
            if (p == 0){
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(0)+".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(1)+".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(2)+".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(3)+".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(4)+".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(5)+".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(6)+".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(7)+".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(8)+".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer0.get(9)+".png")
                ).toExternalForm()));
            } else if (p==1){
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(0)+".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(1)+".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(2)+".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(3)+".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(4)+".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(5)+".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(6)+".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(7)+".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(8)+".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer1.get(9)+".png")
                ).toExternalForm()));
            }
            else {
                handCard1.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(0)+".png")
                ).toExternalForm()));
                handCard2.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(1)+".png")
                ).toExternalForm()));
                handCard3.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(2)+".png")
                ).toExternalForm()));
                handCard4.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(3)+".png")
                ).toExternalForm()));
                handCard5.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(4)+".png")
                ).toExternalForm()));
                handCard6.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(5)+".png")
                ).toExternalForm()));
                handCard7.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(6)+".png")
                ).toExternalForm()));
                handCard8.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(7)+".png")
                ).toExternalForm()));
                handCard9.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(8)+".png")
                ).toExternalForm()));
                handCard10.setImage(new Image(Objects.requireNonNull(
                        getClass().getResource("/images/cards/"+cardsPlayer2.get(9)+".png")
                ).toExternalForm()));
            }

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
    private ImageView card00;
    @FXML
    private ImageView card01;
    @FXML
    private ImageView card02;
    @FXML
    private ImageView card03;

}


