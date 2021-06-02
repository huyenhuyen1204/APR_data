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
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
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
        this.color = color;
    }

    public String algebraicNotation() {
       if (getCoordinatesX() == 1) {
           return "a";
       } else if (getCoordinatesX() == 2) {
           return "b";
       } else if (getCoordinatesX() == 3) {
           return "c";
       } else if (getCoordinatesX() == 4) {
           return "d";
       } else if (getCoordinatesX() == 5) {
           return "e";
       } else if (getCoordinatesX() == 6) {
           return "f";
       } else if (getCoordinatesX() == 7) {
           return "g";
       }
       return "h";
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);


}
