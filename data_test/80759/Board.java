import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     *  .
     */
    public Board() {

    }

    /**
     *  .
     * @param newPiece .
     */
    public void addPiece(Piece newPiece) {
        if (validate(newPiece.getCoordinatesX(), newPiece.getCoordinatesY())
                && getAt(newPiece.getCoordinatesX(), newPiece.getCoordinatesY()) == null) {
            pieces.add(newPiece);
        }
    }

    /**
     *  .
     * @param x .
     * @param y .
     * @return .
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     *  .
     * @param x .
     * @param y .
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }

    /**
     *  .
     * @return .
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     *  .
     * @param pieces .
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     *  .
     * @param x .
     * @param y .
     * @return .
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }
}
