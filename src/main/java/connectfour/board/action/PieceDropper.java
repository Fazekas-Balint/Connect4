package connectfour.board.action;

import connectfour.board.BoardConfig;

public class PieceDropper {
    /**
     * A bábú elhelyezése a táblán.
     * @param board .
     * @param col .
     * @param player .
     */
    public void dropPiece(final char[][] board,
                          final int col, final char player) {
        // for ciklus a tábla sorainak végéről indulva
        for (int row = BoardConfig.ROWS.getIntValue() - 1; row >= 0; row--) {
            if (board[row][col] == BoardConfig.EMPTY_SLOT.getCharValue()) {
                board[row][col] = player;
                break;
            }
        }
    }
}
