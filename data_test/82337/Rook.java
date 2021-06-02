public class Rook extends Piece {
    /**
     * Javadoc Comment.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Javadoc Comment.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Javadoc Comment.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Javadoc Comment.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }
        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }
        for (Piece p : board.getPieces()) {
            if (x == p.getCoordinatesX() && y == p.getCoordinatesY()) {
                if (p.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        }
        return true;
    }
}
