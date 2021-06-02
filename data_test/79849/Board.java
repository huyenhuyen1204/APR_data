import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<Piece>();
    }

    /**
    * Comment.
    * */
    public void addPiece(Piece piece) {
        if (validate(piece.getX(), piece.getY())) {
            for (Piece p : pieces) {
                if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
                    return;
                }
            }
            this.pieces.add(piece);
        }
    }

    /**
     * Comment.
     * */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * Comment.
     * */
    public void removeAt(int x, int y) {
        int length = pieces.size();
        for (int i = 0; i < length; i++) {
            Piece temp = pieces.get(i);
            if (temp.getX() == x && temp.getY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    /**
     * Comment.
     * */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
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
