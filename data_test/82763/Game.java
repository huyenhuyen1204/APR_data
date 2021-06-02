import java.util.ArrayList;

public class Game {
    private Board board;
    private static ArrayList<Move> moveHistory= new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            board.removeAt(x, y);
            Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                    x, y, piece, board.getAt(x, y));
            moveHistory.add(move);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
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
