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
        if (this.getCoordinatesX() == x) {
            for (Piece p : board.getPieces()) {
                if ((this.getCoordinatesY() < p.getCoordinatesY() && p.getCoordinatesY() < y)
                || (this.getCoordinatesY() > p.getCoordinatesY() && p.getCoordinatesY() > y)) {
                     return false;
                }
            }
        } else if (this.getCoordinatesY() == y) {
            for (Piece p : board.getPieces()) {
                if ((this.getCoordinatesX() < p.getCoordinatesX() && p.getCoordinatesX() < x)
                        || (this.getCoordinatesX() > p.getCoordinatesX() && p.getCoordinatesX() > x)) {
                    return false;
                }
            }
        }

        return true;
    }
}
