import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * ham di chuyen quan co.
     * @param piece .
     * @param x .
     * @param y .
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Piece newPiece = board.getAt(x, y);
            if (newPiece == null) {
                Move move = new Move(piece.getCoordinatesX(),
                        piece.getCoordinatesY(), x, y, piece);
                moveHistory.add(move);
            } else {
                Move move = new Move(piece.getCoordinatesX(),
                        piece.getCoordinatesY(), x, y, piece, newPiece);
                moveHistory.add(move);
                if (!board.getPieces().isEmpty()) {
                    board.removeAt(x, y);
                }
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
