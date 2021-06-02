
public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public String getSymbol() {
        return "R";
    }

    private void moveX(int value, int x) {
        if (value < x) {
            value = (value + 1);
        }
        if (value > x) {
            value = (value - 1);
        }
    }

    private void moveY(int value, int y) {
        if (value < y) {
            value = (value + 1);
        }
        if (value > y) {
            value = (value - 1);
        }
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        int valueX = this.getCoordinatesX();
        int valueY = this.getCoordinatesY();
        while (valueX != x
                && valueY != y) {
            if (board.getAt(valueX, valueY) != null) {
                if (valueX < x || valueY < y) {
                    return false;
                }
            }
            moveX(valueX, x);
            moveY(valueY, y);
        }
        return true;
    }
}
