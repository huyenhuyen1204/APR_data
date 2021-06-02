public class Rook extends Piece {

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board.validate(x, y)) {
            if ((board.getAt(x, y) == null)
                    || (!board.getAt(x, y).getColor().equals(super.getColor()))) {
                        if (super.getCoordinatesX() == x) {
                            return true;
                    }
                        if (super.getCoordinatesY() == y) {
                            return true;
                    }
                }
        }
        return false;
    }
}
