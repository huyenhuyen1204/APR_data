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
        if (x == this.getX() || y == this.getY()) {
            for (Piece piece : board.getPieces()) {
                if (piece.getX() == this.getX() && piece.getY() < Math.max(y, this.getY()) && piece.getY() > Math.min(y, this.getY())) {
                    return false;
                } else if (piece.getY() == this.getY() && piece.getX() < Math.max(x, this.getX()) && piece.getX() > Math.min(x, this.getX())) {
                    return false;
                } else if (piece.getY() == y && piece.getX() == x) {
                    return !piece.getColor().equals(this.getColor());
                }
            }
            return true;
        } else {
            return false;
        }

    }
}
