public class Rook extends Piece {

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
       if (board.validate(x, y)) {
           if ((board.getAt(x, y) == null)
           || (!board.getAt(x, y).getColor().equals(super.getColor()))) {
               if (super.getCoordinatesX() == x) {
                   for (int i = 1; i <= 8; i++) {
                       if ((i < super.getCoordinatesY() && i > y)
                               || (i > super.getCoordinatesY() && i < y)) {
                           if (board.getAt(x, i) != null) {
                               return false;
                           }
                       }
                   }
                   return true;
               }
               if (super.getCoordinatesY() == y) {
                   for (int i = 1; i <= 8; i++) {
                       if ((i < super.getCoordinatesX() && i > x)
                               || (i > super.getCoordinatesX() && i < x)) {
                           if (board.getAt(i, y) != null) {
                               return false;
                           }
                       }
                   }
                   return true;
               }
           }
       }
       return false;
    }
}
