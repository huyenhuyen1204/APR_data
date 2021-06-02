public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY,
                  String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int dx = x - getCoordinatesX();
        int unitStepX = dx / Math.abs(dx);
        int tmpX = this.getCoordinatesX();

        int dy = y - getCoordinatesY();
        int unitStepY = dy / Math.abs(dy);
        int tmpY = this.getCoordinatesY();

        if (Math.abs(dx) != Math.abs(dy)) {
            return false;
        }
        do {
            tmpX += unitStepX;
            tmpY += unitStepY;
            if (board.getAt(tmpX, tmpY) != null) {
                return false;
            }
        } while (tmpX != x && tmpY != y);
        return true;
    }
}
