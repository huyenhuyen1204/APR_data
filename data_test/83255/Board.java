import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board(){}

    /**
     * validate.
     * @param x x
     * @param y y
     * @return va
     */
    public boolean validate(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * add.
     * @param piece piece
     */
    public void addPiece(Piece piece) {
        for (Piece i : pieces) {
            if (piece.getCoordinatesX() == i.getCoordinatesX() &&
                    piece.getCoordinatesY() == i.getCoordinatesY()) {
                return;
            }
        }
        pieces.add(piece);
    }

    /**
     * remove.
     * @param x x
     * @param y y
     */
    public void removeAt(int x, int y) {
        if (pieces.isEmpty()) {
            return;
        }
        Piece piece = getAt(x,y);
        if (piece != null) {
            pieces.remove(piece);
        }
    }

    /**
     * get at.
     * @param x x
     * @param y y
     * @return at
     */
    public Piece getAt(int x, int y){
        if (!pieces.isEmpty()) {
            for (Piece i : pieces) {
                if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                    return i;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}