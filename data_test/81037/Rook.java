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
        if (board.getAt(x, y) != null && board.getAt(x, y).getColor() == this.getColor()) {
            return false;
        }
        if (x == this.getCoordinatesX()) {
            if (y > this.getCoordinatesY()) {
                for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            if (y < this.getCoordinatesY()) {
                for (int i = y + 1; i < this.getCoordinatesY(); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (y == this.getCoordinatesY()) {
            if (x > this.getCoordinatesX()) {
                for (int i = this.getCoordinatesX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (x < this.getCoordinatesX()) {
                for (int i = x + 1; i < this.getCoordinatesX(); i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
