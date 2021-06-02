public class Move {
    private Piece movedPiece;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;

    /**
     * abc.
     */
    public Move(int startX, int endX, int startY, int endY,
                Piece movedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
        this.movedPiece = movedPiece;
        this.killedPiece = null;
    }

    /**
     * abc.
     */
    public Move(int startX, int endX, int startY, int endY,
                Piece movedPiece, Piece killedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /** abc. */
    public String getAlNotation(int x, int y) {
        String ans = "";
        switch (x) {
            case 1:
                ans += "a";
                break;
            case 2:
                ans += "b";
                break;
            case 3:
                ans += "c";
                break;
            case 4:
                ans += "d";
                break;
            case 5:
                ans += "e";
                break;
            case 6:
                ans += "f";
                break;
            case 7:
                ans += "g";
                break;
            case 8:
                ans += "h";
                break;
            default:
                break;
        }
        ans += y;

        return ans;
    }

    /** abc. */
    @Override
    public String toString() {
        return getMovedPiece().getColor()
                + '-'
                + movedPiece.getSymbol()
                + getAlNotation(endX, endY);
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
}
