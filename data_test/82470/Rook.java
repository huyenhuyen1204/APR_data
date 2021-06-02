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
        if (x == this.getCoordinatesX() && y == this.getCoordinatesY()) {
            return false;
        }
        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }

        String direction = (x == this.getCoordinatesX()) ? "Oy" : "Ox";
        if (direction.equals("Ox")) {
            int distance = Math.abs(x - this.getCoordinatesX());
            for (Piece p : board.getPieces()) {
                if (p.getCoordinatesY() == this.getCoordinatesY()) {
                    if ((x - this.getCoordinatesX())
                            * (p.getCoordinatesX() - this.getCoordinatesX()) > 0) {
                        if (distance > Math.abs(p.getCoordinatesX() - this.getCoordinatesX())) {
                            return false;
                        }
                    }
                }
            }
        } else {
            int distance = Math.abs(y - this.getCoordinatesY());
            for (Piece p : board.getPieces()) {
                if (p.getCoordinatesX() == this.getCoordinatesX()) {
                    if ((y - this.getCoordinatesY())
                            * (p.getCoordinatesY() - this.getCoordinatesY()) > 0) {
                        if (distance > Math.abs(p.getCoordinatesY() - this.getCoordinatesY())) {
                            return false;
                        }
                    }
                }
            }
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
