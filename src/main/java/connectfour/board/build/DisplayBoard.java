package connectfour.board.build;

import connectfour.board.BoardConfig;

public class DisplayBoard {
    /**
     * A tábla megjelenítése.
     * @param board
     */
    public void display(final char[][] board) {
        for (int row = 0; row < BoardConfig.ROWS.getIntValue(); row++) {
            System.out.print("|");
            for (int col = 0; col < BoardConfig.COLUMNS.getIntValue(); col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println("|");
        }
        // A tábla alján a sorok számozása
        for (int col = 1; col <= BoardConfig.COLUMNS.getIntValue(); col++) {
            System.out.print(" " + col);
        }
        System.out.println();
    }
}
