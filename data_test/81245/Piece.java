public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int coordinatesX, int coordinatesY) {
        if (1 <= coordinatesX && coordinatesX <= 8
                && 1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = "white";
        }
    }

    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (1 <= coordinatesX && coordinatesX <= 8
                && 1 <= coordinatesY && coordinatesY <= 8
                && (color.equals("white") || color.equals("black"))) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = color;
        }
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public boolean checkPosition(Piece piece) {
        return true;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        if (1 <= coordinatesX && coordinatesX <= 8) {
            this.coordinatesX = coordinatesX;
        }
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        if (1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesY = coordinatesY;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
