import java.util.ArrayList;

public class Board {

    public final int WIDTH = 8;
    public final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean validate(int x, int y) {
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            return true;
        }
        return false;
    }

    public void addPiece(Piece p) {
        pieces.add(p);
    }

    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
                pieces.remove(i);
            }
        }
    }

}
