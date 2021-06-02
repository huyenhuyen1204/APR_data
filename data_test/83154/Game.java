import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game(Board board) {
        this.board = board;
    }
    /**....*/

    public void movePiece(Piece piece, int x, int y) {
      if (board.validate(x, y)) {
          if (board.getAt(x, y) == null) {
              int a = piece.getCoordinatesX();
              int b = piece.getCoordinatesY();
              piece.setCoordinatesY(y);
              piece.setCoordinatesX(x);
              moveHistory.add(new Move(a, x, b, y, piece));
          } else {
              int a = piece.getCoordinatesX();
              int b = piece.getCoordinatesY();
              piece.setCoordinatesY(y);
              piece.setCoordinatesX(x);
              moveHistory.add(new Move(a, x, b, y, piece, board.getAt(x, y)));
              board.removeAt(x, y);
              board.addPiece(piece);
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

}
