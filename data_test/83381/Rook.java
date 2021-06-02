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
        for (int c = 0; c < 4; c++) {
            int xt = ((getCoordinatesX() + x) + c % 2 * 8) / Board.WIDTH; //divide with tiles size to pass to tile coordinate
            int yt = ((getCoordinatesY() + y) + c / 2 * 7 - 8) / Board.HEIGHT;
            Piece piece = board.getAt(xt, yt);

            if (!piece.checkPosition()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkPosition() {
        return false;
    }
}
