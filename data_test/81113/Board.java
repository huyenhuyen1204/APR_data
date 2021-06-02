import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    /**uyds.*/
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**uyds.*/
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**uyds.*/
    public void addPiece(Piece a) {
        if (validate(a.getCoordinatesX(), a.getCoordinatesY()) && !pieces.contains(a)) {
            pieces.add(a);
        }
    }

    /**uyds.*/
    public boolean validate(int a, int b) {
        if (a >= 1 && a <= 8 && b >= 1 && b <= 8) {
            return true;
        }
        return false;
    }

    /**uyds.*/
    public Piece getAt(int a, int b) {
        for (Piece i : pieces) {
            if (i.getCoordinatesX() == a && i.getCoordinatesY() == b) {
                return i;
            }
        }
        return null;
    }

    /**uyds.*/
    public void removeAt(int a, int b) {
        if (validate(a, b)) {
            pieces.remove(getAt(a, b));
        }
    }
}
