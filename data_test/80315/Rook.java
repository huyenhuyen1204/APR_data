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
        if (!(x >= 1 && x <= 8) || !(y >= 1 && y <= 8)) {
            return false;
        } else {
            if (this.getX() != x && this.getY() != y) {
                return false;
            } else {
                if (this.getX() == x) {
                    for (int i = 0; i < board.getPieces().size(); i++) {
                        Piece piece = board.getPieces().get(i);
                        if (piece.getX() == x && piece.getY() == y) {
                            piece.setIsRemove(true);
                        }
                        if (piece.getX() == x) {
                            int min = this.getY() < y ? this.getY() : y;
                            int max = this.getY() > y ? this.getY() : y;
                            if ((piece.getY() >= min && piece.getY() < max)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
                if (this.getY() == y) {
                    for (int i = 0; i < board.getPieces().size(); i++) {
                        Piece piece = board.getPieces().get(i);
                        if (piece.getY() == y) {
                            int min = this.getX() < x ? this.getX() : x;
                            int max = this.getX() > x ? this.getX() : x;
                            if ((piece.getX() >= min && piece.getX() < max)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
