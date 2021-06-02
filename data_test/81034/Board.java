import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    /**
     * javadoc.
     */
    public boolean validate(int x, int y) {
        return (x >= 1 && y <= 8);
    }

    /**
     * javadoc.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * javadoc.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * javadoc.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            for (Piece p : pieces) {
                if (p.getCoordinatesX() == piece.getCoordinatesX()
                        && p.getCoordinatesY() == piece.getCoordinatesY()) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    /**
     * javadoc.
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * javadoc.
     */
    public void removeAt(int x, int y) {
        pieces.remove(getAt(x, y));
    }
}
