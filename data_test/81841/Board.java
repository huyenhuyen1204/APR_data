import java.util.ArrayList;

public class Board {
    public final int WIDTH = 8;
    public final int HEIGHT = 8;
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

    public boolean duplicated(int x, int y) {
        for (Piece p : pieces) {
            if (x == p.getCoordinatesX() && y == p.getCoordinatesY())
                return true;
        }
        return false;
    }

    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && duplicated(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (x == p.getCoordinatesX() && y == p.getCoordinatesY()) {
                return p;
            }
        }
        return null;
    }

    public void remoteAt(int x, int y) {
        pieces.removeIf(p -> x == p.getCoordinatesX() && y == p.getCoordinatesY());
    }
}
