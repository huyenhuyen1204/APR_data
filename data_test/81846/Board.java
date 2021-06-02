import java.util.ArrayList;

public class Board {
    public final static int WIDTH = 8;
    public final static int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
    }

    public void addPiece(Piece piece) {
        if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null &&
                validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return 1 <= x && 1 <= y && x <= 8 && y <= 8;
    }

    public void removeAt(int x, int y) {

        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                pieces.remove(piece);
            }
        }

    }

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
