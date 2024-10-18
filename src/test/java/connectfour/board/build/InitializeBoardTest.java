package connectfour.board.build;

import connectfour.board.BoardConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitializeBoardTest {

    private InitializeBoard initializeBoard;
    private char[][] testBoard;

    @BeforeEach
    void setUp() {
        // Új InitializeBoard példányosítása
        initializeBoard = new InitializeBoard();

        // Teszt tábla létrehozása
        int rows = BoardConfig.ROWS.getIntValue();
        int columns = BoardConfig.COLUMNS.getIntValue();
        testBoard = new char[rows][columns];
    }

    @Test
    void testInitializeBoard() {
        // Metódus meghívása
        initializeBoard.initialize(testBoard);

        // Az elvárt karakter
        char expectedChar = BoardConfig.EMPTY_SLOT.getCharValue();
        for (int row = 0; row < BoardConfig.ROWS.getIntValue(); row++) {
            for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
                assertEquals(expectedChar, testBoard[row][col],
                        "The board element [" + row + "][" + col + "] does not match the expected value.");
            }
        }
    }
}