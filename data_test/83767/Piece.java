public abstract class Piece {

    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Constructor.
     */
    public Piece(int coordinateX, int coordinateY) {
        this.coordinatesX = coordinateX;
        this.coordinatesY = coordinateY;
        this.color = "white";
    }

    /**
     * Constructor 2.
     */
    public Piece(int coordinateX, int coordinateY, String color) {
        this.coordinatesX = coordinateX;
        this.coordinatesY = coordinateY;
        this.color = color;
    }

    /**
     * get symbol of the piece.
     */
    public abstract String getSymbol();

    /**
     * check move of piece.
     */
    public abstract boolean canMove(Board board, int x, int y);

    public boolean checkPosition() {
        return true;
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
}
