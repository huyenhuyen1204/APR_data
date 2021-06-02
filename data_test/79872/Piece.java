public abstract class Piece {
    private int x;

    private int y;

    private String color;

    /**
     * javadoc.
     */
    public Piece(int x, int y) {
        if (x >= 1 && y <= 8) {
            this.x = x;
            this.y = y;
            this.color = "white";
        }
    }

    /**
     * javadoc.
     */
    public Piece(int x, int y, String color) {
        if ((x >= 1 && y <= 8) && (color.equals("white") || color.equals("black"))) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    /**
     * javadoc.
     */
    public int getX() {
        return x;
    }

    /**
     * javadoc.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * javadoc.
     */
    public int getY() {
        return y;
    }

    /**
     * javadoc.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * javadoc.
     */
    public String getColor() {
        return color;
    }

    /**
     * javadoc.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * javadoc.
     */
    public abstract String getSymbol();

    /**
     * javadoc.
     */
    public abstract boolean canMove(Board board, int x, int y);

}
