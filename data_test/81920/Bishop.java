public class Bishop extends Piece {

    public Bishop(int coordinatesX, int coordinateY) {
        super(coordinatesX, coordinateY);
    }

    public Bishop(int coordinatesX, int coordinateY, String color) {
        super(coordinatesX, coordinateY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board == null) {
            return false;
        }
        if (Math.abs(this.getCoordinatesX() - x) != Math.abs(this.getCoordinatesY() - y)) {
            return false;
        }
        int tx;
        int ty;
        if (this.getCoordinatesX() - x < 0) {
            tx = 1;
        } else {
            tx = -1;
        }
        if (this.getCoordinatesY() - y < 0) {
            ty = 1;
        } else {
            ty = -1;
        }
        int i = getCoordinatesX();
        int j = getCoordinatesY();
        while (i + tx != x) {
            i += tx;
            j += ty;
            if (board.getAt(i, j) != null) {
                return false;
            }

        }

        if (board.getAt(i, j).getColor() == null) {
            return true;
        }

        i += tx;
        j += ty;
        if (board.getAt(i, j).getColor() == this.getColor()) {
            return false;
        } else {
            return true;
        }

    }
}
