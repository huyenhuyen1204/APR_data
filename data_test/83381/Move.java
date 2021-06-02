public class Move {
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Constructor.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movesPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movesPiece;
    }

    /**
     * Constructor 2.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movesPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movesPiece;
        this.killedPiece = killedPiece;
    }

    @Override
    public String toString() {
        return "`" + movedPiece.getColor() + " - " + movedPiece.getSymbol() + "`"
                + " : Quân cờ **Xe** trắng di chuyển tới vị trí cột "
                + this.endY + " hàng " + this.endX + " tương ứng với `(x=" + this.endX + ", y=" + this.endY + ")`";
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

    public Piece getMovesPiece() {
        return movedPiece;
    }

    public void setMovesPiece(Piece movesPiece) {
        this.movedPiece = movesPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
