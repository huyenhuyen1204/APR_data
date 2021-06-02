public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * getCoordinatesX.
     * @return coordinatesX
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * setCoordinatesX.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * getCoordinatesY.
     * @return coordinatesY
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * setCoordinatesY.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * getColor.
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * setColor.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * defaultConstructor.
     */
    public Piece() {
    }

    /**
     * constructor1.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * constructor2.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * getSymbol.
     * @return symbol
     */
    public abstract String getSymbol();

    /**
     * canMove.
     * @return canMove
     */
    public abstract boolean canMove(Board board, int x, int y);
}
