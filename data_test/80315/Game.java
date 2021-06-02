import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y) && !piece.isRemove()) {
            moveHistory.add(new Move(piece.getX(), piece.getY(), x, y, piece));
        }
        if (piece.canMove(board, x, y) && piece.isRemove()) {
            board.removeAt(x, y);
            moveHistory.add(new Move(piece.getX(), piece.getY(), x, y, piece, board.getAt(x, y)));
        }
    }
}
