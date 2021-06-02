import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    Game(Board board) {
        this.board = board;
    }

    /**
     * ds da s.
     * @param piece d
     * @param x ter
     * @param y ert
     */
    public void movePiece(Piece piece, int x, int y) {
        //chua xu ly neu ha duoc 1 quan co khac thi xoa quan co do
        if (piece.canMove(board, x, y)) {
            Move newMove = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            moveHistory.add(newMove);
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
