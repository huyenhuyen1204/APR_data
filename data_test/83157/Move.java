public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;
    /**....*/

    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.startY = startY;
    }
    /**....*/

    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.startY = startY;
        this.killedPiece = killedPiece;
    }

    @Override
    public String toString() {
        char a;
        switch (endX) {
            case 1:
                a = 'a';
                break;
            case 2:
                a = 'b';
                break;
            case 3:
                a = 'c';
                break;
            case 4:
                a = 'd';
                break;
            case 5:
                a = 'e';
                break;
            case 6:
                a = 'f';
                break;
            case 7:
                a = 'g';
                break;
            default:
                a = 'h';
                break;
        }
        return movedPiece.getColor() + "-" + movedPiece.getSymbol() + a + endY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

}
