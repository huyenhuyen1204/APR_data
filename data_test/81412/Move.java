public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * .
     *
     * @param startX     .
     * @param endX       .
     * @param startY     .
     * @param endY       .
     * @param movedPiece .
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * .
     *
     * @param startX      .
     * @param endX        .
     * @param startY      .
     * @param endY        .
     * @param movedPiece  .
     * @param killedPiece .
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
     * .
     *
     * @return .
     */
    public String toString() {
        StringBuffer s = new StringBuffer(movedPiece.getColor());
        s.append("-");
        s.append(movedPiece.getSymbol());
        s.append((char) (movedPiece.getCoordinatesX() - 1 + 'a'));
        s.append(movedPiece.getCoordinatesY());
        return new String(s);
    }

    /**
     * .
     *
     * @return .
     */
    public int getStartX() {
        return startX;
    }

    /**
     * .
     *
     * @param startX .
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * .
     *
     * @return .
     */
    public int getEndX() {
        return endX;
    }

    /**
     * .
     *
     * @param endX .
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * .
     *
     * @return .
     */
    public int getStartY() {
        return startY;
    }

    /**
     * .
     *
     * @param startY .
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * .
     *
     * @return .
     */
    public int getEndY() {
        return endY;
    }

    /**
     * .
     *
     * @param endY .
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * .
     *
     * @return .
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * .
     *
     * @param movedPiece .
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * .
     *
     * @return .
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * .
     *
     * @param killedPiece .
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
