public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /** binhdang. */
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /** binhdang. */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /** binhdang. */
    public abstract String getSymbol();

    /** binhdang. */
    public abstract boolean canMove(Board board, int x, int y);

    /** binhdang. */
    public String getColor() {
        return color;
    }

    /** binhdang. */
    public void setColor(String color) {
        this.color = color;
    }

    /** binhdang. */
    public boolean checkPosition(Piece piece) {
        return true;
    }

    /** binhdang. */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /** binhdang. */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /** binhdang. */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /** binhdang. */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

}
