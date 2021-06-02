public abstract class Piece {

    private int _x;
    private int _y;
    private String color;
    
    /**
     * cmt.
     */
    public Piece(int x, int y) {
        this._x = x;
        this._y = y;
        this.color = "white";
    }
    
    /**
     * cmt.
     */
    public Piece(int x, int y, String color) {
        this._x = x;
        this._y = y;
        this.color = color;
    }

    public int getX() {
        return _x;
    }

    public void setX(int x) {
        this._x = x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        this._y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);
    
    /**
     * cmt.
     */
    public boolean checkPosition(Piece piece) {
        if (_x == piece.getX() && _y == piece.getY()) {
            return false;
        } else {
            return true;
        }
    }

}
