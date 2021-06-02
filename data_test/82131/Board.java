import java.time.Period;
import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {

    }

    public void addPiece(Piece piece) {
        if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        }
        for (Piece element : pieces) {
            if (element.getCoordinatesX() == piece.getCoordinatesX()
                    && element.getCoordinatesY() == piece.getCoordinatesY()) {
                return;
            }
        }
        pieces.add(piece);
    }

    public boolean validate(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            return false;
        }
        return true;
    }

    public void removeAt(int x, int y) {
        for (Piece element : pieces) {
            if (element.getCoordinatesX() == x && element.getCoordinatesY() == y) {
                pieces.remove(element);
                return;
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (Piece element : pieces) {
            if (element.getCoordinatesX() == x && element.getCoordinatesY() == y) {
                return element;
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
