public class Rook extends Piece {

    /**
     * fhsagdkas.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * asjhdfa.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * fshadk.
     */

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {

        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (x == this.getCoordinatesX()) {
            for (int i = y + 1; i < this.getCoordinatesY(); i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
            for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
            return true;
        }
        for (int i = this.getCoordinatesX() + 1; i < x; i++) {
            if (board.getAt(i, y) != null) {
                return false;
            }
        }
        for (int i = x + 1; i < this.getCoordinatesX(); i++) {
            if (board.getAt(i, y) != null) {
                return false;
            }
        }
        if (board.getAt(x, y) != null) {
            if (board.getAt(x, y).getColor().equals(this.getColor())) {
                return false;
            }
        }
        return true;
    }
}
