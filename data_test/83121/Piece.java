public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**h hu.*/
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = "white";
    }

    /**hu hu.*/
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**hu hu.*/
    public abstract String getSymbol();

    /**hu hu.*/
    public abstract boolean canMove(Board board, int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean checkPosition(Piece p) {
        return true;
    }
}
