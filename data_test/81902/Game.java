import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game() {
    }

    public Game(Board board) {
        this.board = board;
    }

    /**
     * move piece on board.
     * @param piece piece
     * @param x coordinate x
     * @param y coordinate y
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y) && board.validate(x, y)) {

            if (board.getAt(x, y) != null) {
                board.removeAt(x, y);
                moveHistory.add(new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y,
                        piece, board.getAt(x, y)));
            } else {
                moveHistory.add(new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y,
                        piece));
            }
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

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
