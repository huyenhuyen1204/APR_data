import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    /**
     * board.
     * @param board dioj
     */
    public Game(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * move.
     * @param piece p
     * @param x x
     * @param y y
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(getBoard(), x, y)){
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            if (getBoard().getAt(x,y) != null) {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece, getBoard().getAt(x,y));
                moveHistory.add(move);
            } else {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece);
                moveHistory.add(move);
            }
        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
 