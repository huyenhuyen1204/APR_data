import java.util.ArrayList;

public class Rook extends Piece {
    /** binhdang. */
    public Rook(int x, int y) {
        super(x, y);
    }

    /** binhdang. */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /** binhdang. */
    public String getSymbol() {
        return "R";
    }

    /** binhdang. */
    public boolean canMove(Board board, int x1, int y1) {
        int x0 = super.getX();
        int y0 = super.getY();
        ArrayList<Piece> temp = board.getPieces();
        if (x1 == x0 && y1 != y0) {
            for (int i = Math.min(y1, y0) + 1; i <= Math.max(y1, y0) - 1; i++) {
                if (board.getAt(x1, i) != null) {
                    return false;
                }
            }
            Piece temp1 = board.getAt(x1, y1);
            return temp1 == null || !temp1.getColor().equals(super.getColor());
        } else if (x1 != x0 && y1 == y0) {
            for (int i = Math.min(x1, x0) + 1; i <= Math.max(x1, x0) - 1; i++) {
                if (board.getAt(i, y1) != null) {
                    return false;
                }
            }
            Piece temp1 = board.getAt(x1, y1);
            return temp1 == null || !temp1.getColor().equals(super.getColor());
        } else {
            return false;
        }
    }
}
