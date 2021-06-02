/**
 * Created by CCNE on 30/11/2020.
 */
public class Move {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * when there isn't killedPiece
     * @param startX coordinate
     * @param startY coordinate
     * @param endX coordinate
     * @param endY coordinate
     * @param movedPiece piece
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this(startX, startY, endX, endY, movedPiece);
        this.killedPiece = killedPiece;
    }

    @Override
    public String toString() {
        char column = (char)(endX - 1 + (int) 'a');
        return String.format("%s-%s%c%d"
                , movedPiece.getColor(), movedPiece.getSymbol(), column, endY);
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
