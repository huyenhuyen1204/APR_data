import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game() {
    }

    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<Move>();
    }

    /**
     * move piece on board.
     * @param piece piece
     * @param x coordinate x
     * @param y coordinate y
     */
    public void movePiece(Piece piece, int x, int y) {

        if (board.validate(x, y) && piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                moveHistory.add(new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece));
            } else  {
                moveHistory.add(new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece, board.getAt(x, y)));
                board.removeAt(x, y);
            }

            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        moveHistory = new ArrayList<Move>();
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
