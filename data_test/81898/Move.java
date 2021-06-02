public class Move {
    private Piece movedPiece;
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece killedPiece;

    /**
     * fsdfsd.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * fsdfsd.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * fsdfsd.
     * @return
     */
    public String toString() {
        char codinateX = (char) (this.endX - 1 + 'a');
        char codinateY = (char) (this.endY + '0');
        String origin = movedPiece.getColor() + "-" + movedPiece.getSymbol();
        return origin + codinateX + codinateY;
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

    public int getStartX() {
        return startX;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public int getStartY() {
        return startY;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }
    
    public void setStartX(int startX) {
        this.startX = startX;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

}
