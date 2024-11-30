package connectfour.game.checker;

import connectfour.board.BoardConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WinCheckerTest {

    private WinChecker winChecker;
    private char[][] board;

    @BeforeEach
    void setUp() {
        winChecker = new WinChecker();

        // BoardConfig beállítása 6x7-es táblához
        BoardConfig rows = BoardConfig.ROWS;
        BoardConfig columns = BoardConfig.COLUMNS;

        // Üres tábla létrehozása
        board = new char[BoardConfig.ROWS.getIntValue()][BoardConfig.COLUMNS.getIntValue()];
        for (int row = 0; row < BoardConfig.ROWS.getIntValue(); row++) {
            for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
                board[row][col] = BoardConfig.EMPTY_SLOT.getCharValue();
            }
        }
    }

    @Test
    void testHorizontalWin() {
        board[0][0] = 'S';
        board[0][1] = 'S';
        board[0][2] = 'S';
        board[0][3] = 'S';

        assertTrue(winChecker.checkWin(board, 'S'), "S játékosnak nyernie kellene vízszintesen.");
        assertFalse(winChecker.checkWin(board, 'P'), "P játékosnak nem szabadna nyernie.");
    }

    @Test
    void testVerticalWin() {
        board[0][0] = 'S';
        board[1][0] = 'S';
        board[2][0] = 'S';
        board[3][0] = 'S';

        assertTrue(winChecker.checkWin(board, 'S'), "S játékosnak nyernie kellene függőlegesen.");
        assertFalse(winChecker.checkWin(board, 'P'), "P játékosnak nem szabadna nyernie.");
    }

    @Test
    void testDiagonalWinLeftToRight() {
        board[0][0] = 'S';
        board[1][1] = 'S';
        board[2][2] = 'S';
        board[3][3] = 'S';

        assertTrue(winChecker.checkWin(board, 'S'), "S játékosnak nyernie kellene átlósan balról jobbra.");
        assertFalse(winChecker.checkWin(board, 'P'), "P játékosnak nem szabadna nyernie.");
    }

    @Test
    void testDiagonalWinRightToLeft() {
        board[0][3] = 'S';
        board[1][2] = 'S';
        board[2][1] = 'S';
        board[3][0] = 'S';

        assertTrue(winChecker.checkWin(board, 'S'), "S játékosnak nyernie kellene átlósan jobbról balra.");
        assertFalse(winChecker.checkWin(board, 'P'), "P játékosnak nem szabadna nyernie.");
    }

    @Test
    void testNoWin() {
        // Nincs nyerő kombináció
        board[0][0] = 'S';
        board[0][1] = 'S';
        board[0][2] = 'P';
        board[0][3] = 'S';

        assertFalse(winChecker.checkWin(board, 'S'), "Nem kellene nyernie az S játékosnak.");
        assertFalse(winChecker.checkWin(board, 'P'), "Nem kellene nyernie az P játékosnak.");
    }
}