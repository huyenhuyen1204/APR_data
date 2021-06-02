import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Check vi tri.
     * @param x toa do tai x.
     * @param y toa do tai y.
     * @return check.
     */
    public boolean validate(int x, int y) {
        boolean check = false;
        if (x >= 1 && x <= 8) {
            if (y >= 1 && y <= 8) {
                check = true;
            }
        }
        return check;
    }

    /**
     * Thêm cbdj.
     * @param piece quan.
     */
    public void addPiece(Piece piece) {
        if (!pieces.contains(piece)) {
            pieces.add(piece);
        }
    }

    /**
     * lay piece tai x,y.
     * @param x toa do x.
     * @param y toa do y.
     * @return piece.
     */
    public Piece getAt(int x, int y) {
        Piece piece = null;
        for (Piece i : pieces) {
            if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                piece = i;
            }
        }
        return piece;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(i -> i.getCoordinatesX() == x && i.getCoordinatesY() == y);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

}
