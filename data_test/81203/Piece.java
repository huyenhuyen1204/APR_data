public abstract class Piece {

    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * iloveyou.
     */
    public Piece(int coordinatesX, int coordinatesY) {

        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * iloveyou.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {

        this.coordinatesY = coordinatesY;
        this.coordinatesX = coordinatesX;
        this.color = color;
    }

    /**
     * ilovyou.
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * iloveyou.
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * iloveyou.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * dfakdhla.
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * sfhaadf.
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * fdadja.
     */
    public String getColor() {
        return color;
    }

    /**
     * dfaldf.
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * fhskjda.
     */
    public abstract String getSymbol();

    /**
     * ghksdf.
     */
    public boolean checkPosition(Piece piece) {
        if (piece.getCoordinatesX() >= 1 && piece.getCoordinatesX() <= 8
                && piece.getCoordinatesY() >= 1 && piece.getCoordinatesY() <= 8) {
            return true;
        }
        return false;
    }
}
