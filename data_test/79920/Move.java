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
        return temp.getColor() + "-" + temp.getSymbol() + (char) (temp.getX() + 96) + temp.getY();
    }

    /** binhdang. */
    public int getStartX() {
        return startX;
    }

    /** binhdang. */
    public void setStartX(int x) {
        this.startX = x;
    }

    /** binhdang. */
    public int getEndX() {
        return endX;
    }

    /** binhdang. */
    public void setX(int x) {
        this.endX = x;
    }

    /** binhdang. */
    public int getStartY() {
        return startY;
    }

    /** binhdang. */
    public void setStartY(int y) {
        this.startY = y;
    }

    /** binhdang. */
    public int getEndY() {
        return endY;
    }

    /** binhdang. */
    public void setY(int y) {
        this.endY = y;
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
