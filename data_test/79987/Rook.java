import java.util.ArrayList;

public class Rook extends Piece {

    /**
     * phuong thuc khoi tao.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * phuong thuc khoi tao.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
       return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        ArrayList<Piece> pieces = board.getPieces();
        ArrayList<Piece> rooks = new ArrayList<>();
        for (int i = 0; i < pieces.size(); i++) {
            if (!pieces.get(i).getColor().equals(this.getColor())) {
                if (pieces.get(i).getX() == this.getX()) {
                    rooks.add(pieces.get(i));
                } else if (pieces.get(i).getY() == this.getY()) {
                    rooks.add(pieces.get(i));
                }
            }
        }
        int lenght = rooks.size();
        for (int i = 0; i < lenght; i++) {
            if (rooks.get(i).getY() == this.getY()) {
                int am = Math.abs(x - rooks.get(i).getX());
                int bm = Math.abs(this.getX() - rooks.get(i).getX());
                int ab = Math.abs(x - this.getX());
                if ((am + bm) == ab) {
                    return false;
                }
            } else if (rooks.get(i).getX() == this.getX()) {
                int am = Math.abs(y - rooks.get(i).getY());
                int bm = Math.abs(this.getY() - rooks.get(i).getY());
                int ab = Math.abs(y - this.getY());
                if ((am + bm) == ab) {
                    return false;
                }
            }
        }
        return true;
        /**
        int l = rooks.size();
        if (x < this.getX()) {
            for (int i = x; i < this.getX(); i++) {
                for (int j = 0; j < l; j++) {
                    if (rooks.get(j).getX() == y && rooks.get(j).getY() == this.getY()) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = this.getX() + 1; i <= x; i++) {
                for (int j = 0; j < l; j++) {
                    if (rooks.get(j).getX() == i && rooks.get(j).getY() == this.getY()) {
                        return false;
                    }
                }
            }
        }

        if (y < this.getY()) {
            for (int i = y; i < this.getY(); i++) {
                for (int j = 0; j < l; j++) {
                    if (rooks.get(j).getY() == i && rooks.get(j).getX() == this.getX()) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = this.getY(); i <= y; i++) {
                for (int j = 0; j < l; j++) {
                    if (rooks.get(j).getY() == i && rooks.get(j).getX() == this.getY()) {
                        return false;
                    }
                }
            }
        }
         */
    }
}
