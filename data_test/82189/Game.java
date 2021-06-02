import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * move.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Piece killedPiece = board.getAt(x, y);
            if (killedPiece != null) {
                Move move = new
                        Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece, killedPiece);
                moveHistory.add(move);
                board.removeAt(x, y);
            } else {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                moveHistory.add(move);
            }
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
