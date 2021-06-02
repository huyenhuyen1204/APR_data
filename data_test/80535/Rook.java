import java.util.ArrayList;

public class Rook extends Piece {

    /** Khoi tao 2 tham so. **/
    public Rook(int x, int y) {
        super(x, y);
    }

    /** Khoi tao 3 tham so. **/
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        boolean check = true;
        ArrayList<Piece> ps = new ArrayList<>();
        int n = board.getPieces().size();
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            check = false;
        } else {
            if (board.getAt(x, y) != null
                && board.getAt(x, y).getColor().equals(this.getColor())) {
                check = false;
            } else {
                for (int i = 0; i < n; i++) {
                    int abscissa = board.getPieces().get(i).getCoordinatesX();
                    int ordinate = board.getPieces().get(i).getCoordinatesY();
                    if ((x < abscissa && abscissa < this.getCoordinatesX())
                        || (x > abscissa && abscissa > this.getCoordinatesX())
                        || (y < ordinate && ordinate < this.getCoordinatesY())
                        || (y > ordinate && ordinate > this.getCoordinatesY())) {
                        ps.add(board.getPieces().get(i));
                    }
                }
                if (ps.size() > 0) {
                    check = false;
                }
            }
        }
        return check;
    }
}