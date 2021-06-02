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
    public boolean canMove(Board board, int thisX, int thisY) {
        int cuteX = this.getCoordinatesX();
        int cuteY = this.getCoordinatesY();

        if (board == null) {
            return true;
        }

        if ((cuteX != thisX && cuteY != thisY)
                || 1 >= thisX || 8 <= thisX || 1 >= thisY || 8 <= thisY) {
            return false;
        }

        if (cuteX == thisX) {
            if (thisY < cuteY) {
                while (cuteY != thisY){
                    if (board.getAt(cuteX, cuteY) != null) {
                        return false;
                    }
                    cuteY--;
                }
                return !board.getAt(cuteX, cuteY).getColor().equals(this.getColor());
            } else {
                while (cuteY != thisY){
                    if (board.getAt(cuteX, cuteY) != null) {
                        return false;
                    }
                    cuteY++;
                }
                return !board.getAt(cuteX, cuteY).getColor().equals(this.getColor());
            }
        } else {
            if (thisX < cuteX) {
                while (cuteX != thisX){
                    if (board.getAt(cuteX, cuteY) != null) {
                        return false;
                    }
                    cuteX--;
                }
                return !board.getAt(cuteX, cuteY).getColor().equals(this.getColor());
            } else {
                while (cuteX != thisX){
                    if (board.getAt(cuteX, cuteY) != null) {
                        return false;
                    }
                    cuteX++;
                }
                return board.getAt(cuteX, cuteY).getColor().equals(this.getColor());
            }
        }
    }
}
