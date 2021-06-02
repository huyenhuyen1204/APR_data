public class Rook extends Piece {
    Rook(int x, int y) {
        super(x, y);
    }

    /**uyds.*/
    Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**uyds.*/
    public String getSymbol() {
        return "R";
    }

    /**uyds.*/
    public boolean canMove(Board board, int x, int y) {
        if (board.validate(x, y)) {
            if (x == this.getX()) {
                if (this.getY() > y) {
                    for (int i = y + 1; i < this.getY(); i++) {
                        if (board.getAt(x, i) != null) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getY() + 1; i < y; i++) {
                        if (board.getAt(x, i) != null) {
                            return false;
                        }
                    }
                }
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                }
            } else {
                if (this.getX() > x) {
                    for (int i = x + 1; i < this.getX(); i++) {
                        if (board.getAt(i, y) != null) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getX() + 1; i < x; i++) {
                        if (board.getAt(i, y) != null) {
                            return false;
                        }
                    }
                }
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
