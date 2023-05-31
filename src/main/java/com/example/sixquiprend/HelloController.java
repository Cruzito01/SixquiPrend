package com.example.sixquiprend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    private ListView<String> playersListView;

    @FXML
    private TextField nameInput;

    public void handleAddPlayerButton(ActionEvent event) {
        String playerName = nameInput.getText();
        if (!playerName.isEmpty()) {
            ObservableList<String> items = playersListView.getItems();
            items.add(playerName);
            nameInput.clear();
        }
    }

    @FXML
    private Button buttonRemoveLastPlayer;

    @FXML
    public void handleRemoveLastPlayerButton(ActionEvent event) {
        ObservableList<String> items = playersListView.getItems();
        if (!items.isEmpty()) {
            int lastIndex = items.size() - 1;
            items.remove(lastIndex);
        }
    }

    @FXML
    private Button buttonGoToBoard;
    @FXML
    private Label errorLabel;

    @FXML
    public void handleGoToBoardButton(ActionEvent event) throws IOException {
        ObservableList<String> items = playersListView.getItems();
        int numPlayers = items.size();

        if (numPlayers >= 1 && numPlayers <= 10) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PageBoard.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Fermer la fenêtre actuelle si nécessaire
                Stage currentStage = (Stage) buttonGoToBoard.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setVisible(true);
            // Afficher un message d'erreur ou une notification indiquant les conditions requises
        }

    }
}