public abstract class Piece {
    private int coordinatesX;

    private int coordinatesY;

    private String color;

    /**
     * javadoc.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        if (coordinatesX >= 1 && coordinatesY <= 8) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = "white";
        }
    }

    /**
     * javadoc.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if ((coordinatesX >= 1 && coordinatesY <= 8) && (color.equals("white") ||
                color.equals("black"))) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = color;
        }
    }

    /**
     * javadoc.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * javadoc.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * javadoc.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * javadoc.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * javadoc.
     */
    public String getColor() {
        return color;
    }

    /**
     * javadoc.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * javadoc.
     */
    public abstract String getSymbol();

    /**
     * javadoc.
     */
    public abstract boolean canMove(Board board, int x, int y);

}
