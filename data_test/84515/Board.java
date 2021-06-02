import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {

    }

    /**
     * to add pieces.
     * @param piece  dfs
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && (locationPlaced(piece.getCoordinatesX(), piece.getCoordinatesY()))) {
            pieces.add(piece);
        }
    }

    /**
     *  to check valid place in board.
     * @param x fd
     * @param y df
     * @return df
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && y >= 1 && x <= 8 && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * remove chess at x, y.
     * @param x df
     * @param y df
     */
    public void removeAt(int x, int y) {
        pieces.remove(getAt(x, y));
    }

    /**
     * sd.
     * @param x sd
     * @param y sd
     * @return piece at x, y.
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

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Tra ve false neu o co do da co quan co khac.
     * @param x qưe
     * @param y qưe
     * @return qưe
     */
    public boolean locationPlaced(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return false;
            }
        }
        return true;
    }


}
