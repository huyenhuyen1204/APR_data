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
        if ((this.getX() == x && this.getY() == y) || !board.validate(x, y)) {
            return false;
        }
        if (board.getAt(x, y) != null && board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }
        return getX() == x || getY() == y;
    }

    @Override
    public boolean checkPosition(Piece piece) {
        return false;
    }
}
