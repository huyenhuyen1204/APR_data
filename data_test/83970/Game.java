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
            Piece killedP = board.getAt(x, y);
            if (killedP != null) {
                Move m1 = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece, board.getAt(x, y));
                moveHistory.add(m1);
                board.removeAt(x, y);
            } else {
                Move m = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece);
                moveHistory.add(m);
            }
        } else {
            return;
        }
        piece.setCoordinatesX(x);
        piece.setCoordinatesY(y);
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

    /**
     * Main.
     */
    public static void main(String[] args) {

    }
}
