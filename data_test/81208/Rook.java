public class Rook extends Piece {

    /**
     * fhsagdkas.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * asjhdfa.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * fshadk.
     */

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {

        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        int minpos = 1;
        int maxpos = 8;
        if (this.getCoordinatesX() == x) {

            for (Piece i : board.getPieces()) {
                if (i.getCoordinatesX() != x) {
                    continue;
                }
                if (i.getCoordinatesY() <= this.getCoordinatesY()) {
                    minpos = Math.max(minpos, i.getCoordinatesY());
                } else {
                    maxpos = Math.min(maxpos, i.getCoordinatesY());
                }
            }
            boolean posmin = false;
            boolean posmax = false;
            if (y < minpos || y > maxpos) {
                return false;
            }
            for (Piece i : board.getPieces()) {
                if (i.getCoordinatesX() != x) {
                    continue;
                }
                if (i.getCoordinatesY() == minpos
                        && !i.getColor().equals(this.getColor())) {
                    return true;
                }
                if (i.getCoordinatesY() == maxpos
                        && !i.getColor().equals(this.getColor())) {
                    return true;
                }
                if (i.getCoordinatesY() == minpos) {
                    posmin = true;
                }
                if (i.getCoordinatesY() == maxpos) {
                    posmax = true;
                }
            }
            if (minpos < y && y < maxpos) {
                return true;
            }
            if (!posmin && y == minpos) {
                return true;
            }
            if (!posmax && y == maxpos) {
                return true;
            }
            return false;
        }
        for (Piece i : board.getPieces()) {
            if (i.getCoordinatesY() != y) {
                continue;
            }
            if (i.getCoordinatesX() <= this.getCoordinatesX()) {
                minpos = Math.max(minpos, i.getCoordinatesX());
            } else {
                maxpos = Math.min(maxpos, i.getCoordinatesX());
            }
        }
        boolean posmin = false;
        boolean posmax = false;
        if (x < minpos || x > maxpos) {
            return false;
        }
        for (Piece i : board.getPieces()) {
            if (i.getCoordinatesY() != y) {
                continue;
            }
            if (i.getCoordinatesX() == minpos
                    && !i.getColor().equals(this.getColor())) {
                return true;
            }
            if (i.getCoordinatesX() == maxpos
                    && !i.getColor().equals(this.getColor())) {
                return true;
            }
            if (i.getCoordinatesX() == minpos) {
                posmin = true;
            }
            if (i.getCoordinatesX() == maxpos) {
                posmax = true;
            }
        }
        if (minpos < x && x < maxpos) {
            return true;
        }
        if (!posmin && x == minpos) {
            return true;
        }
        if (!posmax && x == maxpos) {
            return true;
        }
        return false;
    }
}
