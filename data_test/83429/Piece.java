public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * alo.
     */
    public Piece() {

    }

    /**
     * alo.
     */
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = "white";
    }

    /**
     * alo.
     */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**
     * alo.
     */

    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * alo.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * alo.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * alo.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * alo.
     */
    public String getColor() {
        return color;
    }

    /**
     * alo.
     */

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * alo.
     */

    public abstract String getSymbol();

    /**
     * alo.
     */
    public abstract boolean canMove(Board board, int x, int y);
}

