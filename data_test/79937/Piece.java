/**
 * Created by CCNE on 19/11/2020.
 */
public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**
     * Loan .
     */
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = "while";
    }

    /**
     * Loan .
     */
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Loan .
     */
    public abstract String getSymbol();

    /**
     * Loan .
     */
    public int getX() {
        return x;
    }

    /**
     * Loan .
     */
    public int getY() {
        return y;
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
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Loan .
     */
    public void setY(int y) {
        this.y = y;
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
