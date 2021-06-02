public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /** Khoi tao 2 tham so. **/
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        color = "white";
    }

    /** Khoi tao 3 tham so. */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /** Lay x. **/
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /** Tao x. **/
    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    /** Lay y. **/
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /** Tao y. **/
    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
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