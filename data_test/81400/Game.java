import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<>();
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

    /**
     * cmt.
     *
     */
    public void movePiece(Piece piece, int x, int y) {
        if (x > 8 || x < 0 || y > 8 || y < 0) {
            return;
        }
        if (piece.canMove(this.board, x, y)) {
            if (this.board.getAt(x, y) == null) {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                this.moveHistory.add(move);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            } else {
                Move move =
                        new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                                x, y, piece, this.board.getAt(x, y));
                this.moveHistory.add(move);
                this.board.getPieces().remove(this.board.getAt(x, y));
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }
}
