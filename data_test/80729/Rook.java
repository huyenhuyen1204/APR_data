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
        if (this.getCoordinatesX() == x) {
            for (int i = 1; i < y; i++) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null
                    || board.getAt(x, y).getColor().equals(this.getColor())) {
                return true;
            }
        }
        if (this.getCoordinatesY() == y) {
            for (int i = 1; i < x; i++) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null
                    || board.getAt(x, y).getColor().equals(this.getColor())) {
                return true;
            }
        }
        return false;
    }
}
