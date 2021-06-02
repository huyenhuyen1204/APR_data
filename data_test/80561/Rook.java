public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x == this.getCoordinatesX() || y == this.getCoordinatesY()) {
            for (Piece piece : board.getPieces()) {
                if (piece.getCoordinatesX() == this.getCoordinatesX() && piece.getCoordinatesY() < Math.max(y, this.getCoordinatesY())
                        && piece.getCoordinatesY() > Math.min(y, this.getCoordinatesY())) {
                    return false;
                } else if (piece.getCoordinatesY() == this.getCoordinatesY() && piece.getCoordinatesX() < Math.max(x, this.getCoordinatesX())
                        && piece.getCoordinatesX() > Math.min(x, this.getCoordinatesX())) {
                    return false;
                } else if (piece.getCoordinatesY() == y && piece.getCoordinatesX() == x) {
                    return !piece.getColor().equals(this.getColor());
                }
            }
            return true;
        } else {
            return false;
        }

    }
}
