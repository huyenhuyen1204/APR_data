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
        if (this.getX() != x && this.getY() != y) {
            check = false;
        } else {
            if (board.getAt(x, y) != null
                && board.getAt(x, y).getColor().equals(this.getColor())) {
                check = false;
            } else {
                for (int i = 0; i < n; i++) {
                    int X = board.getPieces().get(i).getX();
                    int Y = board.getPieces().get(i).getY();
                    if ((x < X && X < this.getX())
                        || (x > X && X > this.getX())
                        || (y < Y && Y < this.getY())
                        || (y > Y && Y > this.getY())) {
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