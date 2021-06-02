import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /** Khoi tao 1 tham so. **/
    public Game(Board board) {
        this.board = board;
    }

    /** Lay ban co. **/
    public Board getBoard() {
        return board;
    }

    /** Tao ban co. **/
    public void setBoard(Board board) {
        this.board = board;
    }

    /** Lay cac nuoc di. **/
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /** Tao cac nuoc di. **/
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /** Di chuyen. **/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move m = new Move(piece.getX(), piece.getY(),
                    x, y, piece);
            if (board.getAt(x, y) != null) {
                m.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
            board.addPiece(piece);
            moveHistory.add(m);
        }
    }
}