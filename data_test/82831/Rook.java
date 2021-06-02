public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            return false;
        }
        for (int i = getCoordinatesX(); i < x; i++) {
            if (board.getAt(i, y) != null) {
                return false;
            }
        }
        for (int i = getCoordinatesY(); i < y; i++) {
            if (board.getAt(x, i) != null) {
                return false;
            }
        }
        Piece piece = board.getAt(x, y);
        if (piece != null) {
            if (piece.getColor() != this.getColor()) {
                board.removeAt(x, y);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
