import java.util.ArrayList;

/**
 * .
 * @author Nguyen Quyet Thang .
 */
public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * .
     */
    public Board() {

    }

    /**
     * .
     * @param piece .
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
            && getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
            pieces.add(piece);
        }
    }

    /**
     * .
     * @param x .
     * @param y .
     * @return .
     */
    public boolean validate(int x, int y) {
        return (x >= 1 && x <= 8) && (y >= 1 && y <= 8);
    }

    /**
     * .
     * @param x .
     * @param y .
     * @return .
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : this.pieces) {
            if (piece.getCoordinatesX() == x
                    && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    /**
     * .
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
     * .
     * @return .
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * .
     * @param pieces .
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
