public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /** binhdang. */
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** binhdang. */
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /** binhdang. */
    public abstract String getSymbol();

    /** binhdang. */
    public abstract boolean canMove(Board board, int x, int y);

    /** binhdang. */
    public int getX() {
        return x;
    }

    /** binhdang. */
    public void setX(int x) {
        this.x = x;
    }

    /** binhdang. */
    public int getY() {
        return y;
    }

    /** binhdang. */
    public void setY(int y) {
        this.y = y;
    }

    /** binhdang. */
    public String getColor() {
        return color;
    }

    /** binhdang. */
    public void setColor(String color) {
        this.color = color;
    }

    /** binhdang. */
    public boolean checkPosition(Piece piece) {
        return true;
    }
}
