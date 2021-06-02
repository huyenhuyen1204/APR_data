public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**
     * cmt
     */
    public Piece(int x, int y) {
        if (x >= 1 && y <= 8) {
            this.x = x;
            this.y = y;
            this.color = "white";
        }
    }

    /**
     * cmt
     */
    public Piece(int x, int y, String color) {
        if ((color == "white" || color == "black") && (x >= 1 && y <= 8)) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    /**
     * cmt
     */
    public int getX() {
        return x;
    }

    /**
     * cmt
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * cmt
     */
    public int getY() {
        return y;
    }

    /**
     * cmt
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * cmt
     */
    public String getColor() {
        return color;
    }

    /**
     * cmt
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * cmt
     */
    public abstract String getSymbol();

    /**
     * cmt
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * cmt
     */
    public boolean checkPoint() {
        return true;
    }
}
