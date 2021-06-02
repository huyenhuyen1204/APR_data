public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;
    private String[] symbolAtX = {"a", "b", "c", "d", "e", "f", "g", "h"};

    /**
     * di chuyen.
     * @param startX x bat dau.
     * @param startY y bat dau.
     * @param endX x den.
     * @param endY y den.
     * @param movedPiece quan di chuyen.
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * di chuyen.
     * @param startX x bat dau.
     * @param startY y bat dau.
     * @param endX x den.
     * @param endY y den.
     * @param movedPiece quan di chuyen.
     * @param killedPiece quan bi ha.
     */
    public Move(int startX, int startY, int endX, int endY,
                Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
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

    @Override
    public String toString() {
        return movedPiece.getColor()
                + "-" + movedPiece.getSymbol()
                + symbolAtX[endX-1]
                + endY;
    }
}
