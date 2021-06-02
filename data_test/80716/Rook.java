public class Rook extends Piece{

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
        if (this.getCoordinatesX() == x || this.getCoordinatesY() == y) {
            if (board.getAt(x, y) == null || !board.getAt(x, y).getColor().equals(this.getColor())) {
                return true;
            }
        }
        return false;
    }
}
