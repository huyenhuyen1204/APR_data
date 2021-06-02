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
        int dx = 0, dy = 0;
        int ox = this.getCoordinatesX();
        int oy = this.getCoordinatesY();
        if (Math.abs(x - this.getCoordinatesX())
                != Math.abs(y - this.getCoordinatesY())) {
            check = false;
        } else {
            if(x > this.getCoordinatesX() && y > this.getCoordinatesY()) {
                dx = 1;
                dy = 1;
            } else if (x < this.getCoordinatesX() && y > this.getCoordinatesY()) {
                dx = -1;
                dy = 1;
            } else if (x < this.getCoordinatesX() && y < this.getCoordinatesY()) {
                dx = -1;
                dy = -1;
            } else {
                dx = 1;
                dy = -1;
            }

            while (ox != x) {
                ox += dx;
                oy += dy;
                if (board.getAt(ox, oy) != null) {
                    check = false;
                    break;
                }
            }
            if (ox == x) {
                if (board.getAt(ox, oy) != null) {
                    if (board.getAt(ox, oy).getColor().equals(this.getColor())) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }


}
