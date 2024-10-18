package connectfour.game;

import connectfour.board.Board;
import connectfour.game.checker.WinChecker;
import connectfour.player.PlayerName;

import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Magic number elkerülésére egy konstans.
     */
    public static final int SEVEN = 7;
    /**
     * Tábla változó.
     */
    private Board board;
    /**
     * Jelenlegi játékos.
     */
    private char currentPlayer;
    /**
     * Random szám.
     */
    private Random random;
    /**
     * WinChecker objektum a győzelem ellenőrzéséhez.
     */
    private WinChecker winChecker;

    /**
     * Tábla lekérése.
     * @return return
     */
    public Board getBoard() {
        return this.board;
    }
    /**
     * A WinChecker lekérése.
     * @return return
     */
    public WinChecker getWinChecker() {
        return this.winChecker;
    }
    /**
     * Jelenlegi játékos lekérése.
     * @return return
     */
    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Konstruktor a játékhoz.
     */
    public Game() {
        board = new Board();
        currentPlayer = 'S'; // Az X játékos kezd
        random = new Random(); // Véletlenszám-generátor a gépi játékoshoz
        winChecker = new WinChecker(); // WinChecker példány létrehozása

    }

    /**
     * A game konstruktor lemásolva, mock teszthez.
     * @param mockBoard .
     * @param mockWinChecker .
     * @param mockRandom .
     */
    public void mockgame(final Board mockBoard,
                         final WinChecker mockWinChecker,
                         final Random mockRandom) {
        this.board = mockBoard;
        this.currentPlayer = 'S';
        this.random = mockRandom;
        this.winChecker = mockWinChecker;
    }

    /**
     * A játék menete.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("Welcome to Connect4 game, "
                + PlayerName.getName() + "!");
        board.displayBoard();

        while (!gameWon && !board.isFull()) {
            int col;

            if (currentPlayer == 'S') {
                System.out.println("Player " + currentPlayer + " move.");

                do {
                    System.out.print("Choose a column (1-7): ");
                    col = scanner.nextInt() - 1; // 0-tól indexelünk
                } while (col < 0 || col >= SEVEN || board.isColumnFull(col));

            } else {
                System.out.println("Player "
                        + currentPlayer + " move (Machine).");

                do {
                    col = random.nextInt(SEVEN);
                } while (board.isColumnFull(col));

                System.out.println("Machine drops the piece into column "
                        + (col + 1) + ".");
            }

            board.dropPiece(col, currentPlayer);
            board.displayBoard();

            if (winChecker.checkWin(board.getBoard(), currentPlayer)) {
                System.out.println("Player " + currentPlayer + " won!");
                gameWon = true;
            } else {
                currentPlayer = (currentPlayer == 'S') ? 'P' : 'S';
            }
        }

        if (!gameWon) {
            System.out.println("The game is a draw!");
        }

        scanner.close();
    }

}
