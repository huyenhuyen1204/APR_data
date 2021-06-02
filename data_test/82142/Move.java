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

    /**
     * ham.
     * @return ham.
     */
    public String toString() {
        String a = "";
        int b = this.getMovedPiece().getCoordinatesX();
        if (b == 1) {
            a = "a";
        } else if (b == 2) {
            a = "b";
        } else if (b == 3) {
            a = "c";
        } else if (b == 4) {
            a = "d";
        } else if (b == 5) {
            a = "e";
        } else if (b == 6) {
            a = "f";
        } else if (b == 7) {
            a = "g";
        } else if (b == 8) {
            a = "h";
        }
        String s = this.getMovedPiece().getColor() + "-R"
                + a + this.getMovedPiece().getCoordinatesY();
        return s;
    }
}
