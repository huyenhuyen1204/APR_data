import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;

    }
    
    /**hu hu.*/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getX(), x, piece.getY(), y, piece);
            if (board.getAt(x, y) != null) {
                move.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setX(y);
            moveHistory.add(move);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board b) {
        board = b;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(ArrayList<Move> moveArrayList) {
        moveHistory = moveArrayList;
    }
}
