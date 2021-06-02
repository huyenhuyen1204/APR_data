import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    Board() {

    }

    /**
     * gdfgdf.
     * @return
     */
    public boolean validate(int x, int y) {
        return (x >= 1 && x <= 8
                && y >= 1 && y <= 8) ? true : false;
    }

    /**
     * fasfa.
     */
    public void addPiece(Piece piece) {
        boolean check = false;
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            for (int i = 0; i < pieces.size(); i++) {
                if (piece.getCoordinatesX() == pieces.get(i).getCoordinatesX()) {
                    if (piece.getCoordinatesY() == pieces.get(i).getCoordinatesY()) {
                        check = true;
                    }
                }
            }
            if (check == false) {
                pieces.add(piece);
            }
        }
    }

    /**
     * gfd.
     * @return
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    /**
     * gdfgdf.
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }


}
