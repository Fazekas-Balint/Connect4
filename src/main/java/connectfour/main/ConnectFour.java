package connectfour.main;

import connectfour.game.Game;
import connectfour.game.handler.CommandHandler;
import java.util.Scanner;

public final class ConnectFour {

    private  ConnectFour() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * A játék main-je.
     * @param args .
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to Connect 4!");

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        CommandHandler commandHandler = new CommandHandler();

        // A start metódus meghívása a Scanner átadásával
        CommandHandler.start(scanner, game);

        scanner.close();

}
}
