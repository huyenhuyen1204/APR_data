import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
    }

    /**
     * addPiece.
     * @param piece piece
     */
    public void addPiece(Piece piece) {
        if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null
                && validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return 1 <= x && 1 <= y && x <= 8 && y <= 8;
    }

    /**
     * remove piece on board.
     * @param x coordinate x
     * @param y coordinate y
     */

    public void removeAt(int x, int y) {

        pieces.removeIf(p -> x == p.getCoordinatesX() && y == p.getCoordinatesY());

    }

    /**
     * get piece on board.
     * @param x coordinate x
     * @param y coordinate y
     * @return
     */

    public Piece getAt(int x, int y) {

        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }

        return null;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

}
