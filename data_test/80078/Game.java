import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**5.*/
    public Game(Board board) {
        this.board = board;
    }
    
    /**5.*/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getX(), x, piece.getY(), y, piece);
            moveHistory.add(move);
            if (board.getAt(x, y) != null) {
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
            board.addPiece(piece);
        }
    }

    /**5.*/
    public Board getBoard() {
        return board;
    }

    /**5.*/
    public void setBoard(Board board) {
        this.board = board;
    }

    /**5.*/
    public ArrayList<Move> getMoveHistory() {
        return new ArrayList<Move>(moveHistory);
    }

    /**5.*/
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = new ArrayList<>(moveHistory);
    }
}

