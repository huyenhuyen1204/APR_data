
public class Move {
    private Piece movePiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    public Move(int startX, int endX, int startY, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Move(Piece piece, int startX, int endX, int startY, int endY) {
        this.movePiece = piece;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movePiece = movedPiece;
    }

    @Override
    public String toString() {
        return movePiece.getColor()
                + "-" + movePiece.getSymbol()
                + (char) (movePiece.getCoordinatesX() - 1 + 'a')
                + movePiece.getCoordinatesY();
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public void setMovePiece(Piece movePiece) {
        this.movePiece = movePiece;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public Piece getMovePiece() {
        return movePiece;
    }

}
