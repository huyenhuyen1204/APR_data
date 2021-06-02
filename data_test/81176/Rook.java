public class Rook extends Piece {
    /**
     * Hello, this is me ure looking for.
     */
    public Rook(int thisX, int thisY) {
        super(thisX, thisY);
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Rook(int thisX, int thisY, String str) {
        super(thisX, thisY, str);
    }

    /**
     * Hello, this is me ure looking for.
     */
    public String getSymbol() {
        return "R";
    }

    /**
     * Hello, this is me ure looking for.
     */
    public boolean canMove(Board board, int destX, int destY) {
        int thisX = this.getCoordinatesX();
        int thisY = this.getCoordinatesY();

        if (1 > destX || 8 < destX || 1 > destY || 8 < destY
                || (thisX != destX && thisY != destY)) {
            return false;
        }

        if (board.getAt(destX, destY) != null
                && board.getAt(destX, destY).getColor().equals(this.getColor())) {
            return false;
        }

        if (thisX == destX) {
            if (destY < thisY) {
                thisY--;
                while (thisY != destY) {
                    if (board.getAt(thisX, thisY) != null) {
                        return false;
                    }
                    thisY--;
                }
            } else if (destY > thisY) {
                thisY++;
                while (thisY != destY) {
                    if (board.getAt(thisX, thisY) != null) {
                        return false;
                    }
                    thisY++;
                }
            }
        } else {
            if (destX < thisX) {
                thisX--;
                while (thisX != destX) {
                    if (board.getAt(thisX, thisY) != null) {
                        return false;
                    }
                    thisX--;
                }
            } else if (destX > thisX) {
                thisX++;
                while (thisX != destX) {
                    if (board.getAt(thisX, thisY) != null) {
                        return false;
                    }
                    thisX++;
                }
            }
        }
        return true;
    }
}
