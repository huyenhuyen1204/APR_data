import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * move piece.
     * @param piece piece.
     * @param x coordinates x.
     * @param y coordinates y.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece instanceof Rook) {
            Rook rook = (Rook) piece;
            if (rook.canMove(this.board, x, y)) {
                int startX = piece.getCoordinatesX();
                int startY = piece.getCoordinatesY();

                if (board.mapPieces.containsKey(x + ";" + y)) {
                    Piece value = board.mapPieces.get(x + ";" + y);
                    Move movePiece = new Move(startX, x, startY, y, rook, value);
                    moveHistory.add(movePiece);
                    this.board.removeAt(x, y);

                } else {
                    Move movePiece = new Move(startX, x, startY, y, rook);
                    moveHistory.add(movePiece);

                }

                this.board.mapPieces.remove(startX + ";" + startY);
                rook.setCoordinatesX(x);
                rook.setCoordinatesY(y);
                this.board.mapPieces.put(x + ";" + y, rook);

            }
        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

}
