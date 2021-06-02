import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Kiem tra vi tri quan co.
     * @param x x.
     * @param y y.
     * @return tra ve dung neu vi tri cho phep.
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * them quan co vao ban co.
     * @param piece quan co.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            if (!pieces.contains(piece)) {
                pieces.add(piece);
            }
        }
    }

    /**
     * lay quan co.
     * @param x vi tri x.
     * @param y vi tri y.
     * @return tra ve quan co lay duoc.
     */
    public Piece getAt(int x, int y) {
        for (Piece i : pieces) {
            if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                return i;
            }
        }
        return null;
    }

    /**
     * xoa quan co.
     * @param x vi tri x.
     * @param y vi tri y.
     */
    public void removeAt(int x, int y) {
        Piece i = getAt(x, y);
        if (i != null) {
            pieces.remove(i);
        }
    }
}
