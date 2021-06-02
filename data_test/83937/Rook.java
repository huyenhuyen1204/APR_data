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
        if (super.getCoordinatesX() == x) {
            for (int i = 1; (i + super.getCoordinatesY()) < y; i++)
                if (board.validate(x, super.getCoordinatesY() + i)) {
                    if (((board.getAt(x, super.getCoordinatesY() + 1) == null)
                        && (!board.getAt(x, y).getColor().equals(super.getColor())))
                        || ((board.getAt(x, super.getCoordinatesY() + 1) == null)
                        && board.getAt(x, y) == null)) {
                    return true;
                }
            }
        }
        if (super.getCoordinatesY() == y) {
            for (int i = 1; (i + super.getCoordinatesX()) < x; i++)
                if (board.validate(super.getCoordinatesX() + i, y)) {
                    if (((board.getAt(super.getCoordinatesX() + i, y) == null)
                            && (!board.getAt(x, y).getColor().equals(super.getColor())))
                            || ((board.getAt(super.getCoordinatesX() + i, y) == null)
                                && board.getAt(x, y) == null)) {
                        return true;
                    }
                }
        }
        return false;
    }
}
