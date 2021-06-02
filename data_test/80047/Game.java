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
        if (piece.canMove(board, x, y)) {
            Move move;
            if (board.getAt(x, y) != null) {
                move = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
                board.removeAt(x, y);
            } else {
                move = new Move(piece.getX(), x, piece.getY(), y, piece);
            }
            moveHistory.add(move);
            piece.setX(x);
            piece.setY(y);
        }
    }
}
