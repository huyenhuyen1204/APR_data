public class Move {
   private Piece movePiece;
   private Piece killedPiece;
   private int startX, endX, startY, endY;

    public Move(int startX, int endX, int startY, int endY, Piece movePiece) {
        this.movePiece = movePiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public Move(int startX, int endX, int startY, int endY, Piece movePiece, Piece killedPiece) {
        this.movePiece = movePiece;
        this.killedPiece = killedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public Piece getMovePiece() {
        return movePiece;
    }

    public void setMovePiece(Piece movePiece) {
        this.movePiece = movePiece;
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
        String s = "";
        return s;
    }
}
