public class Rook extends Piece{
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board.getAt(x, y) == null) {
            return true;
        }
        if (this.getCoordinatesX() == x || this.getCoordinatesY() == y) {
            return true;
        }
        for (int i = 0; i < board.getPieces().size(); i++) {
            if (board.getPieces().get(i).getCoordinatesX() == x
                    && board.getPieces().get(i).getCoordinatesY() == y) {
                if (board.getPieces().get(i).getColor().equals(this.getColor())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
