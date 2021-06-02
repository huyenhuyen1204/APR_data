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
        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }
        if (x == this.getCoordinatesX() && y == this.getCoordinatesY()) {
            return false;
        }
        if (x == this.getCoordinatesX()) {
            if (y < this.getCoordinatesY()) {
                for (int i = y + 1; i < this.getCoordinatesY(); ++ i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getCoordinatesX() == x && p.getCoordinatesY() == i) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = y - 1; i > this.getCoordinatesY(); -- i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getCoordinatesX() == x && p.getCoordinatesY() == i) {
                            return false;
                        }
                    }
                }
            }
        } else {
            if (x < this.getCoordinatesX()) {
                for (int i = x + 1; i < this.getCoordinatesX(); ++ i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getCoordinatesY() == y && p.getCoordinatesX() == i) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = x - 1; i > this.getCoordinatesX(); -- i) {
                    for (Piece p : board.getPieces()) {
                        if (p.getCoordinatesY() == y && p.getCoordinatesX() == i) {
                            return false;
                        }
                    }
                }
            }
        }
        for (Piece p : board.getPieces()) {
            if (p.getCoordinatesY() == y && p.getCoordinatesX() == x && p.getColor() == this.getColor()) {
                return false;
            }
        }
        return true;
    }
}
