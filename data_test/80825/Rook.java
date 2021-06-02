
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
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        } else if (!board.validate(x, y)) {
            return false;
        } else {
            if (this.getCoordinatesY() == y) {
                int start = Math.min(this.getCoordinatesX(), x);
                int end = Math.max(this.getCoordinatesX(), x);
                for (int i = start + 1; i < end; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
                return true;
            } else {
                int start = Math.min(this.getCoordinatesY(), y);
                int end = Math.max(this.getCoordinatesY(), y);
                for (int i = start + 1; i < end; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
