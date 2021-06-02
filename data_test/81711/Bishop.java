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
        //Chua xu ly tren duong gap quan co khac thi khong duoc di chuyen
        if (getCoordinatesX() - x == getCoordinatesY() - y || getCoordinatesX() - x == y - getCoordinatesY()) {
            return true;
        }

        return false;
    }
}
