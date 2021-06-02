public class Move {
   
   private int startX;
   private int startY;
   private int endX;
   private int endY;
   private Piece movedPiece;
   private Piece killedPiece;

   /**
    * c.
    * @param startX c.
    * @param startY c.
    * @param endX c.
    * @param endY c.
    * @param movedPiece c.
    * @param killedPiece c.
    */
   public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
      this.startX = startX;
      this.startY = startY;
      this.endX = endX;
      this.endY = endY;
      this.movedPiece = movedPiece;
      this.killedPiece = killedPiece;
   }

   /**
    * c.
    * @param startX c.
    * @param startY c.
    * @param endX c.
    * @param endY c.
    * @param movedPiece c.
    */
   public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
      this.startX = startX;
      this.startY = startY;
      this.endX = endX;
      this.endY = endY;
      this.movedPiece = movedPiece;
   }

   /**
    * c.
    */
   public String toString() {
      String[] letterPos = {"0", "a", "b", "c", "d", "e", "f", "g", "h"};
      String position = letterPos[endX] + endY;
      return String.format("%s-%s", movedPiece.getColor(), movedPiece.getSymbol() + position);
   }

   /**
    * c.
    */
   public int getStartX() {
      return this.startX;
   }

   /**
    * c.
    * @param startX c.
    */
   public void setStartX(int startX) {
      this.startX = startX;
   }

   /**
    * c.
    * @return c.
    */
   public int getStartY() {
      return this.startY;
   }

   /**
    * c.
    */
   public void setStartY(int startY) {
      this.startY = startY;
   }

   /**
    * c.
    */
   public int getEndX() {
      return this.endX;
   }

   /**
    * c.
    * @param endX c.
    */
   public void setEndX(int endX) {
      this.endX = endX;
   }

   /**
    * c.
    * @return c.
    */
   public int getEndY() {
      return this.endY;
   }

   /**
    * c.
    */
   public void setEndY(int endY) {
      this.endY = endY;
   }

   /**
    * c.
    */
   public Piece getMovedPiece() {
      return this.movedPiece;
   }

   /**
    * c.
    * @param movedPiece c.
    */
   public void setMovedPiece(Piece movedPiece) {
      this.movedPiece = movedPiece;
   }

   /**
    * c.
    * @return c.
    */
   public Piece getKilledPiece() {
      return this.killedPiece;
   }

   /**
    * c.
    */
   public void setKilledPiece(Piece killedPiece) {
      this.killedPiece = killedPiece;
   }
}
