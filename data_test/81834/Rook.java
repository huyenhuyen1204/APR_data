
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

    private int moveX(int value, int x) {
        if (value < x) {
            return value + 1;
        }
        if (value > x) {
            return value - 1;
        }
        return value;
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (!board.validate(x, y)) {
            return false;
        }
        int valueX = this.getCoordinatesX();
        int valueY = this.getCoordinatesY();
        while (valueX != x
                || valueY != y) {
            valueX = moveX(valueX, x);
            valueY = moveX(valueY, y);
            if (board.getAt(valueX, valueY) != null) {
                if (valueX < x || valueY < y) {
                    return false;
                }
                if (board.getAt(valueX, valueY).getColor().equals(getColor())) {
                    return false;
                }
            }
        }
        return true;
    }
}
