package com.isep.sixquiprend.core;

import java.util.List;
import java.util.Random;

public class Ai {
    private Random random;

    public Ai() {
        random = new Random();
    }

    public int chooseCard(List<Integer> availableCards) {
        // Choix aléatoire d'une carte parmi celles disponibles
        int randomIndex = random.nextInt(availableCards.size());
        return availableCards.get(randomIndex);
    }

    public int chooseRow(List<Integer> cardOptions) {
        // Choix aléatoire d'une rangée parmi celles disponibles pour une carte donnée
        int randomIndex = random.nextInt(cardOptions.size());
        return cardOptions.get(randomIndex);
    }
}
