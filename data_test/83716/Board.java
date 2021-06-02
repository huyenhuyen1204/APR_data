import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /** abc. */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y <= 8 && y >= 1) {
            return true;
        }
        return false;
    }

    /** abc. */
    public boolean is_same(int x, int y) {
        for (int i = 0; i < pieces.size(); ++i) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                return true;
            }
        }
        return false;
    }

    /** abc. */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            if (!is_same(piece.getCoordinatesX(), piece.getCoordinatesY())) {
                pieces.add(piece);
            }
        }
    }

    /** abc. */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); ++i) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                return pieces.get(i);
            }
        }
        return null;
    }

    /** abc. */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); ++i) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                pieces.remove(pieces.get(i));
            }
        }
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

}
 