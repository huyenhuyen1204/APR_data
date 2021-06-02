/**
 * .
 * @author Nguyen Quyet Thang .
 */
public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * .
     * @param coordinatesX .
     * @param coordinatesY .
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * .
     * @param coordinatesX .
     * @param coordinatesY .
     * @param color .
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * .
     * @return .
     */
    public abstract String getSymbol();

    /**
     * .
     * @param board .
     * @param x .
     * @param y .
     * @return .
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * .
     * @return .
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * .
     * @param coordinatesX .
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * .
     * @return .
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * .
     * @param coordinatesY .
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * .
     * @return .
     */
    public String getColor() {
        return color;
    }

    /**
     * .
     * @param color .
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *  .
     * @param piece .
     * @return .
     */
    public boolean checkPosition(Piece piece) {
        if (piece.getCoordinatesX() >= 1 && piece.getCoordinatesX() <= 8
                && piece.getCoordinatesY() >= 1 && piece.getCoordinatesY() <= 8) {
            return true;
        }
        return false;
    }
}
