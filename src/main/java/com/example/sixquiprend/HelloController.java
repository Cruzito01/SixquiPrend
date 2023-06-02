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
        ArrayList<String> Allplayers = new ArrayList<>();
        Allplayers.add(0, "Alexandre");
        Allplayers.add(1, "Sherine");
        Allplayers.add(2, "Martin");
        Namelabel.setText(Allplayers.get(0));
        StartButton.setDisable(true);
        StartButton.setOpacity(0);
        ContinueButton.setDisable(false);
        Image hideSideImage = new Image(getClass().getResourceAsStream("backside.png"));
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



        ArrayList<String> player0 = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();

        player0.add(0,"6.png");
        player0.add(1,"2.png");
        player0.add(2,"67.png");
        player0.add(3,"62.png");
        player0.add(4,"38.png");
        player0.add(5,"77.png");
        player0.add(6,"34.png");
        player0.add(7,"57.png");
        player0.add(8,"83.png");
        player0.add(9,"92.png");

        player1.add(0,"61.png");
        player1.add(1,"3.png");
        player1.add(2,"4.png");
        player1.add(3,"58.png");
        player1.add(4,"30.png");
        player1.add(5,"90.png");
        player1.add(6,"98.png");
        player1.add(7,"51.png");
        player1.add(8,"46.png");
        player1.add(9,"45.png");

        player2.add(0,"1.png");
        player2.add(1,"8.png");
        player2.add(2,"62.png");
        player2.add(3,"22.png");
        player2.add(4,"45.png");
        player2.add(5,"11.png");
        player2.add(6,"34.png");
        player2.add(7,"94.png");
        player2.add(8,"82.png");
        player2.add(9,"101.png");


        l1c1.setImage(new Image((getClass().getResourceAsStream("27.png"))));
        l2c1.setImage(new Image((getClass().getResourceAsStream("61.png"))));
        l3c1.setImage(new Image((getClass().getResourceAsStream("25.png"))));
        l4c1.setImage(new Image((getClass().getResourceAsStream("12.png"))));


        /*
        // Déclaration de la liste principale (matrice)
        List<List<Integer>> matrix = new ArrayList<>();
        // Ajouter les listes à la matrice
        for (int i = 0; i < 4; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                // Ajouter un élément à la sous-liste
                sublist.add(0); // Remplacez 0 par la valeur souhaitée
            }
            // Ajouter la sous-liste à la matrice
            matrix.add(sublist);
        }
        // Accéder aux éléments de la matrice
        //int element = matrix.get(2).get(3); // Accéder à l'élément de la troisième liste à l'index 3
        // Modifier un élément de la matrice
        matrix.get(1).set(2, 10); // Modifier l'élément de la deuxième liste à l'index 2
        // Parcourir la matrice
        for (List<Integer> sublist : matrix) {
            for (int element : sublist) {
                // Faire quelque chose avec chaque élément
                System.out.print(element + " ");
            }
            System.out.println(); // Saut de ligne après chaque sous-liste
        }

         */
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
    private ImageView l1c1;

    @FXML
    private ImageView l2c1;

    @FXML
    private ImageView l3c1;

    @FXML
    private ImageView l4c1;


    int i = 1;
    @FXML
    public void handleContinueButton(ActionEvent event) throws IOException {
        ArrayList<String> Allplayers = new ArrayList<>();
        Allplayers.add(0, "Alexandre");
        Allplayers.add(1, "Sherine");
        Allplayers.add(2, "Martin");
        Namelabel.setText(Allplayers.get(i));
        i++;
        if(i==3){
            i=0;
        }
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
            Image hideSideImage = new Image(getClass().getResourceAsStream("backside.png"));
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
        }else {
            handCard1.setImage(new Image(getClass().getResourceAsStream("3.png")));
            handCard2.setImage(new Image(getClass().getResourceAsStream("19.png")));
            handCard3.setImage(new Image(getClass().getResourceAsStream("29.png")));
            handCard4.setImage(new Image(getClass().getResourceAsStream("48.png")));
            handCard5.setImage(new Image(getClass().getResourceAsStream("52.png")));
            handCard6.setImage(new Image(getClass().getResourceAsStream("71.png")));
            handCard7.setImage(new Image(getClass().getResourceAsStream("80.png")));
            handCard8.setImage(new Image(getClass().getResourceAsStream("89.png")));
            handCard9.setImage(new Image(getClass().getResourceAsStream("91.png")));
            handCard10.setImage(new Image(getClass().getResourceAsStream("101.png")));
        }
            /*
            List<Card> generateCards = generatecards();
            Collections.shuffle(generateCards);

            int numplayer = Allplayers.size();
            int cardsperplayer = 10;
            int cardIndex = 0;

            for (int playerIndex = 0; playerIndex < numplayer; playerIndex++) {
                String playerName = Allplayers.get(playerIndex);

                for (int i = 0; i < cardsperplayer; i++) {
                    if (cardIndex >= generateCards.size()) {
                        break;
                    }
                    Card card = generateCards.get(cardIndex);
                    int cardNumber = card.getCardsnumber();
                    String imagePath = cardNumber + ".png";
                    Image cardImage = new Image(getClass().getResourceAsStream(imagePath));
                    int imageViewIndex = playerIndex * cardsperplayer + i;
                    ImageView handCard = getHandCardImageView(imageViewIndex);
                    handCard.setImage(cardImage);
                    handCard.setVisible(true);

                    cardIndex++;

             */
    }
}





