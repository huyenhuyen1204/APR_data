import java.util.Random;

public class Rook extends Piece {
    @Override
    public String getSymbol() {
        return "R";
    }

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        if (board.getAt(x, y) != null && board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }

        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }

        if (x == this.getCoordinatesX()) {
            for (int i = Math.min(y, this.getCoordinatesY()) + 1; i < Math.max(y, this.getCoordinatesY()); i++) {
                if (board.getAt(x, i) != null) return false;
            }
        }

        if (y == this.getCoordinatesY()) {
            for (int i = Math.min(x, this.getCoordinatesX()) + 1; i < Math.max(x, this.getCoordinatesX()); i++) {
                if (board.getAt(i, y) != null) return false;
            }
        }
        return true;
    }
}
