import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public Game() {

    }

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<Move>();
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

    /**
     * Comment.
     * */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            int tempX = piece.getX();
            int tempY = piece.getY();

            Piece p = board.getAt(x, y);
            if (p != null) {
                board.removeAt(p.getX(), p.getY());
                piece.setX(x);
                piece.setY(y);
                Move move = new Move(tempX, x, tempY, y, piece, p);
                moveHistory.add(move);
            } else {
                piece.setX(x);
                piece.setY(y);
                Move move = new Move(tempX, x, tempY, y, piece);
                moveHistory.add(move);
            }
        }
    }
}