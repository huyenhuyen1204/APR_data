import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

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
        if (validate(piece.getX(), piece.getY())) {
            for (Piece p : pieces) {
                if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
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
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * javadoc.
     */
    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        if (piece != null) {
            pieces.remove(piece);
        }
    }
}
