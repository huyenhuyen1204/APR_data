import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * constructor.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * movePiece.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y) && board.getAt(x, y) == null) {
            Move move = new Move(piece.getCoordinatesX(), x,
                                piece.getCoordinatesY(), y, piece);
            moveHistory.add(move);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
        if (piece.canMove(board, x, y) && board.getAt(x, y) != null) {
            Piece killedPiece = board.getAt(x, y);
            Move move = new Move(piece.getCoordinatesX(), x,
                                piece.getCoordinatesY(), y, piece, killedPiece);
            moveHistory.add(move);
            board.removeAt(x, y);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    /**
     * getBoard.
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * setBoard.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * getMoveHistory.
     * @return ArrayList
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * setMoveHistory.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }
}
