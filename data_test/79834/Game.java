import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

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
        if (piece != null) {
            if (piece.canMove(board, x, y)) {
                Move move = new Move(piece.getX(), x, piece.getY(), y, piece);
                moveHistory.add(move);
                if (board.getAt(x, y) != null) {
                    board.removeAt(x, y);
                }
                piece.setX(x);
                piece.setY(y);
            }
        }
    }
}
