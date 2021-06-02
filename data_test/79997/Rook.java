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
        if (x != this.getX() && y != this.getY()) {
            return false;
        }
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < board.getPieces().size(); i++) {
            if (board.getPieces().get(i).getColor().equals(this.getColor())) {
                if (board.getPieces().get(i).getX() != this.getX()
                        && board.getPieces().get(i).getY() != this.getY()) {
                    pieces.add(board.getPieces().get(i));
                }
                if (board.getPieces().get(i).getX() == x
                        && board.getPieces().get(i).getY() == y) {
                    return false;
                }
            }
        }
        ArrayList<Piece> rooks = new ArrayList<>();
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getColor().equals(this.getColor())) {
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
               if ((rooks.get(i).getX() < x && rooks.get(i).getX() > this.getX())
               || (rooks.get(i).getX() > x && rooks.get(i).getX() < this.getX())) {
                   return false;
               }
            } else if (rooks.get(i).getX() == this.getX()) {
                if ((rooks.get(i).getY() < y && rooks.get(i).getY() > this.getY())
                        || (rooks.get(i).getY() > y && rooks.get(i).getY() < this.getY())) {
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
