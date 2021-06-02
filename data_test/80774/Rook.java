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
     * @return .
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int xcurrent = this.getCoordinatesX();
        int ycurrent = this.getCoordinatesY();

        if (xcurrent == x && ycurrent == y) {
            return false;
        }

        if (xcurrent == x) {
            if (ycurrent < y) {
                for (int i = ycurrent + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = ycurrent - 1; i > y; i--) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
        } else if (ycurrent == y) {
            if (xcurrent < x) {
                for (int i = xcurrent + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = xcurrent - 1; i > x; i--) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
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
        return true;
    }

}
