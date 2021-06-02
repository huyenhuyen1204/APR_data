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
    public boolean canMove(Board board, int coordinatesX, int coordinatesY) {
        if (board.validate(coordinatesX, coordinatesY)) {
            for (int i = 1; i <= 8; i++) {
                Piece piece = board.getAt(i, this.getCoordinatesY());
                    if (piece != null) {
                        if (coordinatesX < piece.getCoordinatesX()
                                && piece.getCoordinatesX() < this.getCoordinatesX()) {
                            return false;
                        }
                        if (coordinatesX > piece.getCoordinatesX()
                                && piece.getCoordinatesX() > this.getCoordinatesX()) {
                            return false;
                        }
                    }
            }

            for (int i = 1; i <= 8; i++) {
                Piece piece = board.getAt(this.getCoordinatesX(), i);
                    if (piece != null) {
                        if (coordinatesY < piece.getCoordinatesY()
                                && piece.getCoordinatesY() < this.getCoordinatesY()) {
                            return false;
                        }
                        if (coordinatesY > piece.getCoordinatesY()
                                && piece.getCoordinatesY() > this.getCoordinatesY()) {
                            return false;
                        }
                    }

            }
            return true;
        }
        return false;
    }
}
