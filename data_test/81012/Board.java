import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * cmt.
     */
    public List<Piece> getPieces() {
        return pieces;
    }

    /**
     * cmt.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * cmt.
     */
    public boolean validate(int x, int y) {
        return (x >= 1 && y <= 8) ? true : false;
    }

    /**
     * cmt.
     */
    public void addPiece(Piece p) {
        if (validate(p.getCoordinatesX(), p.getCoordinatesY())) {
            for (Piece pie : pieces) {
                if (pie.getCoordinatesX() == p.getCoordinatesX()
                        && pie.getCoordinatesY() == p.getCoordinatesY()) {
                    return;
                }
            }
            pieces.add(p);
        }
    }

    /**
     * cmt.
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
     * cmt.
     */
    public void removeAt(int x, int y) {
        int length = pieces.size();
        for (int i = 0; i < length; i++) {
            if (pieces.get(i).getCoordinatesY() == y && pieces.get(i).getCoordinatesX() == x) {
                pieces.remove(i);
                return;
            }
        }
    }
}
