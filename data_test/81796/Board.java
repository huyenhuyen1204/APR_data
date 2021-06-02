import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    public final static int WIDTH = 8;
    public final static int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
    }

    public void addPiece(Piece p) {
        if (validate(p.getCoordinatesX(), p.getCoordinatesY())
        && this.getAt(p.getCoordinatesX(), p.getCoordinatesY()) == null) {
            pieces.add(p);
        }
    }

    public boolean validate(int x, int y) {
        return (x >= 1 && x <= 8
        && y >=1 && y <= 8);
    }

    public void removeAt(int x, int y) {
        Piece piece = getAt(x, y);
        pieces.remove(piece);
    }

    public Piece getAt(int x, int y) {
        Iterator<Piece> itr = pieces.iterator();
        Piece curP;
        Piece piece = null;
        while (itr.hasNext()) {
            curP = itr.next();
            if (curP.getCoordinatesX() == x
                    && curP.getCoordinatesY() == y) {
                piece = curP;
            }
        }
        return piece;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
