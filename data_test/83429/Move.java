public class Move {
    private Piece movedPiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    /**
     * alo.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * alo.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * alo.
     */
    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * alo.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * alo.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * alo.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * alo.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * alo.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * alo.
     */

    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * alo.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * alo.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * alo.
     */

    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * alo.
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
     * alo.
     */

    public String toString() {
        int col = endX + 96;
        return movedPiece.getColor() + "-" + movedPiece.getSymbol()
                + (char) col + endY;
    }
}
