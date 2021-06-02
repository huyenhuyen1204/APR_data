import java.util.ArrayList;

public class Board {
    private final int WIDTH = 8;
    private final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board () {

    }

    public void addPiece(Piece newPiece) {
        if (validate(newPiece.getCoordinatesX(), newPiece.getCoordinatesY())
                && getAt(newPiece.getCoordinatesX(), newPiece.getCoordinatesY()) == null) {
            pieces.add(newPiece);
        }
    }

    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <=8) {
            return true;
        }
        return false;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
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

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }
}
