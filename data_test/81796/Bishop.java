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
        //boolean check = true;
        int _x = getCoordinatesX();
        int _y = getCoordinatesY();

        int max_x = (x > _x) ? x : _x;
        int max_y = (y > _y) ? y : _y;
        int min_x = (x < _x) ? x : _x;
        int min_y = (y < _y) ? y : _y;
        for (int i = min_x; i <= max_x; i++) {
            for (int j = min_y; j <= max_y; j++) {
                if (i + j == x + y || i - j == i - j) {
                    Piece piece = board.getAt(i, j);
                    if (piece == null) {
                        return true;
                    }
                }
            }
        }
        if (x + y != _x + _y && x - y != _x - _y) {
            return false;
        }
        Piece piece = board.getAt(x, y);
        return (!getColor().equals(piece.getColor()));
    }
}
