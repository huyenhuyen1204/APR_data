import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public void addPiece(Piece newPiece) {
        if (!validate(newPiece.getCoordinatesX(), newPiece.getCoordinatesY())) {
            return;
        }
        if (getAt(newPiece.getCoordinatesX(), newPiece.getCoordinatesY()) != null) {
            return;
        }
        pieces.add(newPiece);
    }

    public boolean validate(int x, int y) {
        return y >= 1 && y <= 8 && x >= 1 && x <= 8;
    }

    public Piece getAt(int x, int y) {
        if (pieces.isEmpty()) {
            return null;
        }

        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        Piece piece = this.getAt(x, y);
        if (piece != null) {
            this.pieces.remove(piece);
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
