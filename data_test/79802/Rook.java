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
        if (getX() != x && getY() != y) {
            return false;
        }

        if (getX() == x) {
            for (int i = 0; i < board.getPieces().size(); i ++) {
                Piece p = board.getPieces().get(i);
                if ((getY() - p.getY()) * (y - p.getY()) < 0) {
                    return false;
                }

                if (y == p.getY() && p.getColor().equals(getColor())) {
                    return false;
                }
            }
        }

        if (getY() == y) {
            for (int i = 0; i < board.getPieces().size(); i ++) {
                Piece p = board.getPieces().get(i);
                if ((getX() - p.getX()) * (x - p.getX()) < 0) {
                    return false;
                }

                if (x == p.getX() && p.getColor().equals(getColor())) {
                    return false;
                }
            }
        }
        return true;
    }
}
