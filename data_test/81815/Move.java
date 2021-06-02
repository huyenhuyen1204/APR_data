public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece killedPiece;
    private Piece movedPiece;

    Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    @Override
    public String toString() {
        String word = new String();
        switch (this.getEndX()) {
            case 1:
                word = "a";
                break;
            case 2:
                word = "b";
                break;
            case 3:
                word = "c";
                break;
            case 4:
                word = "d";
                break;
            case 5:
                word = "e";
                break;
            case 6:
                word = "f";
                break;
            case 7:
                word = "g";
                break;
            case 8:
                word = "h";
                break;
            default:
                //do nothing
        }
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + word + String.valueOf(endY);
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
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
