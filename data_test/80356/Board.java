import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /** Khoi tao. **/
    public Board() {
    }

    /** Xac nhan. **/
    public boolean validate(int x, int y) {
        if (x >= 1 && y <= 8) {
            return true;
        } else {
            return false;
        }
    }

    /** Them quan co. **/
    public void addPiece(Piece piece) {
        int c = 0;
        for (int i = 0; i < pieces.size(); i++) {
            if (piece.getX() == pieces.get(i).getX()
                && piece.getY() == pieces.get(i).getY()) {
                c++;
            }
        }
        if (piece.getX() >= 1 && piece.getY() <= 8 &&
            c == 0) {
            pieces.add(piece);
        }
    }

    /** Lay quan co. **/
    public Piece getAt(int x, int y) {
        Piece p = null;
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x
                && pieces.get(i).getY() == y) {
                p = pieces.get(i);
            }
        }
        return p;
    }

    /** Xoa quan co. **/
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == x
                && pieces.get(i).getY() == y) {
                pieces.remove(i);
            }
        }
    }

    /** Lay cac quan co. **/
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /** Tao cac quan co. **/
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}