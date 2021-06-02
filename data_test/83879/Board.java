import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public boolean validate(int x, int y) {
        if ((x > 1 && x < 8) && (y > 1 && y < 8)) {
            return true;
        }
        return false;
    }

    public void addPiece(Piece piece) {
        int count = 0;
        for (int i = 0; i < pieces.size(); i++) {
            if (piece.getCoordinatesX() != pieces.get(i).getCoordinatesX()
            && piece.getCoordinatesY() != pieces.get(i).getCoordinatesY()) {
                count++;
            }
        }
        if (count == pieces.size()) {
            if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
                pieces.add(piece);
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                return  pieces.get(i);
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getCoordinatesX() && y == pieces.get(i).getCoordinatesY()) {
                pieces.remove(i);
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
