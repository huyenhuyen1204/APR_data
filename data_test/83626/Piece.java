public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /**
     * abc.
     *
     * @param x     int.
     * @param y     int.
     * @param color int.
     */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

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

    /**
     * abc.
     *
     * @param p int.
     * @return int.
     */
    public boolean checkPosition(Piece p) {
        if ((coordinatesX == p.getCoordinatesX()) && (coordinatesY == p.coordinatesY)) {
            return false;
        }
        return true;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);
}