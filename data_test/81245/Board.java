import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
    public final int WIDTH = 8;
    public final int HEIGHT = 8;
    private ArrayList<Piece> pieces;
    public Map<String, Piece> mapPieces = new HashMap<>();

    public Board() {
    }

    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();

        if (!validate(x, y)) {
            return;
        } else {
            for (int i = 0; i < this.pieces.size(); i++) {
                if (this.pieces.get(i).getCoordinatesX() == x
                        && this.pieces.get(i).getCoordinatesY() == y) {
                    return;
                }
            }

            this.pieces.add(piece);
            this.mapPieces.put(x + ";" + y, piece);
        }
    }

    public boolean validate(int x, int y) {
        return 1 <= x && x <= 8 && 1 <= y && y <= 8;
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }

        return null;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                this.mapPieces.remove(x + ";" + y);
                return;
            }
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
