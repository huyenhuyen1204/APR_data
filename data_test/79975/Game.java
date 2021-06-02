import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
    }

    /**movePiece.*/
    public void movePiece(Piece piece, int x, int y) {
        Move move;
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                board.removeAt(piece.getX(), piece.getY());
                board.addPiece(piece);
                piece.setX(x);
                piece.setY(y);
                move = new Move(piece.getX(), x, piece.getY(), y, piece);
                moveHistory.add(move);
            } else {
                move = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
                board.removeAt(piece.getX(), piece.getY());
                board.removeAt(x, y);
                board.addPiece(piece);
                piece.setX(x);
                piece.setY(y);
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

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
