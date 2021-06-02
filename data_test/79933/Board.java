import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    /** binhdang. */
    public Board() {

    }

    /** binhdang. */
    public void addPiece(Piece piece) {
        int tempX = piece.getX();
        int tempY = piece.getY();
        if (validate(tempX, tempY) && getAt(tempX, tempY) == null) {
            pieces.add(piece);
        }
    }

    /** binhdang. */
    public boolean validate(int x, int y) {
        return x >= 0 && x <= 8 && y >= 0 && y <= 8;
    }

    /** binhdang. */
    public void removeAt(int x, int y) {
        if (getAt(x, y) != null) {
            pieces.remove(getAt(x, y));
        }
    }

    /** binhdang. */
    public Piece getAt(int x, int y) {
        for (Piece temp : pieces) {
            if (temp.getX() == x && temp.getY() == y) {
                return temp;
            }
        }
        return null;
    }

    /** binhdang. */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /** binhdang. */
    public void setPieces(ArrayList<Piece> temp) {
        pieces = temp;
    }
}
