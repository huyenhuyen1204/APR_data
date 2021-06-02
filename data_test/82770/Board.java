import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /** Add piece into the board. */
    public void addPiece(Piece piece) {
        if (!pieces.contains(piece)) {
            pieces.add(piece);
        }
    }

    /** Check validate position. */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /** Remove piece at position (x, y) from the board. */
    public void removeAt(int x, int y) {
        Piece rmPiece = getAt(x, y);
        pieces.remove(rmPiece);
    }

    /** Get piece at position x, y. */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x
                    && piece.getCoordinatesY() == y) {
                return piece;
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
}
