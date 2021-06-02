public class Move {
    private Piece movedPiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    /**
     * Javadoc Comment.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * Javadoc Comment.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * Javadoc Comment.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Javadoc Comment.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Javadoc Comment.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Javadoc Comment.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Javadoc Comment.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Javadoc Comment.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Javadoc Comment.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Javadoc Comment.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Javadoc Comment.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * Javadoc Comment.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * Javadoc Comment.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Javadoc Comment.
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
     * Javadoc Comment.
     */
    public String toString() {
        String color = movedPiece.getColor();
        char endX = (char) this.endX;
        endX += 'a';
        return color + "-" + movedPiece.getSymbol() + String.valueOf(endX) + endY;
    }
}
