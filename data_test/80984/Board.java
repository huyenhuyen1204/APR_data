import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<Piece>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /** Add a new piece to the board. **/
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            for (Piece p : pieces) {
                if (p.getCoordinatesX() == piece.getCoordinatesX()
                        && p.getCoordinatesY() == piece.getCoordinatesY()) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(i -> i.getCoordinatesX() == x && i.getCoordinatesY() == y);
    }

    /** Move piece to (x, y) axis. **/
    public void movePiece(Piece piece, int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == piece.getCoordinatesX()
                    && p.getCoordinatesY() == piece.getCoordinatesY()) {
                p.setCoordinatesX(x);
                p.setCoordinatesY(y);
            }
        }
    }

    /** Return the piece at (x, y) axis. **/
    public Piece getAt(int x, int y) {
        for (Piece i : pieces) {
            if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                return i;
            }
        }
        return null;
    }
}