public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece() {

    }

    /**
     * ham khoi tao 2 tham so.
     * @param coordinatesX df
     * @param coordinatesY df
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    /**
     * ham khoi tao 3 tham so.
     * @param coordinatesX sd
     * @param coordinatesY df
     * @param color df
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

   public abstract String getSymbol();

   public abstract boolean canMove(Board board, int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
