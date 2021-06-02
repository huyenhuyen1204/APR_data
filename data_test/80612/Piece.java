/**
 * Created by CCNE on 19/11/2020.
 */
public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Loan .
     */
    public Piece(int x, int y) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = "white";
    }

    /**
     * Loan .
     */
    public Piece(int x, int y, String color) {
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.color = color;
    }

    /**
     * Loan .
     */
    public abstract String getSymbol();

    /**
     * Loan .
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Loan .
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Loan .
     */
    public String getColor() {
        return color;
    }

    /**
     * Loan .
     */
    public void setCoordinatesX(int x) {
        this.coordinatesX = x;
    }

    /**
     * Loan .
     */
    public void setCoordinatesY(int y) {
        this.coordinatesY = y;
    }

    /**
     * Loan .
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Loan .
     */
    public abstract boolean canMove(Board board, int x, int y);
}

