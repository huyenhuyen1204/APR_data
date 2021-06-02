import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game(Board board) {
        this.board = board;

    }

    /**hu hu.*/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move;
            if (board.getAt(x, y) != null) {
                move = new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece, board.getAt(x, y));
                board.removeAt(x, y);
            } else {
                move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            }
            moveHistory.add(move);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
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
