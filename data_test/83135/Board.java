import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {

    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public boolean validate(int x, int y) {
        if (x > 8 || x < 1) {
            return false;
        }
        if (y > 8 || y < 1) {
            return false;
        }
        return true;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if(pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if(pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
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
