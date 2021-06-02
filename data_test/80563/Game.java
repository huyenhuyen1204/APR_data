import java.util.ArrayList;

public class Game {

    private Board board = new Board();
    private ArrayList<Move> moveHistory = new ArrayList<>();

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

    /**
     * 123.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (board.validate(x, y)) {
            if (piece.canMove(board, x, y)) {
                if (board.getPieces() != null) {
                    Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y,
                            piece, board.getAt(x, y));
                    moveHistory.add(move);

                } else {
                    Move move = new Move(piece.getCoordinatesX(), x
                            , piece.getCoordinatesY(), y, piece);
                    moveHistory.add(move);
                }
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }
}
