import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    Board() {
    }

    /**
     * f sdf s d.
     * @param piece te
     */
    public void addPieve(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY()) == true) {

            boolean sameLocation = false; // Chua co quan co nao o vi tri nay
            for (int i = 0; i < pieces.size(); i++) {
                if (pieces.get(i).getCoordinatesX() == piece.getCoordinatesX()
                && pieces.get(i).getCoordinatesY() == piece.getCoordinatesY()) {
                    sameLocation = true;
                    return;
                }
            }

            pieces.add(piece);
        }
    }

    /**
     * sdf s fs df.
     * @param x ert
     * @param y ert
     * @return
     */
    public boolean validate(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            return false;
        }

        return true;
    }

    /**
     *  ds ds d s.
     * @param x etr
     * @param y rt
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
     * f d fd d.
     * @param x fd f
     * @param y f df d
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
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
