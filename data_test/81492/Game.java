//import java.util.ArrayList;
//
//public class Game {
//    private Board board;
//    private ArrayList<Move> moveHistory = new ArrayList<>();
//
//    Game(Board board) {
//        this.board = board;
//    }
//
//    /**
//     * fsdfsd.
//     */
//    public void movePiece(Piece piece, int x, int y) {
//        if (piece.canMove(board, x, y)) {
//            if (board.getAt(x, y) == null) {
//                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
//                piece.setCoordinatesX(x);
//                piece.setCoordinatesY(y);
//                moveHistory.add(move);
//            } else {
//                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(),
//                        y, piece, board.getAt(x, y));
//                moveHistory.add(move);
//                board.removeAt(x, y);
//                piece.setCoordinatesX(x);
//                piece.setCoordinatesY(y);
//            }
//        }
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    public void setBoard(Board board) {
//        this.board = board;
//    }
//
//    public ArrayList<Move> getMoveHistory() {
//        return moveHistory;
//    }
//
//    public void setMoveHistory(ArrayList<Move> moveHistory) {
//        this.moveHistory = moveHistory;
//    }
//}
import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     *  .
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     *  .
     * @return .
     */
    public Board getBoard() {
        return board;
    }

    /**
     *  .
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     *  .
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     *  .
     */
    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    /**
     *  .
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
                moveHistory.add(move);
            } else {
                Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(),
                        y, piece, board.getAt(x, y));
                moveHistory.add(move);
                board.removeAt(x, y);
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }
}