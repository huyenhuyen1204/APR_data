import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * Di chuyen co.
     * @param piece quan di chuyen.
     * @param x toa do x den.
     * @param y toa do y den.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                moveHistory.add(
                        new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                                x, y, piece));
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            } else {
                Piece killedPiece = board.getAt(x, y);
                board.removeAt(x, y);
                moveHistory.add(
                        new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                                x, y, piece, killedPiece));
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


}
