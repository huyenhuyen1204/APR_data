public class Move {
    private Piece movedPiece;
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Piece killedPiece;

    /** Khoi tao 5 tham so. **/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /** Khoi tao 6 tham so. **/
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /** Lay quan co di chuyen. **/
    public Piece getMovedPiece() {
        return movedPiece;
    }

    /** Tao quan co di chuyen. **/
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    /** Lay diem dau x. **/
    public int getStartX() {
        return startX;
    }

    /** Tao diem dau x. **/
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /** Lay diem cuoi x. **/
    public int getEndX() {
        return endX;
    }

    /** Tao diem cuoi x. **/
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /** Lay diem dau y. **/
    public int getStartY() {
        return startY;
    }

    /** Tao diem dau y. **/
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /** Lay diem cuoi y. **/
    public int getEndY() {
        return endY;
    }

    /** Tao diem cuoi y. **/
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /** Lay quan co bi diet. **/
    public Piece getKilledPiece() {
        return killedPiece;
    }

    /** Tao quan co bi diet. **/
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    /** Lay thong tin. **/
    public String toString() {
        String a = "";
        if (endX == 1) {
            a = "a";
        } else {
            if (endX == 2) {
                a = "b";
            } else {
                if (endX == 3) {
                    a = "c";
                } else {
                    if (endX == 4) {
                        a = " d";
                    } else {
                        if (endX == 5) {
                            a = "e";
                        } else {
                            if (endX == 6) {
                                a = "f";
                            } else {
                                if (endX == 7) {
                                    a = "g";
                                } else {
                                    if (endX == 8) {
                                        a = "h";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return movedPiece.getColor()
                + "-" + movedPiece.getSymbol()
                + a + endY;
    }
}