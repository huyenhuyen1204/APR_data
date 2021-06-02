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

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            if (this.board.getAt(x, y) == null) {
                Move move = new Move(piece.getX(), piece.getY(), x, y, piece);
                this.moveHistory.add(move);
            }
            else {
                Move move = new Move(piece.getX(), piece.getY(), x, y, piece, this.board.getAt(x, y));
                this.moveHistory.add(move);
                this.board.getPieces().remove(this.board.getAt(x, y));
            }
        }
    }
}
