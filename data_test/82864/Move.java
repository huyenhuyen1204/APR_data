public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * khoi tao lop di chuyen.
     * @param startX vi tri bat dau.
     * @param endX vi tri ket thuc x.
     * @param startY vi tri bat dau y.
     * @param endY vi tri ket thuc y.
     * @param movedPiece quan co di chuyen.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * khoi tao lop di chuyen.
     * @param startX vi tri bat dau.
     * @param endX vi tri ket thuc x.
     * @param startY vi tri bat dau y.
     * @param endY vi tri ket thuc y.
     * @param movedPiece quan co di chuyen.
     * @param killedPiece quan co bi giet.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public String toString() {
        char x = (char) (endX + 47 + 49);
        return String.format("%s-%s%s%s", movedPiece.getColor(), movedPiece.getSymbol(), x, endY);
    }
}
