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
        if (x == getCoordinatesX() || y == getCoordinatesY()) {
            Piece p = board.getAt(x, y);
            if (p == null) {
                return true;
            }
            if (!getColor().equals(p.getColor())) {
                return true;
            }
        }
        return false;
    }
}
