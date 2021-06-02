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
            if (board.getAt(x, y) != null) {
                Piece i = board.getAt(x, y);
                if (i.getColor().equals(this.getColor())) {
                    check = false;
                }
            }
        }
        return check;
    }


}
