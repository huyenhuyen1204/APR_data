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

    /*
     *nnnnnnn.
     *nnnnn.
     *
     *
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            if (this.board.getAt(x, y) == null) {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                this.moveHistory.add(move);
            } else {
                Move move =
                        new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                                x, y, piece, this.board.getAt(x, y));
                this.moveHistory.add(move);
                this.board.getPieces().remove(this.board.getAt(x, y));
            }
        }
    }
}