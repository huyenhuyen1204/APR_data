
import java.util.ArrayList;

public class Board {
    public static int WIDTH = 8;
    public static int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public boolean validate(int x, int y) {
        return (1 <= x && y <= 8);
    }

    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if(piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        for (Piece piece : pieces) {
            if(piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                pieces.remove(piece);
                break;
            }
        }
    }
    
}
