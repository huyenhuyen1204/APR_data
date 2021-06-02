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
        if (this.getX() != x && this.getY() != y) {
            return false;
        }
        if (this.getX() == x && this.getY() == y) {
            return false;
        } else {
            if (this.getX() == x) {
                for (int i = Math.min(this.getY(), y) + 1; i < Math.max(this.getY(), y); i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = Math.min(this.getX(), x) + 1; i < Math.max(this.getX(), x); i++) {
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
