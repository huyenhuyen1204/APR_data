public class Move {
    private Piece movedPiece;
    private int startX, endX;
    private int startY, endY;
    private Piece killedPiece;

    /**3.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**3.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**3.*/
    @Override
    public String toString() {
        String s = null;
        switch (endX) {
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
        return "`" + this.movedPiece.getColor() + "-" + this.movedPiece.getSymbol()
                + s + this.endY + "`";
    }

    /**3.*/
    public int getStartX() {
        return startX;
    }

    /**3.*/
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**3.*/
    public int getEndX() {
        return endX;
    }

    /**3.*/
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**3.*/
    public int getStartY() {
        return startY;
    }

    /**3.*/
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**3.*/
    public int getEndY() {
        return endY;
    }

    /**3.*/
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**3.*/
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**3.*/
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**3.*/
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**3.*/
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
