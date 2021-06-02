/**
 * Created by CCNE on 19/11/2020.
 */
public class Move {
    private Piece movedPiece;
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece killedPiece;

    /**
     * Loan .
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    /**
     * Loan .
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.movedPiece = movedPiece;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.killedPiece = killedPiece;
    }

    /**
     * Loan .
     */
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /**
     * Loan .
     */
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /**
     * Loan .
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Loan .
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Loan .
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Loan .
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Loan .
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Loan .
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Loan .
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Loan .
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Loan .
     */
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /**
     * Loan .
     */
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /**
     * Loan .
     */
    public String toString() {
        String res = movedPiece.getColor() + "-" + movedPiece.getSymbol();
        res += (char) (endX + 96) + endY;
        return res;
    }

}
