import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    /**uyds.*/
    public Game(Board board) {
        this.board = board;
    }

    /**uyds.*/
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**uyds.*/
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**uyds.*/
    public void setBoard(Board board) {
        this.board = board;
    }

    /**uyds.*/
    public Board getBoard() {
        return board;
    }

    /**uyds.*/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move e = new Move(piece.getX(), x, piece.getY(), y, piece);
            if (board.getAt(x, y) != null) {
                e.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
        }
    }
}
