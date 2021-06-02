
import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>();
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * check validate.
     */
    public boolean validate(int x, int y) {
        if (x < 1 || y < 1 || x > 8 || y > 8) {
            return false;
        }
        return true;
    }

    /**
     * add Piece.
     */
    public void addPiece(Piece piece) {
        if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        }
        for (Piece piece1 : pieces) {
            if (piece1.getCoordinatesX() == piece.getCoordinatesX()
                    && piece1.getCoordinatesY() == piece.getCoordinatesY()) {
                return;
            }
        }
        pieces.add(piece);
    }

    /**
     * get piece at x, y.
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (x == piece.getCoordinatesX() && y == piece.getCoordinatesY()) {
                return piece;
            }
        }
        return null;
    }

    /**
     * remove at x, y.
     */
    public void removeAt(int x, int y) {
        for (Piece piece : pieces) {
            if (x == piece.getCoordinatesX() && y == piece.getCoordinatesY()) {
                pieces.remove(piece);
                return;
            }
        }
    }
}
