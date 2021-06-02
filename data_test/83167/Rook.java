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
        if (!board.validate(x, y)) {
            return false;
        }
        if (board.getAt(x, y).getColor().equals(getColor())) {
            return false;
        }
        if (x == getCoordinatesX()) {
           int a = getCoordinatesY();
           int b = y;
           if (a < b) {
               int t = a;
               a = b;
               b = t;
           }
           for (int i = b + 1; i < a; i++) {
               if (board.getAt(x, i) != null) {
                   return false;
               }
           }
            return true;
        }
        if (y == getCoordinatesY()) {
            int a = getCoordinatesX();
            int b = x;
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            for (int i = b + 1; i < a; i++) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }
}
