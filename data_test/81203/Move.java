public class Move {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;
    private Piece movedPiece;

    /**
     * iloveyou.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * iloveyou.
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
     * fdgkjs.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * djhgsjd.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * fjdshf.
     */
    public int getStartX() {
        return startX;
    }

    /**
     * fgjds.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * jdhfjfgsd.
     */
    public int getStartY() {
        return startY;
    }

    /**
     * fjdshfgs.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * hdsafsa.
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * fsjhdfa.
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * ksdjf.
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * fjsfhf.
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * vsdhfgsk.
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * fdsfbjs.
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * hghgfh.
     */
    @Override
    public String toString() {
        String ans = movedPiece.getColor() + "-" + movedPiece.getSymbol();
        char add0 = (char) (this.endX - 1 + 'a');
        char add1 = (char) (this.endY + '0');
        return ans + add0 + add1;
    }
}
