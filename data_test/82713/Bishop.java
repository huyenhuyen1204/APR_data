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
    public boolean canMove(Board board, int desX, int desY) {
        if (!board.validate(desX, desY)
                || (Math.abs(this.getCoordinatesX() - desX) != Math.abs(this.getCoordinatesY() - desY))) {
            return false;
        }
        if (this.getCoordinatesX() == desX && this.getCoordinatesY() == desY) {
            return false;
        }
        int checkX = 0;
        int checkY = 0;
        if (desX > this.getCoordinatesX()) {
            checkX = 1;
        } else {
            checkX = -1;
        }
        if (desY > this.getCoordinatesY()) {
            checkY = 1;
        } else {
            checkX = -1;
        }
        int y = this.getCoordinatesY() + checkY;
        for (int x = this.getCoordinatesX() + checkX; x != desX; x += checkX) {
            if (board.getAt(x, y) != null) {
                return false;
            }
            y += checkY;
        }
        if (board.getAt(desX, desY) == null) {
            return true;
        } else {
            return !board.getAt(desX, desY).getColor().equals(this.getColor());
        }
    }
}
