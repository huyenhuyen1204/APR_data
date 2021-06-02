/**
 * Created by CCNE on 30/11/2020.
 */
public abstract class Piece {

    private int coordinatesX;
    private int coordinatesY;
    private String color;

    private static final String WHITE = "white";
    private static final String BLACK = "black";

    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    public Piece(int coordinatesX, int coordinatesY) {
        this(coordinatesX, coordinatesY, WHITE);
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
            this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
            this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals(WHITE)) {
            color = WHITE;
        } else if (color.equals(BLACK)) {
            color = BLACK;
        }
    }

    public boolean checkPosition(Piece that) {
        boolean con1 = this.coordinatesX == that.coordinatesX;
        boolean con2 = this.coordinatesY == that.coordinatesY;
        return con1 && con2;
    }

    abstract public String getSymbol();
    abstract public boolean canMove(Board board, int x, int y);
}
