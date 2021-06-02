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
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            if (this.getCoordinatesX() == x) {
                for (Piece p : board.getPieces()) {
                    if ((this.getCoordinatesY() < p.getCoordinatesY()
                            && p.getCoordinatesY() < y)
                            || (this.getCoordinatesY() > p.getCoordinatesY()
                            && p.getCoordinatesY() > y)) {
                        return false;
                    }
                }
            } else if (this.getCoordinatesY() == y) {
                for (Piece p : board.getPieces()) {
                    if ((this.getCoordinatesX() < p.getCoordinatesX()
                            && p.getCoordinatesX() < x)
                            || (this.getCoordinatesX() > p.getCoordinatesX()
                            && p.getCoordinatesX() > x)) {
                        return false;
                    }
                }
            }
            for (Piece p : board.getPieces()) {
                if (this.getColor().compareTo(p.getColor()) == 0) {
                    if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                            return false;
                    }
                }
            }

            if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
                return false;
            }
            return true;
        }
        return false;
    }
}
