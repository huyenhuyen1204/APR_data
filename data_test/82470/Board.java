import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Javadoc Comment.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Javadoc Comment.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Javadoc Comment.
     */
    public boolean validate(int x, int y) {
        return (1 <= x && x <= 8 && 1 <= y && y <= 8);
    }

    /**
     * Javadoc Comment.
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();
        if (validate(x, y)) {
            for (Piece p : pieces) {
                if (x == p.getCoordinatesX() && y == p.getCoordinatesY()) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    /**
     * Javadoc Comment.
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (x == p.getCoordinatesX() && y == p.getCoordinatesY()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Javadoc Comment.
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getCoordinatesX()
                    && y == pieces.get(i).getCoordinatesY()) {
                pieces.remove(pieces.get(i));
            }
        }
    }
}
