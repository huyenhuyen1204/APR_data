import java.util.ArrayList;

public class Game {
   
   private Board board;
   private static ArrayList<Move> moveHistory;

   /**
    * c.
    * @param board c.
    */
   public Game(Board board) {
      this.board = board;
      moveHistory = new ArrayList<>();
   }

   /**
    * c.
    */
   public void movePiece(Piece p, int x, int y) {
      if (p.canMove(board, x, y)) {
         Move m;
         Piece t = board.getAt(x, y); 
         if (t == null) {
            m = new Move(p.getCoordinatesX(), p.getCoordinatesY(), x, y, p);
         } else {
            m = new Move(p.getCoordinatesX(), p.getCoordinatesY(), x, y, p, t);
            board.removeAt(x, y);
         }
         moveHistory.add(m);
         p.setCoordinatesX(x);
         p.setCoordinatesY(y);
         board.addPiece(p);
      }
   }
   /**
    * c.
    */
   public Board getBoard() {
      return this.board;
   }

   /**
    * c.
    */
   public void setBoard(Board board) {
      this.board = board;
   }

   public ArrayList<Move> getMoveHistory() {
      return this.moveHistory;
   }
}
