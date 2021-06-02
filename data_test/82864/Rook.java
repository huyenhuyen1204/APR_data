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
        for (int i = Math.min(x, getCoordinatesX()) + 1; i < Math.max(x, getCoordinatesX()); i++) {
            if (board.getAt(i, getCoordinatesY()) != null) {
                return false;
            }
        }
        for (int i = Math.min(y, getCoordinatesY()) + 1; i < Math.max(y, getCoordinatesY()); i++) {
            if (board.getAt(getCoordinatesX(), i) != null) {
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
