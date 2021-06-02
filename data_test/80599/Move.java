public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Hello, this is me ure looking for.
     */
    public Move(int firstX, int secX, int firstY, int secY, Piece moved) {
        startX = firstX;
        startY = firstY;
        endX = secX;
        endY = secY;
        movedPiece = moved;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Move(int firstX, int secX, int firstY, int secY, Piece moved, Piece killed) {
        startX = firstX;
        startY = firstY;
        endX = secX;
        endY = secY;
        movedPiece = moved;
        killedPiece = killed;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public String toString() {
        return movedPiece.getColor() + '-' + movedPiece.getSymbol()
                + (char)(movedPiece.getCoordinatesX() - 1 + 'a') + movedPiece.getCoordinatesY();
    }

    /**
     * Hello, this is me ure looking for.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * Hello, this is me ure looking for.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
