public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board,int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * cmt.
     *
     */
    public void setCoordinatesX(int coordinatesX) {
        if (coordinatesX <= 8 && coordinatesX >= 1) {
            this.coordinatesX = coordinatesX;
        }
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * cmt.
     *
     */
    public void setCoordinatesY(int coordinatesY) {
        if (coordinatesY >= 1 && coordinatesY <= 8) {
            this.coordinatesY = coordinatesY;
        }
    }

    public String getColor() {
        return color;
    }

    /**
     * cmt.
     *
     */
    public void setColor(String color) {
        if (color.equals("white") || color.equals("black")) {
            this.color = color;
        }
    }

    public boolean checkPosition(Piece piece) {
        return false;
    }
}
