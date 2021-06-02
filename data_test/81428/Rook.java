public class Rook extends Piece {
    /**
     * .
     *
     * @param coodinatesX .
     * @param coodinatesY .
     */
    public Rook(int coodinatesX, int coodinatesY) {
        super(coodinatesX, coodinatesY);
    }

    /**
     * .
     *
     * @param coodinatesX .
     * @param coodinatesY .
     * @param color       .
     */
    public Rook(int coodinatesX, int coodinatesY, String color) {
        super(coodinatesX, coodinatesY, color);
    }

    /**
     * .
     *
     * @return .
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * .
     *
     * @param board .
     * @param x     .
     * @param y     .
     * @return .
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x == getCoordinatesX() && y == getCoordinatesY()) {
            return false;
        }
        if (x == getCoordinatesX()) {
            for (int i = getCoordinatesY() + 1; i < y; i++) {
                Piece p = board.getAt(x, i);
                if (p != null) {
                    return false;
                }
            }
            for (int i = getCoordinatesY() - 1; i > y; i--) {
                Piece p = board.getAt(x, i);
                if (p != null) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null) {
                return true;
            }
            if (board.getAt(x, y).getColor().equals(getColor())) {
                return false;
            }
            return true;
        }
        if (y == getCoordinatesY()) {
            for (int i = getCoordinatesX() + 1; i < x; i++) {
                Piece p = board.getAt(i, y);
                if (p != null) {
                    return false;
                }
            }
            for (int i = getCoordinatesX() - 1; i > x; i--) {
                Piece p = board.getAt(i, y);
                if (p != null) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null) {
                return true;
            }
            if (board.getAt(x, y).getColor().equals(getColor())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
