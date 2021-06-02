import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    /**
     * ham.
     * @param x ham.
     * @param y ham.
     * @return ham.
     */
    public boolean validate(int x, int y) {
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * ham.
     * @param piece ham.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY()) && !pieces.contains(piece)) {
              pieces.add(piece);
        }
    }

    /**
     * ham.
     * @param x ham.
     * @param y ham.
     * @return ham.
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
     * ham.
     * @param x ham.
     * @param y ham.
     */
    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y));
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
