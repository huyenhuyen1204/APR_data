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
        if (!board.validate(x, y)) {
            return false;
        }

        int coordinatesX = this.getCoordinatesX();
        int coordinatesY = this.getCoordinatesY();
        int rangeX = Math.abs(x - coordinatesX);
        int rangeY = Math.abs(y - coordinatesY);

        if (rangeX != 0 && rangeY != 0) {
            return false;
        }

        if (rangeX != 0) {
            int factorX = (x - coordinatesX) / rangeX;

            for (int i = 1; i < rangeX; i++) {
                int keyX = coordinatesX + factorX * i;
                if (board.getAt(keyX, coordinatesY) != null) {
                    return false;
                }
            }

            Piece res = board.getAt(x, y);
            if (res != null) {
                return !this.getColor().equals(res.getColor());
            }

        } else if (rangeY != 0) {
            int factorY = (y - coordinatesY) / rangeY;

            for (int i = 1; i < rangeY; i++) {
                int keyY = coordinatesY + factorY * i;
                if (board.getAt(coordinatesX, keyY) != null) {
                    return false;
                }
            }

            Piece res = board.getAt(x, y);
            if (res != null) {
                return !this.getColor().equals(res.getColor());
            }
        }

        return true;

    }
}
