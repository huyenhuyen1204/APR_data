import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8, HEIGHT = 8;
    private static ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public void addPiece(Piece piece) {
        if (validate(piece.getX(), piece.getY()) && getAt(piece.getX(),piece.getY()) == null) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return x <= WIDTH && x >= 1
                && y <= HEIGHT && y >= 1;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> piece.getX() == x && piece.getY() == y);
    }

    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getX() == x && piece.getY() == y) {
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
