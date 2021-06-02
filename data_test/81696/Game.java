import java.util.ArrayList;

/**
 * Created by CCNE on 30/11/2020.
 */
public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if(piece.canMove(board, x, y)) {
            int startX = piece.getCoordinatesX();
            int startY = piece.getCoordinatesY();
            Piece killedPiece = board.getAt(x, y);
            Move move = null;
            if (killedPiece != null) {
                board.removeAt(x, y);
                move = new Move(startX, startY, x, y, piece, killedPiece);
                moveHistory.add(move);
            } else {
                move = new Move(startX, startY, x, y, piece);
                moveHistory.add(move);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
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
