public class Bishop extends Piece {

    Bishop(int x, int y) {
        super(x, y);
    }

    Bishop(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board == null
                || Math.abs(this.getCoordinatesX() - x) != Math.abs(this.getCoordinatesY() - y)) {
            return false;
        }

        int dx;
        int dy;
        if (this.getCoordinatesX() - x < 0) {
            dx = 1;
        } else {
            dx = -1;
        }
        if (this.getCoordinatesY() - y < 0) {
            dy = 1;
        } else {
            dy = -1;
        }

        int thisX = this.getCoordinatesX();
        int thisY = this.getCoordinatesY();
        while (thisX + dx != x) {
            thisX += dx;
            thisY += dy;
            if (board.getAt(thisX, thisY) != null) {
                return false;
            }
        }
        thisX += dx;
        thisY += dy;

        if (board.getAt(thisX, thisY) == null) {
            return true;
        }
        return !board.getAt(thisX, thisY).getColor().equals(this.getColor());
    }
}
