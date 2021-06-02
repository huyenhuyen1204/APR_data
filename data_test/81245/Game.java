import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece instanceof Rook) {
            Rook rook = (Rook) piece;
            if (rook.canMove(this.board, x, y)) {
                int startX = piece.getCoordinatesX();
                int startY = piece.getCoordinatesY();

                Piece value = board.mapPieces.get(x + ";" + y);
                if (value != null) {
                    Move movePiece = new Move(startX, x, startY, y, piece, value);
                    moveHistory.add(movePiece);
                    this.board.removeAt(x, y);
                    this.board.addPiece(piece);
                    return;
                }

                Move movePiece = new Move(startX, x, startY, y, piece);
                moveHistory.add(movePiece);
                this.board.removeAt(x, y);
                this.board.addPiece(piece);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
