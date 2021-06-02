public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * constructor of piece with 2 parameters.
     * @param coordinatesX coordinates x.
     * @param coordinatesY coordinates y.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        if (1 <= coordinatesX && coordinatesX <= 8
                && 1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = "white";
        }
    }

    /**
     * constructor of piece with 3 parameters.
     * @param coordinatesX coordinates x.
     * @param coordinatesY coordinates y.
     * @param color color of piece.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (1 <= coordinatesX && coordinatesX <= 8
                && 1 <= coordinatesY && coordinatesY <= 8
                && (color.equals("white") || color.equals("black"))) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = color;
        }
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    /**
     * check position.
     * @param piece piece.
     * @return true if match.
     */
    public boolean checkPosition(Piece piece) {
        int x = piece.coordinatesX;
        int y = piece.coordinatesY;
        return this.coordinatesX == x && this.coordinatesY == y;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * setter coordinates x.
     * @param coordinatesX coordinates x.
     */
    public void setCoordinatesX(int coordinatesX) {
        if (1 <= coordinatesX && coordinatesX <= 8) {
            this.coordinatesX = coordinatesX;
        }
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * setter coordinates y.
     * @param coordinatesY coordinates y.
     */
    public void setCoordinatesY(int coordinatesY) {
        if (1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesY = coordinatesY;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
