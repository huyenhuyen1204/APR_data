public abstract class Piece {
    private int x1;
    private int y1;
    private String color;

    /**
     * abc.
     */
    public Piece(int x, int y) {
        this.x1 = x;
        this.y1 = y;
        color = "white";
    }

    /**
     * abc.
     */
    public Piece(int x, int y, String color) {
        this.x1 = x;
        this.y1 = y;
        this.color = color;
    }

    public int getX() {
        return x1;
    }

    public void setX(int x) {
        this.x1 = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getY() {
        return y1;
    }

    public void setY(int y) {
        this.y1 = y;
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
