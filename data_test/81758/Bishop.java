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
        boolean check = true;
        if (Math.abs(x - this.getCoordinatesX())
                != Math.abs(y - this.getCoordinatesY())) {
            check = false;
        } else {
            for (int i = 1; i <= Math.abs(x - this.getCoordinatesX()); i++) {
                if (board.getAt(this.getCoordinatesX() + i, this.getCoordinatesY() + i) != null) {
                    if (i == Math.abs(x - this.getCoordinatesX())) {
                        if ((board.getAt(this.getCoordinatesX() + i,
                                this.getCoordinatesY() + i).getColor().equals(this.getColor()))) {
                            check = false;
                        }
                    } else {
                        check = false;
                        break;
                    }
                }
            }
        }
        return check;
    }


}
