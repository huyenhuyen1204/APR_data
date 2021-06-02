public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * cmt.
     */
    public Piece(int x, int y) {
        if (x >= 1 && y <= 8) {
            this.coordinatesX = x;
            this.coordinatesY = y;
            this.color = "white";
        }
    }

    /**
     * cmt.
     */
    public Piece(int x, int y, String color) {
        if ((color == "white" || color == "black") && (x >= 1 && y <= 8)) {
            this.coordinatesX = x;
            this.coordinatesY = y;
            this.color = color;
        }
    }

    /**
     * cmt.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * cmt.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * cmt.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * cmt.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * cmt.
     */
    public String getColor() {
        return color;
    }

    /**
     * cmt.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * cmt.
     */
    public abstract String getSymbol();

    /**
     * cmt.
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * cmt.
     */
    public boolean checkPoint() {
        return true;
    }
}
