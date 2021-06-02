public class King extends Piece {
    public King(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public King(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "K";
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

        if (x == currX && y == currY) {
            return false;
        }

        return Math.abs(x - currX) <= 1 && Math.abs(y - currY) <= 1;
    }
}
