import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {

    }

    /**hu hu.*/
    public void addPiece(Piece n) {
        boolean kt = true;
        for (Piece p : pieces) {
            if ((p.getCoordinatesX() == n.getCoordinatesX()) && (p.getCoordinatesY() == n.getCoordinatesY())) {
                kt = false;
            }
        }
        if (kt && validate(n.getCoordinatesX(), n.getCoordinatesY())) {
            pieces.add(n);
        }

    }

    /**hu hu.*/
    public boolean validate(int x, int y) {
        if (x > 8 || x < 1) {
            return false;
        }
        if (y > 8 || y < 1) {
            return false;
        }
        return true;
    }

    /**hu hu.*/
    public void removeAt(int x, int y) {
        if (this.getAt(x, y) != null) {
            pieces.remove(this.getAt(x, y));
        }
    }

    /**hu hu.*/
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    /**hu hu.*/
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**hu hu.*/
    public void setPieces(ArrayList<Piece> ps) {
        this.pieces = ps;
    }

}
