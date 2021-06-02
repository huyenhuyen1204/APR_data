import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    /** binhdang. */
    public Game(Board board) {
        this.board = board;
    }

    /** binhdang. */
    public void movePiece(Piece piece, int x1, int y1) {
        if (piece.canMove(board, x1, y1)) {
            Move newMove;
            if (board.getAt(x1, y1) != null) {
                newMove = new Move(piece.getX(), x1, piece.getY(), y1, piece, board.getAt(x1, y1));
                board.removeAt(x1, y1);
            } else {
                newMove = new Move(piece.getX(), x1, piece.getY(), y1, piece);
            }
            moveHistory.add(newMove);
            piece.setX(x1);
            piece.setY(y1);
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
