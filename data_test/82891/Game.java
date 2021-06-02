import java.util.ArrayList;

public class Game {
    private Board board;
    private static ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public static ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * di chuyen quan co.
     * @param piece quan co.
     * @param x vi tri x.
     * @param y vi tri y.
     */
    public void movePiece(Piece piece, int x, int y) {
        Piece killedPiece = board.getAt(x, y);
        if (piece.canMove(board, x, y)) {
            if (killedPiece == null) {
                moveHistory.add(new Move(piece.getCoordinatesX(),
                        x, piece.getCoordinatesY(), y, piece));
            } else {
                moveHistory.add(new Move(piece.getCoordinatesX(),
                        x, piece.getCoordinatesY(), y, piece, killedPiece));
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }
}
