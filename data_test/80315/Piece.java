public abstract class Piece {

    private int x = 1;
    private int y = 1;
    private String color = "white";
    private boolean isRemove = false;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Piece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public boolean isRemove() {
        return isRemove;
    }

    public void setIsRemove(boolean remove) {
        isRemove = remove;
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

    public boolean checkPosition(Piece piece) {
        return piece.getX() >= 1 && piece.getX() <= 8
                && piece.getY() >= 1 && piece.getY() <= 8;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);
}
