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

    public abstract String getSymbol();
    public abstract boolean canMove(Board board,int x, int y);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x <= 8 && x >= 1) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 1 && y <= 8) {
            this.y = y;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("white") || color.equals("black")) {
            this.color = color;
        }
    }

    public boolean checkPosition(Piece piece) {
        return false;
    }
}
