import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public boolean validate(int x, int y) {
        if (x < 1 || y < 1 || x > 8 || y > 8) {
            return false;
        }
        return true;
    }

    public void addPiece(Piece piece) {
        for (Piece a : pieces) {
            if (a.getCoordinatesX() == piece.getCoordinatesX()
                    && a.getCoordinatesY() == piece.getCoordinatesX()) {
                return;
            }
        }
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    public Piece getAt(int x, int y) {
        for (Piece a : pieces) {
            if (a.getCoordinatesX() == x && a.getCoordinatesY() == y) {
                return a;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                return;
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
