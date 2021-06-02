import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

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

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                Piece a = board.getAt(x, y);
                board.removeAt(x, y);
                board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, a));
                board.addPiece(new Rook(x, y));
            } else {
                board.removeAt(x, y);
                board.removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
                moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece));
                board.addPiece(new Rook(x, y));
            }
        }
    }
}
