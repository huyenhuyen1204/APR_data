
public class Move {
    private int startX;
    private int startY;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    public Move(int sX, int sY, int eX, int eY, Piece mP) {
        this.startX = sX;
        this.startY = sY;
        this.endX = eX;
        this.endY = eY;
        this.movedPiece = mP;
    }

    public Move(int sX, int sY, int eX, int eY, Piece mP, Piece kP) {
        this.startX = sX;
        this.startY = sY;
        this.endX = eX;
        this.endY = eY;
        this.movedPiece = mP;
        this.killedPiece = kP;
    }

    public String toString() {
        char signal = 'a';
        switch (movedPiece.getCoordinatesX()) {
            case 1:
                signal = 'a';
                break;
            case 2:
                signal = 'b';
                break;
            case 3:
                signal = 'c';
                break;
            case 4:
                signal = 'd';
                break;
            case 5:
                signal = 'e';
                break;
            case 6:
                signal = 'f';
                break;
            case 7:
                signal = 'g';
                break;
            case 8:
                signal = 'h';
                break;
            default:
                break;
        }
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + signal + movedPiece.getCoordinatesY();
    }

}