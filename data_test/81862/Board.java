import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    Board() {
        pieces = new ArrayList<>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean validate(int x, int y) {
        return x >= 1 && y <= 8;
    }

    /**
     * check if there is a duplicated piece in the x,y position.
     * @param x x axis of piece
     * @param y y axis of piece
     * @return if the piece is in the list or not
     */
    public boolean duplicated(int x, int y) {
        for (Piece p : pieces) {
            if (x == p.getCoordinatesX() && y == p.getCoordinatesY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * add a new piece to the list.
     * @param piece new piece
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && duplicated(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    /**
     * get the piece at position x,y.
     * @param x x axis of the piece
     * @param y y axis of the piece
     * @return the piece with the coordinate of (x,y)
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
     * remove a piece with the coordinate of (x,y)
     * @param x x axis of the piece
     * @param y y axis of the piece
     */
    public void removeAt(int x, int y) {
        pieces.removeIf(p -> x == p.getCoordinatesX() && y == p.getCoordinatesY());
    }
}
