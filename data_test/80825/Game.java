
import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * Author.
     * Thuan
     * Trinh Van Thuan
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            Move move = new Move(piece.getCoordinatesX(), x,
                    piece.getCoordinatesY(), y, piece);
            moveHistory.add(move);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
