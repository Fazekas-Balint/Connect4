package connectfour.game.checker;

import connectfour.board.BoardConfig;

public class WinChecker {

    /**
     * Győzelem ellenőrzése.
     * @param board board
     * @param player player
     * @return return
     */
    public boolean checkWin(final char[][] board, final char player) {
        int rows = BoardConfig.ROWS.getIntValue();
        int cols = BoardConfig.COLUMNS.getIntValue();
        final int three = 3;

        // Vízszintes ellenőrzés
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - three; col++) {
                if (board[row][col] == player
                        && board[row][col + 1] == player
                        && board[row][col + 2] == player
                        && board[row][col + three] == player) {
                    return true; // Győzelem vízszintesen
                }
            }
        }
        //Ki lehet szervezni pl winchecker interface
        // Függőleges ellenőrzés
        for (int row = 0; row < rows - three; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == player
                        && board[row + 1][col] == player
                        && board[row + 2][col] == player
                        && board[row + three][col] == player) {
                    return true; // Győzelem függőlegesen
                }
            }
        }

        // Átlós ellenőrzés balról jobbra
        for (int row = 0; row < rows - three; row++) {
            for (int col = 0; col < cols - three; col++) {
                if (board[row][col] == player
                        && board[row + 1][col + 1] == player
                        && board[row + 2][col + 2] == player
                        && board[row + three][col + three] == player) {
                    return true; // Győzelem átlósan balról jobbra
                }
            }
        }

        // Átlós ellenőrzés jobbról balra
        for (int row = 0; row < rows - three; row++) {
            for (int col = three; col < cols; col++) {
                if (board[row][col] == player
                        && board[row + 1][col - 1] == player
                        && board[row + 2][col - 2] == player
                        && board[row + three][col - three] == player) {
                    return true; // Győzelem átlósan jobbról balra
                }
            }
        }

        return false; // Nincs győzelem (döntetlen)
    }
}
