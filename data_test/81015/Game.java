import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    /** binhdang. */
    public Game(Board board) {
        this.board = board;
    }

    /** binhdang. */
    public void movePiece(Piece piece, int x1, int y1) {
        if (piece.canMove(board, x1, y1)) {
            Move newMove;
            if (board.getAt(x1, y1) != null) {
                int tempX = piece.getCoordinatesX();
                int tempY = piece.getCoordinatesY();
                newMove = new Move(tempX, x1, tempY, y1, piece, board.getAt(x1, y1));
                board.removeAt(x1, y1);
            } else {
                newMove = new Move(piece.getCoordinatesX(), x1, piece.getCoordinatesY(), y1, piece);
            }
            moveHistory.add(newMove);
            piece.setCoordinatesX(x1);
            piece.setCoordinatesY(y1);
        }
    }

    /** binhdang. */
    public Board getBoard() {
        return board;
    }

    /** binhdang. */
    public void setBoard(Board board) {
        this.board = board;
    }

    /** binhdang. */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public static void main(String[] args) {

    }
}
