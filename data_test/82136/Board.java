import java.util.ArrayList;

public class Board {
    private static final int WIDTH = 8;
    private static final int HIEGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public boolean validate(int x, int y) {
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            return true;
        }
        return false;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> (piece.getCoordinatesY() == y && piece.getCoordinatesX() == x));
//        for (Piece p : pieces) {
//            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
//                pieces.remove(p);
//            }
//        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
