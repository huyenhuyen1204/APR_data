public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    public Piece(int coordinatesX, int coordinatesY, String color) {
        this(coordinatesX, coordinatesY);
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public String getColor() {
        return color;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean checkPosition(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}
