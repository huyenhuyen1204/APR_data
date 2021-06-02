public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /** Khoi tao 2 tham so. **/
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        color = "white";
    }

    /** Khoi tao 3 tham so. */
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /** Lay x. **/
    public int getX() {
        return x;
    }

    /** Tao x. **/
    public void setX(int x) {
        this.x = x;
    }

    /** Lay y. **/
    public int getY() {
        return y;
    }

    /** Tao y. **/
    public void setY(int y) {
        this.y = y;
    }

    /** Lay mau. */
    public String getColor() {
        return color;
    }

    /** Tao mau. */
    public void setColor(String color) {
        this.color = color;
    }

    /** Ky hieu quoc te. **/
    public abstract String getSymbol();

    /** Kha nang di chuyen. **/
    public abstract boolean canMove(Board board, int x, int y);
}