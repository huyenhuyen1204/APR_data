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

    public boolean validate(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
            return true;
        }
        return false;
    }

    public void addPiece(Piece piece) {
        for (Piece check : this.pieces) {
            if (check.getX() == piece.getX() && check.getY() == piece.getY()) {
                return;
            }
        }
        if (validate(piece.getX(), piece.getY())) {
            this.pieces.add(piece);
        }
    }

    public void removeAt(int x, int y) {
        for (Piece check : this.pieces) {
            if (check.getX() == x && check.getY() == y) {
                this.getPieces().remove(check);
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (Piece check : this.pieces) {
            if (check.getX() == x && check.getY() == y) {
                return check;
            }
        }
        return null;
    }
}
