package connectfour.game.handler;

import connectfour.game.Game;
import connectfour.player.PlayerName;

import java.util.Scanner;

public class CommandHandler extends PlayerName {

    /**
     * A játék kezdésének kezelése.
     * @param scanner
     * @param game
     */

    public static void start(final Scanner scanner, final Game game) {
        String userInput = "";

        while (!userInput.equalsIgnoreCase("Start")) {
            System.out.println("Type: 'Start' to start the game ");
            userInput = scanner.nextLine();
        }

        System.out.println("The game starts...");
        game.play(); // Játék elindítása
    }

}
