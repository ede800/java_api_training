package fr.lernejo.navy_battle;

import java.util.Scanner;

public class Game {
    private BattleField playerField;
    private BattleField opponentField;
    private boolean gameOver;

    public Game() {
        playerField = new BattleField();
        opponentField = new BattleField();
        gameOver = false;
    }

    public void start() {
        placePlayerShips();
        placeOpponentShips();

        while (!gameOver) {
            playerTurn();
            opponentTurn();
            checkGameOver();
        }
    }

    private void placePlayerShips() {
        // code to prompt user to place their ships on the playerField
    }

    private void placeOpponentShips() {
        // code to randomly place opponent ships on the opponentField
    }

    private void playerTurn() {
        System.out.println("Your turn! Choose a cell to attack (ex. A5): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // code to parse user input and attack the corresponding cell on the opponentField
    }

    private void opponentTurn() {
        // code to randomly select a cell to attack on the playerField
    }

    private void checkGameOver() {
        // code to check if either player or opponent has no ships left
        if (gameOver) {
            System.out.println("Game over!");
        }
    }
}

