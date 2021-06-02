import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

    /**
     * ...
     */
    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * ...
     */
    public void removePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            Move temp = new Move(piece.getCoordinatesX(), x,
                    piece.getCoordinatesY(), y, piece);
            moveHistory.add(temp);
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
