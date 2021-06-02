public class Rook extends Piece {

    /**
     * constructor1.
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * constructor2.
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
        int xa = this.getCoordinatesX();
        int ya = this.getCoordinatesY();
        if ((xa != x && ya != y) || (xa == x && ya == y) || !board.validate(x, y)) {
            return false;
        } else {
            if (xa == x && y > ya) {
                for (int i = ya + 1; i < y; i++) {
                    Piece piece = board.getAt(x, i);
                    if (piece != null) {
                        return false;
                    }
                }
            } else if (xa == x && y < ya) {
                for (int i = ya - 1; i > y; i--) {
                    Piece piece = board.getAt(x, i);
                    if (piece != null) {
                        return false;
                    }
                }
            } else if (ya == y && x > xa) {
                for (int i = xa + 1; i < x; i++) {
                    Piece piece = board.getAt(i, y);
                    if (piece != null) {
                        return false;
                    }
                }
            } else if (ya == y && x < xa) {
                for (int i = xa - 1; i > x; i--) {
                    Piece piece = board.getAt(i, y);
                    if (piece != null) {
                        return false;
                    }
                }
            }
        }
        if (board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }
        return true;
    }
}
