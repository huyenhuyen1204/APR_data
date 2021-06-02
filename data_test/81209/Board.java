import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * iloveyou.
     */
    public Board() {

    }

    /**
     * iloveyou.
     */
    public static boolean validate(int x, int y) {

        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * djhajks.
     */
    public void addPiece(Piece piece) {

        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
            pieces.add(piece);
        }
    }

    /**
     * fashdsfdas.
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
     * fjsadfhadl.
     */
    public void removeAt(int x, int y) {

        for (int i = 0; i < pieces.size(); ++i) {

            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }

    /**
     * jdsfhsad.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * dsfjdad.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
