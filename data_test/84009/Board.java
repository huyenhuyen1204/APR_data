import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int WIDTH = 8;
    public static final int HIEGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * cmt.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * cmt.
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * cmt.
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && y <= 8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * cmt.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            for(Piece p : pieces) {
                if(p.getCoordinatesX() == piece.getCoordinatesX() && p.getCoordinatesY() == piece.getCoordinatesY()) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    /**
     * cmt.
     */
    public Piece getAt(int x, int y) {
        for(Piece piece : pieces) {
            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    /**
     * cmt.
     */
    public void removeAt(int x, int y) {
        for(int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                return;
            }
        }
    }
}

