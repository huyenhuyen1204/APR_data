public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * move.
     * @param startX x
     * @param endX x
     * @param startY y
     * @param endY y
     * @param movedPiece move
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * move.
     * @param startX x
     * @param endX x
     * @param startY y
     * @param endY y
     * @param movedPiece move
     * @param killedPiece killed
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
     * to string.
     * @return string
     */
    public String toString() {
        String s = new String();
        switch (this.endX) {
            case 1:
                s = "a";
                break;
            case 2:
                s = "b";
                break;
            case 3:
                s = "c";
                break;
            case 4:
                s = "d";
                break;
            case 5:
                s = "e";
                break;
            case 6:
                s = "f";
                break;
            case 7:
                s = "g";
                break;
            case 8:
                s = "h";
                break;
            default:
                break;
        }
        return String.format(movedPiece.getColor() + '-'
                + movedPiece.getSymbol() + s + startY);
    }

    public int getStartX() {
        return this.startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return this.endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getStartY() {
        return this.startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndY() {
        return this.endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return this.killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
 