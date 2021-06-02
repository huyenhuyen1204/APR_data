import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    /** binhdang. */
    public Game(Board board) {
        this.board = board;
    }

    /** binhdang. */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move newMove;
            if (board.getAt(x, y) != null) {
                newMove = new Move(piece.getX(), x, piece.getY(), y, piece);
            } else {
                newMove = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
            }
            moveHistory.add(newMove);
            piece.setX(x);
            piece.setY(y);
        }
    }

    /** binhdang. */
    public Board getBoard() {
        return board;
    }

    /** binhdang. */
    public void setBoard(Board board) {
        this.board = board;
    }

    /** binhdang. */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
