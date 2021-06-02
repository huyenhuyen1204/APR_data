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
        if (getCoordinatesX() != x && getCoordinatesY() != y) {
            return false;
        }

        if (getCoordinatesX() == x) {
            for (int i = 0; i < board.getPieces().size(); ++ i) {
                Piece p = board.getPieces().get(i);
                if ((getCoordinatesY() - p.getCoordinatesY()) * (y - p.getCoordinatesY()) < 0) {
                    return false;
                }

                if (y == p.getCoordinatesY() && p.getColor().equals(getColor())) {
                    return false;
                }
            }
        }

        if (getCoordinatesY() == y) {
            for (int i = 0; i < board.getPieces().size(); ++ i) {
                Piece p = board.getPieces().get(i);
                if ((getCoordinatesX() - p.getCoordinatesX()) * (x - p.getCoordinatesX()) < 0) {
                    return false;
                }

                if (x == p.getCoordinatesX() && p.getColor().equals(getColor())) {
                    return false;
                }
            }
        }
        return true;
    }
}
