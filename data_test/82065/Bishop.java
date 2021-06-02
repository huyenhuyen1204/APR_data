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

        int directionX;
        int directionY;
        if (this.getCoordinatesX() - x < 0) {
            directionX = 1;
        } else {
            directionX = -1;
        }
        if (this.getCoordinatesY() - y < 0) {
            directionY = 1;
        } else {
            directionY = -1;
        }

        int thisX = this.getCoordinatesX();
        int thisY = this.getCoordinatesY();
        while (thisX + directionX != x) {
            thisX += directionX;
            thisY += directionY;
            return board.getAt(thisX, thisY) == null;
        }
        thisX += directionX;
        thisY += directionY;

        return !board.getAt(thisX, thisY).getColor().equals(this.getColor());
    }
}
