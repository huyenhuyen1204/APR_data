/**
 * .
 * @author Nguyen Quyet Thang .
 */
public class Rook extends Piece {
    /**
     * .
     * @param coordinatesX .
     * @param coordinatesY .
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * .
     * @param coordinatesX .
     * @param coordinatesY .
     * @param color .
     */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    /**
     * .
     * @return .
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * .
     * @param board .
     * @param x .
     * @param y .
     * @return
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int xCurrent = this.getCoordinatesX();
        int yCurrent = this.getCoordinatesY();

        if (xCurrent == x && yCurrent == y) {
            return false;
        }

        if (!board.getAt(x, y).getColor().equals(this.getColor())) {
            return true;
        }

        if (xCurrent == x) {
            if (yCurrent < y) {
                for (int i = yCurrent + 1; i <= y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = yCurrent - 1; i >= y; i--) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
        } else if (yCurrent == y) {
            if (xCurrent < x) {
                for (int i = xCurrent + 1; i <= x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = xCurrent - 1; i >= x; i--) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
