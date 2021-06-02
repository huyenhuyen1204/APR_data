public class Rook extends Piece {
    /**4.*/
    public Rook(int x, int y) {
        super(x, y);
    }

    /**4.*/
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**4.*/
    @Override
    public String getSymbol() {
        return "R";
    }

    /**4.*/
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board.validate(x, y)) {
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                }
            }
            if (this.getX() != x && this.getY() != y) {
                return false;
            } else {
                if (this.getX() == x && this.getY() == y) {
                    return true;
                }
                if (this.getX() == x) {
                    if (this.getY() < y) {
                        for (int i = this.getY() + 1; i < y; i++) {
                            if (board.getAt(x, i) != null) {
                                return false;
                            }
                        }
                    } else {
                        for (int i = this.getY() - 1; i > y; i--) {
                            if (board.getAt(x, i) != null) {
                                return false;
                            }
                        }
                    }
                }
                if (this.getY() == y) {
                    if (this.getX() < x) {
                        for (int i = this.getX() + 1; i < x; i++) {
                            if (board.getAt(i, y) != null) {
                                return false;
                            }
                        }
                    } else {
                        for (int i = this.getX() - 1; i > x; i--) {
                            if (board.getAt(i, y) != null) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
