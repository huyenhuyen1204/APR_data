import java.util.ArrayList;

public class Game {
    private Board board;
    private static ArrayList<Move> moveHistory = new ArrayList<>();

    public Game() {}

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Piece pieceNext = board.getAt(x, y);
            if (pieceNext == null) {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                moveHistory.add(move);
                board.addPiece(piece);
            } else {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, pieceNext);
                moveHistory.add(move);
                board.removeAt(x, y);
                board.addPiece(piece);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
