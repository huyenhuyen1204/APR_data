public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**1.*/
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = "white";
    }

    /**1.*/
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**1.*/
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**1.*/
    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    /**1.*/
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**1.*/
    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
    }

    /**1.*/
    public String getColor() {
        return color;
    }

    /**1.*/
    public void setColor(String color) {
        this.color = color;
    }

    /**1.*/
    public abstract String getSymbol();

    /**1.*/
    public abstract boolean canMove(Board board, int x, int y);
}
