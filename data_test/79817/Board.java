import java.util.ArrayList;

/**
 * Created by CCNE on 19/11/2020.
 */
public class Board {
    public int WIDTH = 8;
    public int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {}

    public void addPiece(Piece piece) {
        if (validate(piece.getX(), piece.getY())) {
            pieces.add(piece);
        }
    }

    // Ktra toa do hop le
    public boolean validate(int x, int y) {
        if (x >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getX() && y == pieces.get(i).getY()) {
                pieces.remove(i);
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (x == pieces.get(i).getX() && y == pieces.get(i).getY()) {
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
