import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    /**
     * Constructor.
     */
    public Board() {
    }

    /**
     * Add piece to list.
     */
    public void addPiece(Piece piece) {
        int count = 0;
        if (pieces.isEmpty()) {
            pieces.add(piece);
        } else {
            for (int i = 0; i < getPieces().size(); i++) {
                if (compareTo(pieces.get(i), piece)) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == getPieces().size()) {
                pieces.add(piece);
            }
        }
    }

    /**
     * Compare 2 piece.
     */
    public boolean compareTo(Piece piece1, Piece piece2) {
        if (piece1.getCoordinatesX() == piece2.getCoordinatesX()
        && piece1.getCoordinatesY() == piece2.getCoordinatesY()
        && piece1.getColor().equals(piece2.getColor())) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Validate.
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
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
