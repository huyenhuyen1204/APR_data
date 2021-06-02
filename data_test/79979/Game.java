import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game() {
        board = null;
    }

    public Game(Board board) {
        this.board = board;
    }

    /** abc. */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getX(), x, piece.getY(), y, piece);

            if (board.getAt(x, y) != null && !piece.getColor().equals(board.getAt(x, y).getColor())) {
                move.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
            moveHistory.add(move);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }
}
