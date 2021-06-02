import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<Piece>();

    public boolean validate(int x, int y) {
        return (1 <= x && x <= 8 && 1 <= y && y <= 8);
    }

    public void addPiece(Piece piece) {
        if (!validate(piece.getX(), piece.getY()))
            return ;

        for(int i = 0; i < pieces.size(); i ++) {
            Piece p = pieces.get(i);
            if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
                return ;
            }
        }

        pieces.add(piece);
    }

    public Piece getAt(int x, int y) {
        for(int i = 0; i < pieces.size(); i ++) {
            Piece p = pieces.get(i);
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }

        return null;
    }

    public void removeAt(int x, int y) {
        for(int i = 0; i < pieces.size(); i ++) {
            Piece p = pieces.get(i);
            if (p.getX() == x && p.getY() == y) {
                pieces.remove(p);
            }
        }

        return;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
