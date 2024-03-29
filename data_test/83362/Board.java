import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {}

    /**addPiece.*/
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY()) && !pieces.contains(piece)) {
            pieces.add(piece);
        }
    }

    /**kt toa do.*/
    public boolean validate(int x, int y) {
        if (x >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    /**removeAt.*/
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                pieces.remove(i);
            }
        }
    }

    /**getAt.*/
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
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
