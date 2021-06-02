import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Constructor.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * move piece.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move m = new Move(piece.getCoordinatesX(), piece.getCoordinatesY()
                    , x, y, piece);
            moveHistory.add(m);
            int diffX = x - piece.getCoordinatesX();
            int diffY = y - piece.getCoordinatesY();

            if (diffX > 0) {
                piece.setCoordinatesX(piece.getCoordinatesX() + diffX);
            } else {
                piece.setCoordinatesX(piece.getCoordinatesX() - diffX);
            }

            if (diffY > 0) {
                piece.setCoordinatesY(piece.getCoordinatesY() + diffY);
            } else {
                piece.setCoordinatesY(piece.getCoordinatesY() - diffY);
            }
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

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }
}
