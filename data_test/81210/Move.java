
public class Move {
    private int startX;
    private int startY;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
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

    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Author.
     * Thuan
     * Trinh Van Thuan
     */
    public Move(int sx, int ex, int sy, int ey, Piece mp) {
        this.startX = sx;
        this.startY = sy;
        this.endX = ex;
        this.endY = ey;
        this.movedPiece = mp;
    }

    /**
     * Author.
     * Thuan
     * Trinh Van Thuan
     */
    public Move(int sx, int ex, int sy, int ey, Piece mp, Piece kp) {
        this.startX = sx;
        this.startY = sy;
        this.endX = ex;
        this.endY = ey;
        this.movedPiece = mp;
        this.killedPiece = kp;
    }

    /**
     * Author.
     * Thuan
     * Trinh Van Thuan
     */
    public String toString() {
        return movedPiece.getColor() + '-' + movedPiece.getSymbol()
                + (char) (endX - 1 + 'a') + endY;
    }

}