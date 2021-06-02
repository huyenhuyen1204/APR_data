public abstract class Piece {
    private int x;
    private int y;
    private String color;

    /**h hu.*/
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = "white";
    }

    /**hu hu.*/
    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**hu hu.*/
    public abstract String getSymbol();

    /**hu hu.*/
    public abstract boolean canMove(Board board, int x, int y);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean checkPosition(Piece p) {
        return true;
    }
}
