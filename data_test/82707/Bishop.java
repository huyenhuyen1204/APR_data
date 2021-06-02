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
        int _x = getCoordinatesX();
        int _y = getCoordinatesY();

        if (x + y != _x + _y && x - y != _x - _y) {
            return false;
        }

        int max_x = (x > _x) ? x : _x;
        int max_y = (y > _y) ? y : _y;
        int min_x = (x < _x) ? x : _x;
        int min_y = (y < _y) ? y : _y;
        if (x + y == _x + _y) {
            for (int i = min_x + 1; i < max_x; i++) {
                for (int j = min_y + 1; j < max_y; j++) {
                    if (i + j == x + y) {
                        Piece piece = board.getAt(i, j);
                        if (piece != null) {
                            return false;
                        }
                    }
                }
            }
        }

        if (x - y == _x - _y) {
            for (int i = min_x + 1; i < max_x; i++) {
                for (int j = min_y + 1; j < max_y; j++) {
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
        return (!getColor().equals(piece.getColor()));
    }
}
