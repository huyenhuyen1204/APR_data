import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Hello, this is me ure looking for.
     */
    public Board() {
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void addPiece(Piece piece) {
        int thisX;
        int thisY;
        thisX = piece.getCoordinatesX();
        thisY = piece.getCoordinatesY();
        if (validate(thisX, thisY) && getAt(thisX, thisY) == null) {
            pieces.add(piece);
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public boolean validate(int thisX, int thisY) {
        return (1 <= thisX && 1 <= thisY) && (thisX <= 8 && thisY <= 8);
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void removeAt(int thisX, int thisY) {
        Piece piece = getAt(thisX, thisY);
        if (piece != null) {
            pieces.remove(piece);
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Piece getAt(int thisX, int thisY) {
        for (int i = 0; i < pieces.size(); i++) {
            if (thisX == pieces.get(i).getCoordinatesX()
                    && thisY == pieces.get(i).getCoordinatesY()) {
                return pieces.get(i);
            }
        }
        return null;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setPieces(ArrayList<Piece> piece) {
        pieces = piece;
    }
}
