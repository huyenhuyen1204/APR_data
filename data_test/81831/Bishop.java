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
        if (getCoordinatesX() - x == getCoordinatesY() - y
                || getCoordinatesX() - x == y - getCoordinatesY()) {
            int stepX = -1;
            int stepY = -1;
            int distance = getCoordinatesX() - x;
            if (getCoordinatesX() < x) {
                stepX = 1;
                distance *= -1;
            }
            if (getCoordinatesY() < y) {
                stepY = 1;
            }

            for (int i = 1; i < distance; i++) {
                for (int e = 0; e < board.getPieces().size(); e++) {
                    if (board.getPieces().get(e).getCoordinatesX() == getCoordinatesX() + stepX * i
                    && board.getPieces().get(e).getCoordinatesY()
                            == getCoordinatesY() + stepY * i) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }
}
