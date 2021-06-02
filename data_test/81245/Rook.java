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
                String key = (coordinatesX + factorX * i) + ";" + coordinatesY;
                if (board.mapPieces.containsKey(key)) {
                    return false;
                }
            }

            Piece value = board.mapPieces.get(x + ";" + y);
            if (value != null) {
                if (value.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        } else if (rangeY != 0) {
            int factorY = (y - coordinatesY) / rangeY;

            for (int i = 1; i < rangeY; i++) {
                String key = coordinatesX  + ";" + (coordinatesY + factorY * i);
                if (board.mapPieces.containsKey(key)) {
                    return false;
                }
            }

            Piece value = board.mapPieces.get(x + ";" + y);
            if (value != null) {
                if (value.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        }

        return true;

    }
}
