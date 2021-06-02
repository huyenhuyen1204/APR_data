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
        if (x == this.getCoordinatesX() || y == this.getCoordinatesY()) {
            if (x == this.getCoordinatesX()) {
                if (this.getCoordinatesY() > y) {
                    for (int i = y + 1; i < this.getCoordinatesY(); ++i) {
                        if (board.is_same(x, i)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getCoordinatesY() + 1; i < y; ++i) {
                        if (board.is_same(x, i)) {
                            return false;
                        }
                    }
                }
            } else if (y == this.getCoordinatesY()) {
                if (this.getCoordinatesX() > x) {
                    for (int i = x + 1; i < this.getCoordinatesX(); ++i) {
                        if (board.is_same(i, y)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getCoordinatesX() + 1; i < x; ++i) {
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
