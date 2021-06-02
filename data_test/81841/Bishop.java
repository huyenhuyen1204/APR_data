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
        return true;
    }
}
