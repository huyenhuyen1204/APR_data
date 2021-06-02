public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /** binhdang. */
    public Move(int startX, int endX, int startY, int endY, Piece moved, Piece killed) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = moved;
        this.killedPiece = killed;
    }

    /** binhdang. */
    public Move(int startX, int endX, int startY, int endY, Piece moved) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = moved;
    }

    /** binhdang. */
    public String toString() {
        Piece temp = movedPiece;
        return temp.getColor() + "-" + temp.getSymbol() + (char) (endX + 96) + endY;
    }

    /** binhdang. */
    public int getStartX() {
        return startX;
    }

    /** binhdang. */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /** binhdang. */
    public int getEndX() {
        return endX;
    }

    /** binhdang. */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /** binhdang. */
    public int getStartY() {
        return startY;
    }

    /** binhdang. */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /** binhdang. */
    public int getEndY() {
        return endY;
    }

    /** binhdang. */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /** binhdang. */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /** binhdang. */
    public void setKilledPiece(Piece temp) {
        this.killedPiece = temp;
    }

    /** binhdang. */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /** binhdang. */
    public void setMovedPiece(Piece temp) {
        this.movedPiece = temp;
    }
}
