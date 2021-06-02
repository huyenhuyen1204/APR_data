import java.util.ArrayList;

/**
 * Created by CCNE on 19/11/2020.
 */
public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    /**
     * Loan .
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Loan .
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Loan .
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Loan .
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     * Loan .
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Loan .
     */
    public void movePiece(Piece piece, int x, int y) {
        Move move = null;
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                board.removeAt(x, y);
                move = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
            } else {
                move = new Move(piece.getX(), x, piece.getY(), y, piece);
            }
        }
        if (move != null) moveHistory.add(move);
    }
}
