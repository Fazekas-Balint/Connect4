package connectfour.main;

import connectfour.board.Board;
import connectfour.db.PlayerDAO;
import connectfour.game.Game;
import connectfour.game.handler.CommandHandler;
import org.h2.tools.Server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public final class ConnectFour {

    private static Runnable exithandler;

    private ConnectFour() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void main(final String[] args) {
        System.out.println("Welcome to Connect 4!");
        Server server = null;
        try {
            server = Server.createTcpServer(
                    "-tcpAllowOthers", "-tcpPort", "9092").start();
            Server.createWebServer(
                    "-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println(
                    "H2 console started at http://localhost:8082");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        boolean gameEnded = CommandHandler.start(
                scanner, game, new PlayerDAO(), () -> System.exit(0));

        if (gameEnded) {
            System.out.println("Game over. Exiting...");
            saveBoardToFile(game.getBoard(), "out.txt");
            scanner.close();
            if (server != null) {
                server.stop();
                server.shutdown();
            }
            System.exit(0);
        }

        scanner.close();

        if (server != null) {
            server.stop();
            server.shutdown();
        }
    }

    private static void saveBoardToFile(
            final Board board, final String filename) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filename))) {
            char[][] boardArray = board.getBoard();
            for (char[] row : boardArray) {
                for (char cell : row) {
                    writer.write(cell);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
