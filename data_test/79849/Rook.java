import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (super.getX() == x || super.getY() == y) {
            ArrayList<Piece> pieces = board.getPieces();
            if(super.getX() == x) {
                for(Piece p: pieces) {
                    if(p.getY() < y) {
                        return false;
                    }
                }
            }else if (super.getY() == y) {
                for(Piece p: pieces) {
                    if(p.getY() < x) {
                        return false;
                    }
                }
            }
            Piece piece = board.getAt(x, y);
            if (piece == null) {
                return true;
            } else {
                return !piece.getColor().equals(super.getColor());
            }
        }
        return false;
    }
}