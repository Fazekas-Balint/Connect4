package connectfour.game.handler;

import connectfour.game.Game;
import connectfour.db.PlayerDAO;
import connectfour.player.PlayerName;

import java.util.Map;
import java.util.Scanner;

public final class CommandHandler {

    private CommandHandler() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static boolean start(final Scanner scanner,
                                final Game game,
                                final Runnable exitHandler) {
        Runnable safeExitHandler = (
                exitHandler != null) ? exitHandler : () -> System.exit(0);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        PlayerName.setName(playerName);

        while (true) {
            System.out.print("Enter command (play/hs/exit): ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("play")) {
                game.play();
                if (game.isGameWon()) {
                    return true;
                }
            } else if (command.equalsIgnoreCase("hs")) {
                displayHighScores();
            } else if (command.equalsIgnoreCase("exit")) {
                safeExitHandler.run();
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        return false;
    }

    private static void displayHighScores() {
        PlayerDAO playerDAO = new PlayerDAO();
        Map<String, Integer> winCounts = playerDAO.getWinCounts();

        System.out.println("High Scores:");
        for (Map.Entry<String, Integer> entry : winCounts.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue() + " wins");
        }
    }
}
