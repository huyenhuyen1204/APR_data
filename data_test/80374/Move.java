public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * @param startX     int.
     * @param endX       int.
     * @param startY     int.
     * @param endY       int.
     * @param movedPiece int.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * @param startX      int.
     * @param endX        int.
     * @param startY      int.
     * @param endY        int.
     * @param movedPiece  int.
     * @param killedPiece int.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public String toString() {
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + change(endX) + endY;
    }

    /**
     * @param x int.
     * @return int.
     */
    public String change(int x) {
        String s = "";
        switch (x) {
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
                s = "";
                break;
        }
        return s;
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
}