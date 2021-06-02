import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /** constructor.
     */
    public Game(Board board) {
        this.board = board;
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

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /** move pieces.
     */
    public void movePiece(Piece piece, int x, int y) {

        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                Move move;
                move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                moveHistory.add(move);
            } else {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y,
                        piece, board.getAt(x, y));
                moveHistory.add(move);
                move.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }
}
