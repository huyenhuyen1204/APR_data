public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**
     * abc.
     */
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        color = "white";
    }

    /**
     * abc.
     */
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * abc.
     */
    public abstract String getSymbol();

    /**
     * abc.
     */
    public abstract boolean canMove(Board board, int x, int y);

}
