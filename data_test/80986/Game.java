import java.util.ArrayList;

public class Game {
    private Board board = new Board();

    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * move.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                Piece p = board.getAt(x, y);
                Move move1 = new Move(piece.getCoordinatesX(),
                        x, piece.getCoordinatesY(), y, piece, p);
                moveHistory.add(move1);
                board.removeAt(x, y);
            } else {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                moveHistory.add(move);
            }
            piece.setX(x);
            piece.setY(y);
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

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

}

