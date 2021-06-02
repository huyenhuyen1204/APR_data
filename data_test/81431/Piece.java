public abstract class Piece {
   
   private int coordinatesX;
   private int coordinatesY;
   private String color;

   /**
    * c.
    * @param x c.
    * @param y c.
    */
   public Piece(int x, int y) {
      this.coordinatesX = x;
      this.coordinatesY = y;
      this.color = "white";
   }

   /**
    * c.
    * @param x c.
    * @param y c.
    * @param color c.
    */
   public Piece(int x, int y, String color) {
      this.coordinatesX = x;
      this.coordinatesY = y;
      this.color = color.toLowerCase();
   }

   /**
    * c.
    */
   public abstract String getSymbol();

   /**
    * c.
    */
   public abstract boolean canMove(Board b, int x, int y);

   /** 
    * c.
   */
   public int getCoordinatesX() {
      return this.coordinatesX;
   }

   /**
    * c.
    */
   public void setCoordinatesX(int coordinatesX) {
      this.coordinatesX = coordinatesX;
   }

   /**
    * c.
    */
   public int getCoordinatesY() {
      return this.coordinatesY;
   }

   /**
    * 
    */
   public void setCoordinatesY(int coordinatesY) {
      this.coordinatesY = coordinatesY;
   }

   /**
    * c.
    */
   public String getColor() {
      return this.color;
   }

   /**
    * c.
    */
   public void setColor(String color) {
      this.color = color;
   }

   public boolean checkPosition(Piece p) {
      return p.coordinatesX > 0 && p.coordinatesX <= Board.WIDTH
            && p.coordinatesY <= Board.HEIGHT && p.coordinatesY > 0;
   } 

}