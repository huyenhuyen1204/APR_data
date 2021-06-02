public abstract class Piece {

    private int x;
    private int y;
    private String color;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = "white";
    }

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

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public boolean checkPosition(Piece piece) {
        if (x == piece.getX() && y == piece.getY()) {
            return false;
        } else {
            return true;
        }
    }

}
