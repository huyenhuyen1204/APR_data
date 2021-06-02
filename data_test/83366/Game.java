import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**movePiece.*/
    public void movePiece(Piece piece, int x, int y) {
        try {
            Move move;
            if (piece.canMove(board, x, y)) {
                if (board.getAt(x, y) == null) {
                    move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                    board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                    board.addPiece(piece);
                    piece.setCoordinatesX(x);
                    piece.setCoordinatesY(y);
                } else {
                    move = new Move(piece.getCoordinatesX(), x,
                            piece.getCoordinatesY(), y, piece, board.getAt(x, y));
                    board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                    board.addPiece(piece);
                    board.removeAt(x, y);
                    piece.setCoordinatesX(x);
                    piece.setCoordinatesY(y);
                }
                moveHistory.add(move);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
