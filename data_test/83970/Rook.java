public class Rook extends Piece {

    /**
     * Constructor.
     */
    public Rook(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    /**
     * Constructor.
     */
    public Rook(int coordinateX, int coordinateY, String color) {
        super(coordinateX, coordinateY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        boolean check = true;
        if ((1 <= x && x <= 8) && (1 <= y && y <= 8)) {
            if (getCoordinatesX() != x && getCoordinatesY() != y) {
                check = false;
            }

            if (getCoordinatesX() == x) {
                for (int i = Math.min(getCoordinatesY(), y) + 1;
                     i <= Math.max(getCoordinatesY(), y) - 1; i++) {
                    if (board.getAt(x, i) != null) {
                        check = false;
                    }
                }
            }

            if (getCoordinatesY() == y) {
                for (int i = Math.min(getCoordinatesX(), x) + 1;
                    i <= Math.max(getCoordinatesX(), x) - 1; i++) {
                    if (board.getAt(i, y) != null) {
                        check = false;
                    }
                }
            }

            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equalsIgnoreCase(this.getColor())) {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
}
