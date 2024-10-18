package connectfour.board.build;

import connectfour.board.BoardConfig;

public class InitializeBoard {
    /**
     * A tábla inicializálása.
     * @param board
     */
    public void initialize(final char[][] board) {
        for (int row = 0; row < BoardConfig.ROWS.getIntValue(); row++) {
            for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
                board[row][col] = BoardConfig.EMPTY_SLOT.getCharValue();
            }
        }
    }
}
