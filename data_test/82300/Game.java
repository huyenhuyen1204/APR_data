import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Javadoc Comment.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Javadoc Comment.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Javadoc Comment.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Javadoc Comment.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Javadoc Comment.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (!board.getAt(x, y).equals(null)) {
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                board.removeAt(x, y);
                moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, board.getAt(x, y)));
            } else {
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece));
            }
        }
    }
}
