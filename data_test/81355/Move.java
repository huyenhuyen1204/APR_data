public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * constructor1.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * constructor2.
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
     * toString.
     * @return move information
     */
    public String toString() {
        char column = (char) ('a' + (endX - 1));
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + column + endY;
    }

    /**
     * getStartX.
     * @return startX
     */
    public int getStartX() {
        return startX;
    }

    /**
     * setStartX.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * getStartY.
     * @return startY
     */
    public int getStartY() {
        return startY;
    }

    /**
     * setStartY.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * getEndX.
     * @return endX
     */
    public int getEndX() {
        return endX;
    }

    /**
     * setEndX.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * getEndY.
     * @return endY
     */
    public int getEndY() {
        return endY;
    }

    /**
     * setEndY.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * getMovedPiece.
     * @return movedPiece
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * setMovedPiece.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * getKilledPiece.
     * @return killedPiece
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * setKilledPiece.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
