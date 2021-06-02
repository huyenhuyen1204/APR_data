import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y) || (x != super.getCoordinatesX() && y != super.getCoordinatesY())) {
            return false;
        }

        if (x == super.getCoordinatesX()) {
            if (y > super.getCoordinatesY()) {
                for (int i = super.getCoordinatesY() + 1; i < y; ++i) {
                    if (board.getAt(super.getCoordinatesX(), i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = super.getCoordinatesY() - 1; i > y; --i) {
                    if (board.getAt(super.getCoordinatesX(), i) != null) {
                        return false;
                    }
                }
            }
        } else {
            if (x < super.getCoordinatesX()) {
                for (int i = super.getCoordinatesY() - 1; i > y; --i) {
                    if (board.getAt(i, super.getCoordinatesY()) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = super.getCoordinatesX() + 1; i < x; ++i) {
                    if (board.getAt(i, super.getCoordinatesY()) != null) {
                        return false;
                    }
                }
            }
        }
        if (board.getAt(x, y) != null && board.getAt(x, y).getColor().equals(this.getColor())) {
            return false;
        }
        return true;
    }
} 