import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {

    }

    /**hu hu.*/
    public void addPiece(Piece pNew) {
        boolean kt = true;
        for (Piece p : pieces) {
            if ((p.getX() == pNew.getX()) && (p.getY() == pNew.getY())) {
                kt = false;
            }
        }
        if (kt && validate(pNew.getX(), pNew.getY())) {
            pieces.add(pNew);
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
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                pieces.remove(p);
            }
        }
    }

    /**hu hu.*/
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
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
