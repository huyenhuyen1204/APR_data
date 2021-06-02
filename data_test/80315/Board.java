import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public void addPiece(Piece piece) {
        if (validate(piece.getX(), piece.getY())) {
            for (int i = 0; i < pieces.size(); i++) {
                if (piece.getX() == pieces.get(i).getX()
                        && piece.getY() == piece.getY()) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getY() == x && pieces.get(i).getY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getY() == x && pieces.get(i).getY() == y) {
                pieces.remove(i);
                return;
            }
        }
    }
}
