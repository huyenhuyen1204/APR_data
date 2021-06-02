/**
 * Created by CCNE on 19/11/2020.
 */
public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public String getSymbol() {
        return "R";
    }

    public boolean canMove(Board board, int x, int y) {
        for (int i = x; i < 8; i++) {
            if (board.getAt(i + 1, y) != null) {
                if (board.getAt(i + 1, y).getColor() != board.getAt(x, y).getColor()) {
                    return true;
                } else
                    return false;
            }
            return true;
        }

        for (int i = 0; i < x; i++) {
            if (board.getAt(i, y) != null) {
                if (board.getAt(i, y).getColor() != board.getAt(x, y).getColor()) {
                    return true;
                } else
                    return false;
            }
            return true;
        }

        for (int i = y; i < 8; i++) {
            if (board.getAt(x, i + 1) != null) {
                if (board.getAt(x, i + 1).getColor() != board.getAt(x, y).getColor()) {
                    return true;
                } else
                    return false;
            }
            return true;
        }

        for (int i = 0; i < y; i++) {
            if (board.getAt(x, i) != null) {
                if (board.getAt(x, 0).getColor() != board.getAt(x, y).getColor()) {
                    return true;
                } else
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPosition(Piece piece) {
        return false;
    }
}
