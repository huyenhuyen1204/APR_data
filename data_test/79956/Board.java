import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>(0);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    
    /**
     * cmt.
     */
    public boolean validate(int x, int y) {
        if (1 <= x && x <= 8 && 1 <= y && y <= 8) {
            return true;
        }
        return false;
    }
    
    /**
     * cmt.
     */
    public void addPiece(Piece p) {
        boolean check = true;

        if (pieces != null) {
            for (Piece temp : pieces) {
                if (!p.checkPosition(temp)) {
                    check = false;
                    break;
                }
            }
        }
        if (validate(p.getX(), p.getY()) && check) {
            pieces.add(p);
        }
    }
    
    /**
     * cmt.
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * cmt.
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
                pieces.remove(i);
            }
        }
    }

}
