public class Rook extends Piece {
    /**
     * idoj.
     * @param coordinatesX x
     * @param coordinatesY y
     */
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    /**
     * dn.
     * @param coordinatesX x
     * @param coordinatesY y
     * @param color c
     */
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (board.getPieces().isEmpty() ||
                (this.getCoordinatesX() != x && this.getCoordinatesY() != y)) {
            return false;
        }
        if (x == this.getCoordinatesX()) {
            if (y < this.getCoordinatesY()) {
                for (int i = y; i < this.getCoordinatesY(); i++) {
                    Piece piece = board.getAt(x,i);
                    if (piece != null) {
                        if (i != y) {
                            return false;
                        } else {
                            if (piece.getColor().equals(this.getColor())) {
                                return false;
                            }
                        }
                    }
                }
            }
            else {
                for (int i = y; i > this.getCoordinatesY(); i--) {
                    Piece piece = board.getAt(x,i);
                    if (piece != null){
                        if (i != y) {
                            return false;
                        } else {
                            if (piece.getColor().equals(this.getColor())) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        else {
            if (x < this.getCoordinatesX()) {
                for (int i = x; i < this.getCoordinatesX(); i++){
                    Piece piece = board.getAt(i,y);
                    if (piece != null) {
                        if (i != x) {
                            return false;
                        } else {
                            if (piece.getColor().equals(this.getColor())) {
                                return false;
                            }
                        }
                    }
                }
            }
            else {
                for (int i = x; i > this.getCoordinatesX(); i--){
                    Piece piece = board.getAt(i,y);
                    if (piece != null) {
                        if(i == x && piece.getColor() == this.getColor()){
                            return false;
                        }
                        if(i != x) {
                            return false;
                        } else {
                            if (piece.getColor().equals(this.getColor())) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        this.setCoordinatesX(x);
        this.setCoordinatesY(y);
        return true;
    }
}
