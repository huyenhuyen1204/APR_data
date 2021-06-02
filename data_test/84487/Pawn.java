public class Pawn extends Piece {
    public Pawn(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Pawn(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return null;
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

        if (getColor().equals("white")) {
            if (currX == x && currY == 2 && y == 4
                    && board.getAt(x, 3) == null && board.getAt(x, 4) == null) {
                return true;
            } else if (x == currX && y - currY == 1 && board.getAt(x, y) == null) {
                return true;
            } else return Math.abs(x - currX) == 1 && y - currY == 1 && board.getAt(x, y) != null;
        } else if (getColor().equals("black")) {
            if (currX == x && currY == 7 && y == 5
                    && board.getAt(x, 6) == null && board.getAt(x, 5) == null) {
                return true;
            } else if (x == currX && currY - y == 1 && board.getAt(x, y) == null) {
                return true;
            } else return Math.abs(x - currX) == 1 && currY - y == 1 && board.getAt(x, y) != null;
        }

        return false;
    }
}
