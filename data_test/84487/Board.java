import java.util.ArrayList;

public class Board {
    public final int WIDTH = 8;
    public final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    /**
     * add piece.
     */
    public void addPiece(Piece piece) {
        if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null
            && validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    /** position validation.
     */
    public boolean validate(int x, int y) {
        return (x > 0 && x < 9 && y > 0 && y < 9);
    }

    /** get piece at (x;y).
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }

        return null;
    }

    /** remove piece at (x;y).
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}