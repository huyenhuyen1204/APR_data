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
      String position = letterPos[movedPiece.getCoordinatesX()] + movedPiece.getCoordinatesY();
      return String.format("%s-%s", movedPiece.getColor(), movedPiece.getSymbol() + position);
   }

   public int getStartX() {
      return this.startX;
   }

   public void setStartX(int startX) {
      this.startX = startX;
   }

   public int getStartY() {
      return this.startY;
   }

   public void setStartY(int startY) {
      this.startY = startY;
   }

   public int getEndX() {
      return this.endX;
   }

   public void setEndX(int endX) {
      this.endX = endX;
   }

   public int getEndY() {
      return this.endY;
   }

   public void setEndY(int endY) {
      this.endY = endY;
   }

   public Piece getMovedPiece() {
      return this.movedPiece;
   }

   public void setMovedPiece(Piece movedPiece) {
      this.movedPiece = movedPiece;
   }

   public Piece getKilledPiece() {
      return this.killedPiece;
   }

   public void setKilledPiece(Piece killedPiece) {
      this.killedPiece = killedPiece;
   }


}
