public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x != getCoordinatesX()) {
            if (y != getCoordinatesY()) {
                return false;
            }
            if (x > getCoordinatesX()) {
                for (int i = getCoordinatesX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getCoordinatesX() + 1; i > x; i--) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            if (y > getCoordinatesY()) {
                for (int i = getCoordinatesY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = getCoordinatesY() + 1; i > y; i--) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }
}
