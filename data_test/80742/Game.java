import java.util.ArrayList;

/**
 * .
 * @author Nguyen Quyet Thang .
 */
public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * .
     * @param board .
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * .
     * @param piece .
     * @param x .
     * @param y .
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y) && board.getAt(x, y) == null) {
            Move move = new Move(piece.getCoordinatesX(),
                    piece.getCoordinatesY(), x, y, piece);
            moveHistory.add(move);
        }
        if (piece.canMove(board, x, y) && board.getAt(x, y) != null) {
            Move move = new Move(piece.getCoordinatesX(),
                    piece.getCoordinatesY(), x, y, piece, board.getAt(x, y));
            moveHistory.add(move);
            board.removeAt(x, y);
        }
    }

    /**
     * .
     * @return .
     */
    public Board getBoard() {
        return board;
    }

    /**
     * .
     * @param board .
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * .
     * @return .
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
