import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

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
    
    /*
    * cmt.
    */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getX(), x, piece.getY(), y, piece, board.getAt(x, y));
            moveHistory.add(move);
            Piece p = board.getAt(x, y);
            if (p != null) {
                board.removeAt(x, y);
            }
            piece.setX(x);
            piece.setY(y);
        }
    }
}
