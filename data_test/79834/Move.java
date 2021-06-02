public class Move {
    private Piece movedPiece;
    private Piece killedPiece;

    private int startX, endX, startY, endY;

    /**
     * javadoc.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * javadoc.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * javadoc.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * javadoc.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * javadoc.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * javadoc.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * javadoc.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * javadoc.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * javadoc.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * javadoc.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * javadoc.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * javadoc.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * javadoc.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * javadoc.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * javadoc.
     */
    public String toString() {
        char ch = (char) (movedPiece.getX() + 96);
        String result = String.valueOf(ch) + String.valueOf(movedPiece.getY());
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + result;
    }
}
