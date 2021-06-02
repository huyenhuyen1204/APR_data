public class Move {
   private Piece movedPiece;
   private Piece killedPiece;
   private int startX;
   private int endX;
   private int startY;
   private int endY;

    /**
     * ham.
     * @param startX ham.
     * @param endX ham.
     * @param startY ham.
     * @param endY ham.
     * @param movedPiece ham.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    /**
     * ham.
     * @param startX ham.
     * @param endX ham.
     * @param startY ham.
     * @param endY ham.
     * @param movedPiece ham.
     * @param killedPiece ham.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
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

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public String toString() {
        String a = "";
        switch (this.getMovedPiece().getCoordinatesX()) {
            case 1:
                a = "a";
                break;
            case 2:
                a = "b";
                break;
            case 3:
                a = "c";
                break;
            case 4:
                a = "d";
                break;
            case 5:
                a = "e";
                break;
            case 6:
                a = "f";
                break;
            case 7:
                a = "g";
                break;
            case 8:
                a = "h";
                break;
        }
        String s = this.getMovedPiece().getColor() + "-R" + a + this.getMovedPiece().getCoordinatesY();
        return s;
    }
}
