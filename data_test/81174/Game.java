import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Hello, this is me ure looking for.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void movePiece(Piece piece, int thisX, int thisY) {
        if (piece.canMove(board, thisX, thisY)) {
            Piece killed = board.getAt(thisX, thisY);
            Move move = new Move(piece.getCoordinatesX(), thisX,
                    piece.getCoordinatesY(), thisY, piece);
            if (killed != null) {
                move.setKilledPiece(killed);
                board.removeAt(thisX, thisY);
            }
            piece.setCoordinatesX(thisX);
            piece.setCoordinatesY(thisY);
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }
}
