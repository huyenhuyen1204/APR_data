public class Rook extends Piece {
    /**
     * Ham khoi tao 2 tham so.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Ham khoi tao 3 tham so.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * cmt.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * cmt.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || (x != getCoordinatesX() && y != getCoordinatesY())) {
            return false;
        }

        if (x == getCoordinatesX()) {
            if (y > getCoordinatesY()) {
                for (int i = getCoordinatesY() + 1; i < y; ++i) {
                    if (board.getAt(getCoordinatesX(), i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getCoordinatesY() - 1; i > y; --i) {
                    if (board.getAt(getCoordinatesX(), i) != null) {
                        return false;
                    }
                }
            }
        } else {
            if (x < getCoordinatesY()) {
                for (int i = getCoordinatesY() - 1; i > y; --i) {
                    if (board.getAt(i, getCoordinatesY()) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getCoordinatesX() + 1; i < x; ++i) {
                    if (board.getAt(i, getCoordinatesY()) != null) {
                        return false;
                    }
                }
            }
        }
        if (board.getAt(x, y) != null && board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }
        return true;
    }
}
