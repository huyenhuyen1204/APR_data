public class Rook extends Piece {
    Rook(int x, int y) {
        super(x, y);
    }

    Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (this.getCoordinatesX() == x && this.getCoordinatesY() == y) {
            return true;
        }
        if (this.getCoordinatesX() == x) {
            int y1 = this.getCoordinatesY();
            if (y < y1) {
                for (int i = y + 1; i < y1; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
                if (board.getAt(x, y) != null) {
                    board.removeAt(x, y);
                    return true;
                } else {
                    return true;
                }
            }
            if (y > y1) {
                for (int i = y1 + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
                if (board.getAt(x, y) != null) {
                    board.removeAt(x, y);
                    return true;
                } else {
                    return true;
                }
            }
        }
        if (this.getCoordinatesY() == y) {
            int x1 = this.getCoordinatesX();
            if (x < x1) {
                for (int i = x + 1; i < x1; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
                if (board.getAt(x, y) != null) {
                    board.removeAt(x, y);
                    return true;
                } else {
                    return true;
                }
            }
            if (x > x1) {
                for (int i = x1 + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
                if (board.getAt(x, y) != null) {
                    board.removeAt(x, y);
                    return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
