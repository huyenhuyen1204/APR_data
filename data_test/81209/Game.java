import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * fhasjd.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * fjkdhs.
     */
    public void movePiece(Piece piece, int x, int y) {

        if (piece.canMove(board, x, y)) {

            Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
            for (Piece i : board.getPieces()) {

                if (i.getCoordinatesY() == y && i.getCoordinatesX() == x) {
                    move.setKilledPiece(i);
                    board.removeAt(i.getCoordinatesX(), i.getCoordinatesY());
                    break;
                }
            }
            moveHistory.add(move);
        }
    }

    /**
     * fdsgkjfs.
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * fjfwrggs.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * fdjhgs.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * jaguwus.
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

}
