public class Move {
    private Piece movedPiece;
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece killedPiece;

    /**
     * con.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    /**
     * con.
     */
    public Move(int startX, int endX, int startY, int endY, Piece killedPiece, Piece movedPiece) {
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.killedPiece = killedPiece;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
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

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    @Override
    public String toString() {
        String tmp;
        if (killedPiece == null) {
            tmp = movedPiece.getColor();
        } else {
            tmp = killedPiece.getColor();
        }
        tmp += "-" + movedPiece.getSymbol();

        char c = (char) ('a' + (endX - 1));
        tmp = tmp + c + endY;

        return tmp;
    }
}
