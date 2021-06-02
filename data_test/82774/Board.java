import java.util.ArrayList;

public class Board {

   public static final int WIDTH = 8;
   public static final int HEIGHT = 8;
   private ArrayList<Piece> pieces;

   /**
    * c.
    */
   public Board() {
      pieces = new ArrayList<>();
   }

   /**
    * c.
    */
   public void addPiece(Piece p) {
      int x = p.getCoordinatesX();
      int y = p.getCoordinatesY();
      if (validate(x, y) && getAt(x, y) == null) {
         this.pieces.add(p);
      }
   }

   /**
    * c.
    */
   public boolean validate(int x, int y) {
      return x > 0 && x <= Board.WIDTH && y <= Board.HEIGHT && y > 0;
   }

   /**
    * c.
    */
   public void removeAt(int x, int y) {
      int i = 0;
      while (i < this.pieces.size()) {
         if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
            pieces.remove(i);
            return;
         }
         i++;
      }
   }

   /**
    * c.
    */
   public Piece getAt(int x, int y) {
      int i = 0;
      while (i < this.pieces.size()) {
         if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
            return pieces.get(i);
         }
         i++;
      }
      return null;
   }

   /**
    * c.
    */
   public ArrayList<Piece> getPieces() {
      return this.pieces;
   }

   /**
    * c.
    */
   public void setPieces(ArrayList<Piece> pieces) {
      this.pieces = pieces;
   }

}
