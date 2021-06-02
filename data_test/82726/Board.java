import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    /**
     * ham them quan co vao ban co.
     *
     * @param p la tham so.
     */
    public void addPiece(Piece p) {
        if (validate(p.getCoordinatesX(), p.getCoordinatesY())
                && this.getAt(p.getCoordinatesX(), p.getCoordinatesY()) == null) {
            pieces.add(p);
        }
    }

    /**
     * kiem tra toa do.
     * @param x .
     * @param y .
     * @return .
     */
    public boolean validate(int x, int y) {
        return (x >= 1 && x <= 8
                && y >= 1 && y <= 8);
    }

    /**
     * xoa quan co.
     * @param x .
     * @param y .
     */
    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        if (!pieces.isEmpty() && piece != null) {
            pieces.remove(piece);
        }
    }

    /**
     * lay quan co.
     * @param x .
     * @param y .
     * @return .
     */
    public Piece getAt(int x, int y) {
        Iterator<Piece> itr = pieces.iterator();
        Piece curP;
        Piece piece = null;
        while (itr.hasNext()) {
            curP = itr.next();
            if (curP.getCoordinatesX() == x
                    && curP.getCoordinatesY() == y) {
                piece = curP;
            }
        }
        return piece;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
