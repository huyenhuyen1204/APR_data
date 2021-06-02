public class Bishop extends Piece {
    public Bishop() {

    }

    /**
     * initialize method.
     */
    public Bishop(int x, int y, String color) {
        this.setCoordinatesX(x);
        this.setCoordinatesY(y);
        this.setColor(color);
    }

    public Bishop(int coordinatesX, int coordinatesY) {
        this.setCoordinatesX(coordinatesX);
        this.setCoordinatesY(coordinatesY);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }
        if (getCoordinatesX() == x && getCoordinatesY() == y) {
            return false;
        }
        if (!(Math.abs(getCoordinatesX() - x) == Math.abs(getCoordinatesY() - y))) {
            return false;
        }
        int directionX = getCoordinatesX() < x ? 1 : -1;
        int directionY = getCoordinatesY() < y ? 1 : -1;
        for (int currentX = getCoordinatesX() + directionX,
             currentY = getCoordinatesY() + directionY;
             !(currentX == x && currentY == y); currentX += directionX, currentY += directionY) {
            if (board.getAt(currentX, currentY) != null) {
                return false;
            }
        }
        Piece piece = board.getAt(x, y);
        if (piece != null) {
            return !piece.getColor().equals(this.getColor());
        }
        return true;
    }
}
