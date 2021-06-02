import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    /**
     * add.
     *
     * @param piece pi
     */
    public void addPiece(Piece piece) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == piece.getCoordinatesX()
                    && p.getCoordinatesY() == piece.getCoordinatesY()) {
                return;
            }
        }
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * remove pi.
     *
     * @param x x
     * @param y y
     */
    public void removeAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                pieces.remove(piece);
                break;
            }
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * get pi.
     *
     * @param x x
     * @param y y
     * @return pi
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }
}
