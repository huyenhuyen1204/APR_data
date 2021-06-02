public class Rook extends Piece {

   /**
    * c.
    * @param x c.
    * @param y c.
    */
   public Rook(int x, int y) {
      super(x, y);
   }
   
   /**
    * c.
    * @param x c.
    * @param y c.
    * @param color c.
    */
   public Rook(int x, int y, String color) {
      super(x, y, color);
   }

   /**
    * c.
    */
   public String getSymbol() {
      return "R";
   }

   /**
    * c.
    */
   public boolean canMove(Board board, int x, int y) {
      int diffX = (this.getCoordinatesX() - x);
      int diffY = (this.getCoordinatesY() - y);
      if (diffX == 0 && diffY == 0) {
         return true;
      }
      if (diffX * diffY != 0) {
         return false;
      }
      Piece t = board.getAt(x, y);
      if (t != null && t.getColor().equals(this.getColor())) {
         return false;
      }
      if (diffX != 0) {
         int direction = (diffX < 0) ? 1 : -1;
         int xt = this.getCoordinatesX() + direction;
         while (xt != x) {
            t = board.getAt(xt, y);
            if (t != null) {
               return false;
            }
            xt += direction;
         }
        
      }
      if (diffY != 0) {
         int direction = (diffY < 0) ? 1 : -1;
         int yt = this.getCoordinatesX() + direction;
         while (yt != y) {
            t = board.getAt(x, yt);
           if (t != null) {
              return false;
           }
           yt += direction;
         }
      }
      return true;
   }

}
