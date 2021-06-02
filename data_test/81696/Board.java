import java.util.ArrayList;

/**
 * Created by CCNE on 30/11/2020.
 */
public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    public boolean validate(int x, int y) {
        boolean con1 = (x >= 1) && (x <= 8);
        boolean con2 = (y >= 1) && (y <= 8);
        return con1 & con2;
    }

    public void addPiece(Piece piece) {
        boolean con1 = true;
        for (Piece pieceC : pieces) {
            if (pieceC.checkPosition(piece) == true) {
                con1 = false;
                break;
            }
        }
        boolean con2 = validate(piece.getCoordinatesX(), piece.getCoordinatesY());
        if (con1 && con2) {
            pieces.add(piece);
        }
    }

    public Piece getAt(int x, int y) {
        for (Piece pieceC : pieces) {
            boolean con1 = pieceC.getCoordinatesX() == x;
            boolean con2 = pieceC.getCoordinatesY() == y;
            if (con1 && con2) {
                return pieceC;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (Piece pieceC : pieces) {
            boolean con1 = pieceC.getCoordinatesX() == x;
            boolean con2 = pieceC.getCoordinatesY() == y;
            if (con1 && con2) {
                pieces.remove(pieceC);
                break;
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
