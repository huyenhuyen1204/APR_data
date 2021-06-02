public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece() {
    }

    /**
     * constructor.
     * @param coordinatesX coordinate x
     * @param coordinatesY coordinate y
     * @param color color
     */

    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    public abstract String getSymbol();

    /**
     * check available move.
     * @param board board
     * @param x coordinate x
     * @param y coordinate y
     * @return true if can move
     */

    public abstract boolean canMove( Board board, int x, int y);

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
     * if position is available.
     * @param piece piece
     * @return true if available
     */

    public boolean checkPosition(Piece piece) {
        if (piece == null) {
            return false;
        }
        return true;
    }
}
