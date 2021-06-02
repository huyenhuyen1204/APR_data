public class Rook extends Piece{
    /**
     * javadoc.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * javadoc.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * javadoc.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * javadoc.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || (x != getX() && y != getY())) {
            return false;
        }

        if (x == getX()) {
            if (y > getY()) {
                for (int i = getY() + 1; i < y; ++i) {
                    if (board.getAt(getX(), i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getY() - 1; i > y; --i) {
                    if (board.getAt(getX(), i) != null) {
                        return false;
                    }
                }
            }
        } else {
            if (x < getX()) {
                for (int i = getY() - 1; i > y; --i) {
                    if (board.getAt(i, getY()) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getX() + 1; i < x; ++i) {
                    if (board.getAt(i, getY()) != null) {
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
