public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**uyds.*/
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        color = "white";
    }

    /**uyds.*/
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**uyds.*/
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**uyds.*/
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**uyds.*/
    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    /**uyds.*/
    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
    }

    /**uyds.*/
    public String getColor() {
        return color;
    }

    /**uyds.*/
    public void setColor(String color) {
        this.color = color;
    }

    /**uyds.*/
    public abstract String getSymbol();

    /**uyds.*/
    public abstract boolean canMove(Board board, int x, int y);
}
