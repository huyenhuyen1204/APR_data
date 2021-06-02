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
        int tmpX = this.getCoordinatesX() + unitStepX;

        int dy = y - getCoordinatesY();
        int unitStepY = dy / Math.abs(dy);
        int tmpY = this.getCoordinatesY() + unitStepY;

        if (dx == 0 && dy == 0) return true;
        if (Math.abs(dx) != Math.abs(dy)) {
            return false;
        }
        while (tmpX != x && tmpY != y){
            if (board.getAt(tmpX, tmpY) != null) {
                return false;
            }
            tmpX += unitStepX;
            tmpY += unitStepY;
        }
        return true;
    }
}
