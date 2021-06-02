import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

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
            Move e = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            if (board.getAt(x, y) != null) {
                e.setKilledPiece(board.getAt(x, y));
                board.removeAt(x, y);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            moveHistory.add(e);
            board.addPiece(piece);
        }
    }
}
