package connectfour.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(); // Új tábla példányosítása
    }

    @Test
    void testDisplayBoard() {

        board.displayBoard(); // A displayBoard metódus meghívása
    }

    @Test
    void testIsColumnFull() {
        assertFalse(board.isColumnFull(0)); // Az oszlop kezdetben nem teljes
        board.dropPiece(0, 'X'); // Egy darab X elhelyezése az oszlopban
        assertFalse(board.isColumnFull(0)); // Az oszlop még mindig nem teljes
        for (int i = 0; i < 5; i++) {
            board.dropPiece(0, 'O'); // Az oszlop feltöltése
        }
        assertTrue(board.isColumnFull(0)); // Az oszlop most már teljes
    }

    @Test
    void testDropPiece() {
        board.dropPiece(1, 'X'); // Az X elhelyezése az oszlopban
        assertEquals('X', board.getBoard()[5][1]); // Ellenőrzés, hogy az X a megfelelő helyen van
    }

    @Test
    void testIsFull() {
        // Ellenőrzés, hogy a tábla kezdetben nem teljes
        assertFalse(board.isFull());
        // Töltse fel az összes oszlopot, kivéve az utolsót
        for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
            for (int row = 0; row < BoardConfig.ROWS.getIntValue() - 1; row++) {
                board.dropPiece(col, 'X');
            }
        }
       // Az utolsó tábla feltöltése
        for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
            board.dropPiece(col, 'X');
        }
        // Ellenőrzés, hogy a tábla most már teljes
        assertTrue(board.isFull());
    }
}