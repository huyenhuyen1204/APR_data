public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**1.*/
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = "white";
    }

    /**1.*/
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**1.*/
    public int getX() {
        return x;
    }

    /**1.*/
    public void setX(int x) {
        this.x = x;
    }

    /**1.*/
    public int getY() {
        return y;
    }

    /**1.*/
    public void setY(int y) {
        this.y = y;
    }

    /**1.*/
    public String getColor() {
        return color;
    }

    /**1.*/
    public void setColor(String color) {
        this.color = color;
    }

    /**1.*/
    public abstract String getSymbol();

    /**1.*/
    public abstract boolean canMove(Board board, int x, int y);
}
