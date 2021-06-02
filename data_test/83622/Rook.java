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
        if (x == this.getCoordinatesX()) {
            if (y > this.getCoordinatesY()) {
                for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else if (y < this.getCoordinatesY()) {
                for (int i = y + 1; i < this.getCoordinatesY(); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                }
            }
            return true;
        }
        if (y == this.getCoordinatesY()) {
            if (x > this.getCoordinatesX()) {
                for (int i = this.getCoordinatesX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            } else if (x < this.getCoordinatesX()) {
                for (int i = x + 1; i < this.getCoordinatesX(); i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (board.getAt(x, y) != null) {
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}