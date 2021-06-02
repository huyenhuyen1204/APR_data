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
        if (piece.canMove(this.board, x, y)) {
            int startX = piece.getCoordinatesX();
            int startY = piece.getCoordinatesY();

            Piece res = this.board.getAt(x, y);
            if (res != null) {
                Move movePiece = new Move(startX, x, startY, y, piece, res);
                moveHistory.add(movePiece);
                this.board.removeAt(x, y);

            } else {
                Move movePiece = new Move(startX, x, startY, y, piece);
                moveHistory.add(movePiece);

            }

            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);

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
