import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Constructor.
     */
    public Board() {
    }

    /**
     * Add piece to list.
     */
    public void addPiece(Piece piece) {
        for (int i = 0; i < pieces.size(); i++) {
            if (piece.getCoordinatesX() != pieces.get(i).getCoordinatesX()
            || piece.getCoordinatesY() != pieces.get(i).getCoordinatesY()) {
                pieces.add(piece);
            }
        }
    }

    /**
     * Validate.
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && y <= 8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove piece at point.
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
            && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }

    /**
     * get piece at point.
     */
    public Piece getAt(int x, int y) {
        Piece result = null;
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                result = pieces.get(i);
            }
        }
        return result;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
