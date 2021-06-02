import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (board.validate(x, y)) {
            if (board.getAt(x, y) == null) {
                Move temp = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                moveHistory.add(temp);
            } else {
                board.remoteAt(x,y);
                Move temp = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
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
