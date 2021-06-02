import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    /**
     * Constructor.
     */
    public Board() {
        pieces = new ArrayList<>();
    }

    /**
     * ...
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT) {
            return true;
        }
        return false;
    }

    /**
     * ...
     */
    public void addPiece(Piece piece) {
        for (Piece temp : pieces) {
            if (piece.getCoordinatesX() == temp.getCoordinatesX()
                && piece.getCoordinatesY() == temp.getCoordinatesY()) {
                return;
            }
        }

        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    /**
     * ...
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                return;
            }
        }
    }

    /**
     * ...
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x
                    && piece.getCoordinatesY() == y) {
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
