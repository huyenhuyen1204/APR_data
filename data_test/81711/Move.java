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
        String xWord = new String();
        switch (this.getEndX()) {
            case 1:
                xWord = "a";
            case 2:
                xWord = "b";
            case 3:
                xWord = "c";
            case 4:
                xWord = "d";
            case 5:
                xWord = "e";
            case 6:
                xWord = "f";
            case 7:
                xWord = "g";
                System.out.println("777777");
            case 8:
                xWord = "h";
                System.out.println("8888888");
            default:
                //do nothing
        }
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + xWord + String.valueOf(endY);
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
