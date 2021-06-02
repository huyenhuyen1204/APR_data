import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Ham khoi tao 1 tham so.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Ham khoi tao 2 tham so.
     */
    public Game(Board board, ArrayList<Move> moveHistory) {
        this.board = board;
        this.moveHistory = moveHistory;
    }

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
    public  void movePiece(Piece p , int x, int y) {
        if (p.canMove(board, x, y)) {
            Move move = new Move(p.getCoordinatesX(), x, p.getCoordinatesY(), y, p, board.getAt(x, y));
            moveHistory.add(move);
            Piece piece = board.getAt(x, y);
            if (piece != null) {
                board.removeAt(x, y);
            }
            p.setCoordinatesX(x);
            p.setCoordinatesY(y);
        }
    }
}

