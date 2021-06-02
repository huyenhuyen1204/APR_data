import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * validate.
     * @return boolean
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * addPiece.
     */
    public void addPiece(Piece piece) {
        int xa = piece.getCoordinatesX();
        int ya = piece.getCoordinatesY();
        if (validate(xa, ya) && getAt(xa, ya) == null) {
            pieces.add(piece);
        }
    }

    /**
     * getAt.
     * @return Piece at (x, y)
     */
    public Piece getAt(int x, int y) {
        int n = pieces.size();
        for (int i = 0; i < n; i++) {
            int xa = pieces.get(i).getCoordinatesX();
            int ya = pieces.get(i).getCoordinatesY();
            if (xa == x && ya == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    /**
     * removeAt.
     */
    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        pieces.remove(piece);
    }

    /**
     * getPieces.
     * @return ArrayList
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * setPieces.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
