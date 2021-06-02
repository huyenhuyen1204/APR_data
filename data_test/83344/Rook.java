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
            if (this.getCoordinatesX() != coordinatesX && this.getCoordinatesY() != coordinatesY) {
                return false;
            }
            if (coordinatesX < this.getCoordinatesX()) {
                for (int i = coordinatesX + 1; i < this.getCoordinatesX(); i++) {
                    Piece piece = board.getAt(i, this.getCoordinatesY());
                    if (piece != null) {
                        return false;
                    }
                }
            } else if (coordinatesX > this.getCoordinatesX()) {
                for (int i = this.getCoordinatesX() + 1; i < coordinatesX; i++) {
                    Piece piece = board.getAt(i, this.getCoordinatesY());
                    if (piece != null) {
                        return false;
                    }
                }
            }
            if (coordinatesY < this.getCoordinatesY()) {
                for (int i = coordinatesY + 1; i < this.getCoordinatesY(); i++) {
                    Piece piece = board.getAt(this.getCoordinatesX(), i);
                    if (piece != null) {
                        return false;
                    }
                }
            } else if (coordinatesY > this.getCoordinatesY()) {
                for (int i = this.getCoordinatesY() + 1; i < coordinatesY; i++) {
                    Piece piece = board.getAt(this.getCoordinatesX(), i);
                    if (piece != null) {
                        return false;
                    }
                }
            }


            return true;
        }
        return false;
    }
}
