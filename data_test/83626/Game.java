import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    /**
     * abc.
     *
     * @param piece int.
     * @param x     int.
     * @param y     int.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.getBoard(), x, y)) {
            Move v = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
            if (this.getBoard().getAt(x, y) != null) {
                v.setKilledPiece(this.getBoard().getAt(x, y));
                this.getBoard().removeAt(x, y);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            moveHistory.add(v);
        }
    }

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<>(0);
    }

    public Game(Board board, ArrayList<Move> moveHistory) {
        this.board = board;
        this.moveHistory = moveHistory;
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
 