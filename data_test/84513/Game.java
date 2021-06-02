import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game() {

    }

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move newMove;
            if (board.getAt(x, y).getColor().equals(piece.getColor()) == false) {
                newMove = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece, board.getAt(x, y));
                board.removeAt(x, y);
            } else {
                newMove = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
            }
            moveHistory.add(newMove);
            board.addPiece(piece);
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
}
