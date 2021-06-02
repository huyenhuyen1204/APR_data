/**
 * Created by CCNE on 19/11/2020.
 */
public class Rook extends Piece {

    /**
     * Loan .
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Loan .
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Loan .
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Loan .
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (this.getCoordinatesX() == x && this.getCoordinatesY() == y) {
            return false;
        } else {
            if (this.getCoordinatesX() == x) {
                int tempY = this.getCoordinatesY();
                for (int i = Math.min(tempY, y) + 1; i < Math.max(tempY, y); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                int tempX = this.getCoordinatesX();
                for (int i = Math.min(tempX, x) + 1; i < Math.max(tempX, x); i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
        }
        if (board.getAt(x, y) == null) {
            return true;
        } else {
            return !board.getAt(x, y).getColor().equals(this.getColor());
        }
    }
}
