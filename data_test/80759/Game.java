import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     *  .
     * @param board .
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     *  .
     * @return .
     */
    public Board getBoard() {
        return board;
    }

    /**
     *  .
     * @param board .
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     *  .
     * @return .
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     *  .
     * @param moveHistory .
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     *  .
     * @param piece .
     * @param x .
     * @param y .
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(move);
            } else {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, board.getAt(x, y));
                board.removeAt(x, y);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(move);
            }
        }
    }
}
