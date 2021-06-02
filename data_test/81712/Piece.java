/**
 * Created by CCNE on 30/11/2020.
 */
public abstract class Piece {

    private int coordinatesX;
    private int coordinatesY;
    private String color;

    private static final String WHITE = "white";
    private static final String BLACK = "black";

    /**
     * .
     * @param coordinatesX int
     * @param coordinatesY int
     * @param color String
     */
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

    /**
     * .
     * @param color String
     */
    public void setColor(String color) {
        if (color.equals(WHITE)) {
            color = WHITE;
        } else if (color.equals(BLACK)) {
            color = BLACK;
        }
    }

    /**
     * .
     * @param that piece
     * @return whether thit and that piece has the same position
     */
    public boolean checkPosition(Piece that) {
        boolean con1 = this.coordinatesX == that.coordinatesX;
        boolean con2 = this.coordinatesY == that.coordinatesY;
        return con1 && con2;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);
}
