import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    /**
     * javadoc.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * javadoc.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * javadoc.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * javadoc.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * javadoc.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     * javadoc.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, board.getAt(x, y));
            moveHistory.add(move);
            Piece dest = board.getAt(x, y);
            if (dest != null) {
                board.removeAt(x, y);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }
}
