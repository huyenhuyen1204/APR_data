import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Hello, this is me ure looking for.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void movePiece(Piece piece, int thisX, int thisY) {
        if (piece.canMove(board, thisX, thisY)) {
            if (board != null && board.getAt(thisX, thisY) != null) {
                moveHistory.add(new Move(piece.getCoordinatesX(), thisX,
                        piece.getCoordinatesY(), thisY, board.getAt(thisX, thisY)));
                board.removeAt(thisX, thisY);
            } else {
                moveHistory.add(new Move(piece.getCoordinatesX(), thisX,
                        piece.getCoordinatesY(), thisY, piece));
            }
            piece.setCoordinatesX(thisX);
            piece.setCoordinatesY(thisY);
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public ArrayList<Move> getMoveHistory() {
        return (ArrayList<Move>) moveHistory;
    }
}
