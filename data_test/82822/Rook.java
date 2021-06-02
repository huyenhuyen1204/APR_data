public class Rook extends Piece {

    /**
     * ...
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * ...
     */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {

        if (this.getCoordinatesX() != x
                && this.getCoordinatesY() != y) {
            return false;
        }

        if (this.getCoordinatesX() == x) {
            for (int i = Math.min(y, this.getCoordinatesY()) + 1;
                 i <= Math.max(y, this.getCoordinatesY()) - 1; i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        }
        if (this.getCoordinatesY() == y) {
            for (int i = Math.min(x, this.getCoordinatesX()) + 1;
                 i <= Math.max(x, this.getCoordinatesX()) - 1; i++) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
        }

        if (board.getAt(x, y) != null) {
            if (board.getAt(x, y).getColor().equalsIgnoreCase(this.getColor())) {
                return false;
            }
            kill = true;
        }
        return true;
    }
}
