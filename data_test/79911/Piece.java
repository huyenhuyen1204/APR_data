public abstract class Piece {
    private int _x;
    private int _y;
    private String color;

    /** Constructor. **/
    public Piece(int x, int y) {
        this._x = x;
        this._y = y;
        this.color = "white";
    }

    /** Constructor. **/
    public Piece(int x, int y, String color) {
        this._x = x;
        this._y = y;
        this.color = color;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public String getColor() {
        return color;
    }

    public void setX(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);
}
