public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**uyds.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
        this.movedPiece = movedPiece;
    }

    /**uyds.*/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**uyds.*/
    public int getStartX() {
        return startX;
    }

    /**uyds.*/
    public int getStartY() {
        return startY;
    }

    /**uyds.*/
    public int getEndX() {
        return endX;
    }

    /**uyds.*/
    public int getEndY() {
        return endY;
    }

    /**uyds.*/
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**uyds.*/
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**uyds.*/
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**uyds.*/
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**uyds.*/
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**uyds.*/
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**uyds.*/
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**uyds.*/
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**uyds.*/
    public String toString() {
        String s = "";
        s += movedPiece.getColor() + "-";
        s += movedPiece.getSymbol();
        switch (killedPiece.getX()) {
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
        }
        s += killedPiece.getY();
        return s;
    }
}
