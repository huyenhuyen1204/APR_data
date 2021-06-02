public class Rook extends Piece {
    /**
     * Javadoc Comment.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Javadoc Comment.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Javadoc Comment.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Javadoc Comment.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int pos = -1;
        for (int i = 0; i < board.getPieces().size(); i++) {
            if (board.getPieces().get(i).equals(this)) {
                pos = i;
                break;
            }
        }

        for (int i = 0; i < board.getPieces().size(); i++) {
            if (i != pos) {
                if (x == board.getPieces().get(i).getCoordinatesX()
                        || y == board.getPieces().get(i).getCoordinatesY()) {
                    if (!board.getPieces().get(i).getColor().equals(this.getColor())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
