

import java.util.Objects;

public abstract class Piece {

    private Board board;
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
        color = "white";
    }

    public Piece(int x, int y, String color) {
        coordinatesX = x;
        coordinatesY = y;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return coordinatesX == piece.coordinatesX &&
                coordinatesY == piece.coordinatesY &&
                Objects.equals(color, piece.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinatesX, coordinatesY, color);
    }

    @Override
    public String toString() {
        return "coordinatesX=" + coordinatesX +
                ", coordinatesY=" + coordinatesY +
                ", color='" + color + '\'' +
                '}';
    }
}
