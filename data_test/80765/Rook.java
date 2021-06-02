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
        if (this.getCoordinatesX() == x) {
            for (Piece check : board.getPieces()) {
                if (check.getCoordinatesX() == x
                        && (check.getCoordinatesY() > Math.min(y, this.getCoordinatesY())
                        && check.getCoordinatesY() < Math.max(y, this.getCoordinatesY()))) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null
                    || !board.getAt(x, y).getColor().equals(this.getColor())){
                return true;
            }
        }
        if (this.getCoordinatesY() == y) {
            for (Piece check : board.getPieces()) {
                if (check.getCoordinatesY() == y
                        && (check.getCoordinatesX() > Math.min(x, this.getCoordinatesX())
                        && check.getCoordinatesX() < Math.max(x, this.getCoordinatesX()))) {
                    return false;
                }
            }
            if (board.getAt(x, y) == null
                    || !board.getAt(x, y).getColor().equals(this.getColor())){
                return true;
            }
        }

        return false;
    }
}
