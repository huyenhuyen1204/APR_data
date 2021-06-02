import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**2.*/
    public boolean validate(int x, int y) {
        if ((x >= 1 && x <= 8) && (y >= 1 && y <= 8)) {
            return true;
        } else {
            return false;
        }
    }

    /**2.*/
    public void addPiece(Piece piece) {
        if (validate(piece.getX(), piece.getY())) {
            boolean check = true;
            for (Piece piece1 : pieces) {
                if (piece1.getX() == piece.getX()
                        && piece1.getY() == piece.getY()) {
                    check = false;
                    break;
                }
            }
            if (check) {
                pieces.add(piece);
            }
        }
    }

    /**2.*/
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getX() == x && piece.getY() == y) {
                return piece;
            }
        }
        return null;
    }

    /**2.*/
    public void removeAt(int x, int y) {
        if (validate(x, y)) {
            pieces.remove(getAt(x, y));
        }
    }

    /**2.*/
    public ArrayList<Piece> getPieces() {
        return new ArrayList<Piece>(pieces);
    }

    /**2.*/
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = new ArrayList<>(pieces);
    }
}
