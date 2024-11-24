package connectfour.main;

import connectfour.game.Game;
import connectfour.game.handler.CommandHandler;
import java.util.Scanner;

public final class ConnectFour {

    private  ConnectFour() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(final String[] args) {
        System.out.println("Welcome to Connect 4!");

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        // Start the command handler with the scanner and game
        CommandHandler.start(scanner, game);

        // Close the scanner after the command handler has finished
        scanner.close();
    }
}
