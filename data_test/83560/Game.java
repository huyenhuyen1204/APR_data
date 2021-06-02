import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * alo.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * alo.
     */

    public Board getBoard() {
        return board;
    }

    /**
     * alo.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * alo.
     */

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * alo.
     */

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     * alo.
     */

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                Piece a = board.getAt(x, y);
                board.removeAt(x, y);
                moveHistory.add(new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece, a));
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                board.addPiece(piece);
            } else {
                board.removeAt(x, y);
                board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                moveHistory.add(new Move(piece.getCoordinatesX(),
                        x, piece.getCoordinatesY(), y, piece));
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                board.addPiece(piece);
            }
        }
    }
}
