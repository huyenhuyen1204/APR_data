/**
 * Created by CCNE on 30/11/2020.
 */
public class Bishop extends Piece {

    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        boolean con1 = (x >= 1) && (x <= 8);
        boolean con2 = (y >= 1) && (y <= 8);
        if (!con1 || !con2) {
            return false;
        }
        int deltaX = x - this.getCoordinatesX();
        int deltaY = y - this.getCoordinatesY();
        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            return false;
        }

        if (deltaX == 0) {
            return true;
        }

        if (board.getAt(x, y) != null) {
            if (board.getAt(x, y).getColor().equals(this)) {
                return false;
            }
        }

        int i = changeUnit(deltaX, getCoordinatesX());
        int j = changeUnit(deltaY, getCoordinatesY());

        while (i != x && j != y) {
            if (board.getAt(i, j) != null) {
                return false;
            }
            i = changeUnit(deltaX, i);
            j = changeUnit(deltaY, j);
        }

        return true;
    }

    private int changeUnit(int delta, int x) {
        if (delta < 0) {
            return --x;
        } else if (delta > 0) {
            return ++x;
        }
        return -1;
    }
}
