public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**uyds.*/
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        color = "white";
    }

    /**uyds.*/
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**uyds.*/
    public int getX() {
        return x;
    }

    /**uyds.*/
    public int getY() {
        return y;
    }

    /**uyds.*/
    public void setX(int x) {
        this.x = x;
    }

    /**uyds.*/
    public void setY(int y) {
        this.y = y;
    }

    /**uyds.*/
    public String getColor() {
        return color;
    }

    /**uyds.*/
    public void setColor(String color) {
        this.color = color;
    }

    /**uyds.*/
    public abstract String getSymbol();

    /**uyds.*/
    public abstract boolean canMove(Board board, int x, int y);
}
