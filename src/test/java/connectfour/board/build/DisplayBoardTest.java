package connectfour.board.build;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayBoardTest {
    private DisplayBoard displayBoard;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        displayBoard = new DisplayBoard();
        // Kimenet átirányítása
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testDisplayBoard() {
        // Teszt tábla létrehozása
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'}
        };

        // Elvárt kimenet
        String expectedOutput =
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        "|" + ". . . . . . . " + "|" + System.lineSeparator() +
                        " 1 2 3 4 5 6 7" + System.lineSeparator();

        // Metódus meghívása
        displayBoard.display(board);

        // Kimenet ellenőrzése
        assertEquals(expectedOutput, outputStream.toString());
    }
}