public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * constructor with 5 parameters.
     * @param startX coordinates start x.
     * @param endX coordinates end x.
     * @param startY coordinates start y.
     * @param endY coordinates end y.
     * @param movedPiece piece moved.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * constructor with 6 parameters.
     * @param startX coordinates start x.
     * @param endX coordinates end x.
     * @param startY coordinates start y.
     * @param endY coordinates end y.
     * @param movedPiece piece moved.
     * @param killedPiece piece killed.
     */
    public Move(int startX, int endX, int startY, int endY,
                Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
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

    /**
     * get information of object move.
     * @return a string.
     */
    public String toString() {
        return this.movedPiece.getColor() + "-"
                + this.movedPiece.getSymbol()
                + (char) (96 + this.endX) + this.endY;
    }

}
