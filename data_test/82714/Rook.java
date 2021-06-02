public class Rook extends Piece {

    /**
     * ...
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * ...
     */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (this.getCoordinatesX() == x
                && this.getCoordinatesY() == y) {
            return false;
        }

        if ((this.getCoordinatesX() == x
                || this.getCoordinatesY() == y)
                && board.validate(x, y)) {
            for (Piece piece : board.getPieces()) {
                if (piece.getCoordinatesX() == x
                        && piece.getCoordinatesY() == y) {
                    if (piece.getColor().equals(this.getColor())) {
                        return false;
                    } else {
                        kill = true;
                        return true;
                    }
                }
            }
            return true;
        }

        return false;
    }
}
