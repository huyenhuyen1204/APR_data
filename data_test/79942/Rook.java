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
        if (board.getAt(x, y) != null && board.getAt(x, y).getColor() == this.getColor()) return false;
        if (x == this.getX()) {
            if (y > this.getY()) {
                for (int i = this.getY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            if (y < this.getY()) {
                for (int i = y + 1; i < this.getY(); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (y == this.getY()) {
            if (x > this.getX()) {
                for (int i = this.getX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
            if (x < this.getX()) {
                for (int i = x + 1; i < this.getX(); i++) {
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
