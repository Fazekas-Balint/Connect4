package connectfour.board.conditions;


import connectfour.board.BoardConfig;

public class ColumnChecker {
    /**
     * Ellenőrzi, hogy az oszlop tele van e.
     * @param board tábla.
     * @param col oszlop.
     * @return visszaadja hogy a táblát.
     */
    public boolean isColumnFull(final char[][] board, final int col) {
        return board[0][col] != BoardConfig.EMPTY_SLOT.getCharValue();
    }
}
