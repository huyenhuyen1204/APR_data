public class Rook extends Piece {
    /**
     *  .
     * @param coordinatesX .
     * @param coordinatesY .
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     *  .
     * @param coordinatesX .
     * @param coordinatesY .
     * @param color .
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
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (this.getCoordinatesX() == x || this.getCoordinatesY() == y) {
            if (x > this.getCoordinatesX()) {
                for (int i = this.getCoordinatesX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (x < this.getCoordinatesX()) {
                for (int i = x + 1; i < this.getCoordinatesX(); i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (y > this.getCoordinatesY()) {
                for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            if (y < this.getCoordinatesY()) {
                for (int i = y + 1; i < this.getCoordinatesY(); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < board.getPieces().size(); i++) {
                if (board.getPieces().get(i).getCoordinatesX() == x
                        && board.getPieces().get(i).getCoordinatesY() == y) {
                    if (board.getPieces().get(i).getColor().equals(this.getColor())) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
