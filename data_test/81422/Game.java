import java.util.ArrayList;

public class Game {
    private static ArrayList<Move> moveHistory;
    private Board board;

    /**
     * .
     *
     * @param board .
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * .
     *
     * @return .
     */
    public static ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * .
     *
     * @param piece .
     * @param x     .
     * @param y     .
     */
    public void movePiece(Piece piece, int x, int y) {
        int startX = piece.getCoordinatesX();
        int startY = piece.getCoordinatesY();
        if (piece.canMove(board, x, y)) {
            Piece p = board.getAt(x, y);
            if (p == null) {
                moveHistory.add(new Move(startX, startY, x, y, piece));
            } else {
                moveHistory.add(new Move(startX, startY, x, y, piece, p));
            }
            return;
        }
    }

    /**
     * .
     *
     * @return .
     */
    public Board getBoard() {
        return board;
    }

    /**
     * .
     *
     * @param board .
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
