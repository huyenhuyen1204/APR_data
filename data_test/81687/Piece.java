

public abstract class Piece {

    private Board board;
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /** khoi tao
     * @param x x(a->h)
     * @param y y(1->8)
     */
    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
        color = "white";
    }

    /** khoi tao
     * @param x x
     * @param y y
     * @param color color
     */
    public Piece(int x, int y, String color) {
        coordinatesX = x;
        coordinatesY = y;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    @Override
    public String toString() {
        return color
                + "-" + (char) (coordinatesX - 1 + 'a')
                + coordinatesY;
    }
}
