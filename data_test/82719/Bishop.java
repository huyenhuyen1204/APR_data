public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int newX = getCoordinatesX();
        int newY = getCoordinatesY();

        if (x + y != newX + newY && x - y != newX - newY) {
            return false;
        }

        int maxX = (x > newX) ? x : newX;
        int maxY = (y > newY) ? y : newY;
        int minX = (x < newX) ? x : newX;
        int minY = (y < newY) ? y : newY;
        if (x + y == newX + newY) {
            for (int i = minX + 1; i < maxX; i++) {
                for (int j = minY + 1; j < maxY; j++) {
                    if (i + j == x + y) {
                        Piece piece = board.getAt(i, j);
                        if (piece != null) {
                            return false;
                        }
                    }
                }
            }
        }

        if (x - y == newX - newY) {
            for (int i = minX + 1; i < maxX; i++) {
                for (int j = minY + 1; j < maxY; j++) {
                    if (i - j == x - y) {
                        Piece piece = board.getAt(i, j);
                        if (piece != null) {
                            return false;
                        }
                    }
                }
            }
        }

        Piece piece = board.getAt(x, y);
        if (piece == null) {
            return true;
        }
        return (!getColor().equals(piece.getColor()));
    }
}
