public class Rook extends Piece {

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * abc.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * abc.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x == this.getX() || y == this.getY()) {
            if (x == this.getX()) {
                if (this.getY() > y) {
                    for (int i = y + 1; i < this.getY(); ++i) {
                        if (board.is_same(x, i)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getY() + 1; i < y; ++i) {
                        if (board.is_same(x, i)) {
                            return false;
                        }
                    }
                }
            } else if (y == this.getY()) {
                if (this.getX() > x) {
                    for (int i = x + 1; i < this.getX(); ++i) {
                        if (board.is_same(i, y)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getX() + 1; i < x; ++i) {
                        if (board.is_same(i, y)) {
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
        return false;
    }

}
