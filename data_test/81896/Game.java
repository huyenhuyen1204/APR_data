import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
    }

    /**
     * move piece to (x,y) coordinate.
     *
     * @param piece moved piece
     * @param x x axis of the piece
     * @param y y axis of the piece
     */
    public void movePiece(Piece piece, int x, int y) {
        if (board.validate(x, y)) {
            if (board.getAt(x, y) == null) {
                Move temp = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(temp);
            } else if (board.getAt(x, y) != null){
                Piece killed = board.getAt(x, y);
                Move temp = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece, killed);
                board.removeAt(x, y);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(temp);
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

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }
}
