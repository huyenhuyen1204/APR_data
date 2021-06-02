import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * cmt.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * cmt.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * cmt.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * cmt.
     */

    public Game(Board board, ArrayList<Move> moveHistory) {
        this.board = board;
        this.moveHistory = moveHistory;
    }

    /**
     * cmt.
     */
    public Board getBroad() {
        return board;
    }

    /**
     * cmt.
     */
    public void setBroad(Board board) {
        this.board = board;
    }

    /**
     * cmt.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * cmt.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     * cmt.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
            moveHistory.add(move);
            Piece nPiece = board.getAt(x, y);
            if (nPiece != null) {
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
        }
    }
}
