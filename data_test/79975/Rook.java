public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public String getSymbol() {
        return "R";
    }

    /**canMove.*/
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || (this.getX() == x && this.getY() == y)) {
            return false;
        }
        if (this.getX() == x || this.getY() == y) {
            if (board.getAt(x, y) != null && board.getAt(x, y).getColor().equals(this.getColor())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPosition(Piece piece) {
        return false;
    }
}
