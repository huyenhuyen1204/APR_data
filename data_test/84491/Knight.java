public class Knight extends Piece {
    public Knight(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Knight(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "N";
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

        if (Math.abs(currX - x) == 2 && Math.abs(currY - y) == 1) {
            return true;
        } else {
            return (Math.abs(currX - x) == 1 && Math.abs(currY - y) == 2);
        }
    }
}
