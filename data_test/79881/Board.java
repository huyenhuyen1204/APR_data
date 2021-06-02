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

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(i -> i.getX() == x && i.getY() == y);
    }

    public Piece getAt(int x, int y) {
        for (Piece i : pieces) {
            if (i.getX() == x && i.getY() == y) {
                return i;
            }
        }
        return null;
    }
}