import java.util.ArrayList;

public class Board {
    public final int WIDTH = 8;
    public final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Board() {

    }

    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())
                && (locationPlaced(piece.getCoordinatesX(), piece.getCoordinatesY()))) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        if (x >= 1 && y >= 1 && x <=8 && y <= 8) {
            return true;
        }
        return false;
    }

    public void removeAt(int x, int y) {
        pieces.remove(getAt(x, y));
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
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

    /**
     * Tra ve false neu o co do da co quan co khac.
     * @param x qưe
     * @param y qưe
     * @return qưe
     */
    public boolean locationPlaced (int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return false;
            }
        }
        return true;
    }


}
