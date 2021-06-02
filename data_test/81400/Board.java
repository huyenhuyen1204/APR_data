import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * cmt.
     *
     */
    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    /**
     * cmt.
     *
     */
    public void addPiece(Piece piece) {
        for (Piece check : this.pieces) {
            if (check.getCoordinatesX() == piece.getCoordinatesX()
                    && check.getCoordinatesY() == piece.getCoordinatesY()) {
                return;
            }
        }
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            this.pieces.add(piece);
        }
    }

    /**
     * cmt.
     *
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < this.pieces.size(); i++) {
            if (this.pieces.get(i).getCoordinatesX() == x
                    && this.pieces.get(i).getCoordinatesY() == y) {
                this.pieces.remove(i);
                break;
            }
        }
    }

    /**
     * cmt.
     *
     */
    public Piece getAt(int x, int y) {
        Piece res = null;
        for (int i = 0; i < this.pieces.size(); i++) {
            if (this.pieces.get(i).getCoordinatesX() == x
                    && this.pieces.get(i).getCoordinatesY() == y) {
                res = this.pieces.get(i);
                break;
            }
        }
        return res;
    }
}
