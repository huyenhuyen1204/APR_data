public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**hu hu.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.startY = startY;
        this.killedPiece = null;
    }

    /**hu hu.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startY = startY;
        this.startX = startX;
        this.movedPiece = movedPiece;
        this.endY = endY;
        this.endX = endX;
        this.killedPiece = killedPiece;
    }

    /**hu hu.*/
    public String toString() {
        String s = movedPiece.getColor() + '-' + movedPiece.getSymbol();
        switch (endX) {
            case 1:
                s += 'a';
                break;
            case 2:
                s += 'b';
                break;
            case 3:
                s += 'c';
                break;
            case 4:
                s += 'd';
                break;
            case 5:
                s += 'e';
                break;
            case 6:
                s += 'f';
                break;
            case 7:
                s += 'g';
                break;
            case 8:
                s += 'h';
                break;
            default:
                break;
        }
        s += endY;
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
