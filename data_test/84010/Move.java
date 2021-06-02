public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Ham khoi tao 5 tham so.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Ham khoi tao 7 tham so.
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
     * cmt.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * cmt.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * cmt.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * cmt.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * cmt.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * cmt.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * cmt.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * cmt.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * cmt.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * cmt.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * cmt.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * cmt.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * cmt.
     */
    @Override
    public String toString() {
        char init = (char) (endX + 96);
        String s = String.valueOf(init);
        s += String.valueOf(endY);
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + s;
    }
}

