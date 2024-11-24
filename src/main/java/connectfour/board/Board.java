package connectfour.board;

import connectfour.board.action.PieceDropper;
import connectfour.board.build.DisplayBoard;
import connectfour.board.build.InitializeBoard;
import connectfour.board.conditions.BoardFullChecker;
import connectfour.board.conditions.ColumnChecker;



public class Board {
    /**
     * A tábla tömbje.
     */
    private char[][] board;
    /**
     * InitializeBoard behivatkozása.
     */
    private InitializeBoard initializeBoard;
    /**
     * DisplayBoard behivatkozása.
     */
    private DisplayBoard displayBoard;
    /**
     * ColumnChecker behivatkozása.
     */
    private ColumnChecker columnChecker;
    /**
     * PieceDropper behivatkozása.
     */
    private PieceDropper pieceDropper;
    /**
     * BoardFullChecker behivatkozása.
     */
    private BoardFullChecker boardFullChecker;

    /**
     * Tábla létrehozása.
     */
    public Board() {
        board = new char[BoardConfig.ROWS.getIntValue()] //VO
                [BoardConfig.COLUMNS.getIntValue()];
        initializeBoard = new InitializeBoard();
        displayBoard = new DisplayBoard();
        columnChecker = new ColumnChecker();
        pieceDropper = new PieceDropper();
        boardFullChecker = new BoardFullChecker();
        initializeBoard.initialize(board);
    }


    /**
     * Metódus a displayBoard-ra.
     */
    public void displayBoard() {
        displayBoard.display(board);
    }

    /**
     * Metódus a isColumnFull-ra.
     * @param col .
     * @return .
     */
    public boolean isColumnFull(final int col) {
        return columnChecker.isColumnFull(board, col);
    }

    /**
     * Metódus a dropPiece-re.
     * @param col .
     * @param player .
     */
    public void dropPiece(final int col, final char player) {
        pieceDropper.dropPiece(board, col, player);
    }

    /**
     * Metódus az isFull-ra.
     * @return .
     */
    public boolean isFull() {
        return boardFullChecker.isFull(board);
    }

    /**
     * Lekéri a táblát.
     * @return .
     */
    public char[][] getBoard() {
        return board;
    }
}
