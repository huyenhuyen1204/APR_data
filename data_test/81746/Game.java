import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getCoordinatesX(),
                    piece.getCoordinatesY(), x, y, piece);
            moveHistory.add(move);
        }

        if (piece.getCoordinatesX() == x
        && piece.getCoordinatesY() == y) {
            board.removeAt(x, y);
        }
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
}
