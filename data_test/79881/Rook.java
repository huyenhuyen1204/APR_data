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
        if (x != this.getX() && y != this.getY()) {
            return false;
        }
        if (x == this.getX())
        {
            if (y > this.getY()) {
                for (int i = y + 1; i < this.getY(); ++ i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getX() == x && p.getY() == i) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = y - 1; i >= this.getY(); -- i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getX() == x && p.getY() == i) {
                            return false;
                        }
                    }
                }
            }
        } else {
            if (x > this.getX()) {
                for (int i = x + 1; i <= this.getX(); ++ i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getY() == y && p.getX() == i) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = x - 1; i >= this.getX(); -- i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getY() == y && p.getX() == i) {
                            return false;
                        }
                    }
                }
            }
        }
        for (Piece p : board.getPieces()) {
            if (p.getY() == y && p.getX() == x && p.getColor() == this.getColor()) {
                return false;
            }
        }
        return true;
    }
}
