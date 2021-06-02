
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

    private int moveX(int x) {
        int value = this.getCoordinatesX();
        if (value < x) {
            return (value + 1);
        }
        if (value > x) {
            return (value - 1);
        }
        return value;
    }

    private int moveY(int y) {
        int value = this.getCoordinatesY();
        if (value < y) {
            return (value + 1);
        }
        if (value > y) {
            return (value - 1);
        }
        return value;
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        while (this.getCoordinatesX() != x
                && this.getCoordinatesY() != y) {
            int nextX = moveX(x);
            int nextY = moveY(y);
            if (board.getAt(nextX, nextY) != null) {
                if (nextX < x || nextY < y) {
                    return false;
                }
                board.removeAt(nextX, nextY);
            }
            this.setCoordinatesX(nextX);
            this.setCoordinatesY(nextY);
        }
        return true;
    }
}
