public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        } else if (getColor().equals(board.getAt(x, y).getColor())) {
            return false;
        }

        int currX = this.getCoordinatesX();
        int currY = this.getCoordinatesY();

        if (x - currX == y - currY && x > currX) {
            for (int i = currX + 1, j = currY + 1; i < currX; i++, j++) {
                if (board.getAt(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if (x - currX == currY - y && x > currX) {
            for (int i = currX + 1, j = currY - 1; i < currX; i++, j--) {
                if (board.getAt(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if (x - currX == y - currY && x < currX) {
            for (int i = currX - 1, j = currY - 1; i > currX; i--, j--) {
                if (board.getAt(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if (x - currX == currY - y && x < currX) {
            for (int i = currX - 1, j = currY - 1; i > currX; i--, j++) {
                if (board.getAt(i, j) != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
