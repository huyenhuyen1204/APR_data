import java.util.ArrayList;

public class Board {
    protected final int WIDTH = 8;
    protected final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {
    }

    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) return false;
        return true;
    }

    public void removeAt(int x, int y) {
        for (int i = pieces.size() - 1; i >= 0; i--) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                pieces.remove(i);
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = pieces.size() - 1; i >= 0; i--) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                return pieces.get(i);
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
