public class Rook extends Piece {

    /**
     * Constructor.
     */
    public Rook(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    /**
     * Constructor.
     */
    public Rook(int coordinateX, int coordinateY, String color) {
        super(coordinateX, coordinateY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x <= 8 && y <= 8) {
            if (board.getAt(x, y) != null) {
                return true;
            } else {
                if (board.getAt(x, y).getColor().equals(this.getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
