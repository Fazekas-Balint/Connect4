package connectfour.board.conditions;

import connectfour.board.BoardConfig;

public class BoardFullChecker {
    /**
     * A tábla teliségének ellenőrzése.
     * @param board board
     * @return return
     */
    public boolean isFull(final char[][] board) {
        //for ciklus a tábla oszlopainak végigjárásához
        for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
            //ha az első sorban található üres hely, akkor a tábla nem teljes
            if (board[0][col] == BoardConfig.EMPTY_SLOT.getCharValue()) {
                return false;
            }
        }
        return true;
    }
}
