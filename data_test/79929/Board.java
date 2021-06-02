import java.util.ArrayList;

/**
 * Created by CCNE on 19/11/2020.
 */
public class Board {
    public static final int WIDTH = 8;
    public static final int HIEGHT = 8;
    private ArrayList<Piece> pieces;

    /**
     * Loan .
     */
    public Board() {
    }

    /**
     * Loan .
     */
    public void addPiece(Piece piece) {
        boolean kt = true;
        kt = validate(piece.getX(), piece.getY());
        for (int i = 0; i < pieces.size(); i++) {
            Piece temp = pieces.get(i);
            if (temp.getX() == piece.getX() && temp.getY() == piece.getY()) {
                kt = false;
                break;
            }
        }
        if (kt) pieces.add(piece);
    }

    /**
     * Loan .
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * Loan .
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece temp = pieces.get(i);
            if (temp.getX() == x && temp.getY() == y) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Loan .
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece temp = pieces.get(i);
            if (temp.getX() == x && temp.getY() == y) {
                pieces.remove(i);
            }
        }
    }

    /**
     * Loan .
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Loan .
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
