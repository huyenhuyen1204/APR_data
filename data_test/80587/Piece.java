public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Hello, this is me ure looking for.
     */
    public Piece(int thisX, int thisY) {
        coordinatesX = thisX;
        coordinatesY = thisY;
        color = "white";
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Piece(int thisX, int thisY, String str) {
        coordinatesX = thisX;
        coordinatesY = thisY;
        color = str;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public abstract String getSymbol();

    /**
     * Hello, this is me ure looking for.
     */
    public abstract boolean canMove(Board board, int thisX, int thisY);

    /**
     * Hello, this is me ure looking for.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public String getColor() {
        return color;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setCoordinatesX(int coordinatesX) {
        if (1 <= coordinatesX && coordinatesX < +8) {
            this.coordinatesX = coordinatesX;
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setCoordinatesY(int coordinatesY) {
        if (1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesY = coordinatesY;
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setColor(String color) {
        if (color.equals("white") || color.equals("black")) {
            this.color = color;
        }
    }

    /**
     * Hello, this is me ure looking for.
     */
    public boolean checkPosition(Piece p) {
        return 1 <= p.getCoordinatesX() && p.getCoordinatesX() <= 8 && 1 <= p.getCoordinatesY() && p.getCoordinatesY() <= 8;
    }
}
