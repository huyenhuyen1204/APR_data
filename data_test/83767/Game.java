import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Constructor.
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * move piece.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move m = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                     x, y, piece);
            moveHistory.add(m);
            int diffX = x - piece.getCoordinatesX();
            int diffY = y - piece.getCoordinatesY();

            if (diffX > 0) {
                piece.setCoordinatesX(piece.getCoordinatesX() + diffX);
            } else {
                piece.setCoordinatesX(piece.getCoordinatesX() - diffX);
            }

            if (diffY > 0) {
                piece.setCoordinatesY(piece.getCoordinatesY() + diffY);
            } else {
                piece.setCoordinatesY(piece.getCoordinatesY() - diffY);
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

    public void setMoveHistory(ArrayList<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public static void main(String[] args) {
        Piece p = new Rook(1, 2);
        Piece p1 = new Rook(2, 5);
        Piece p3 = new Rook(5, 1, "black");
        Piece p2 = new Rook(2, 2);
        Piece p4 = new Rook(2, 5, "black");
        Board b = new Board();
        b.addPiece(p);
        System.out.println(b.getPieces().size());

        b.addPiece(p1);
        System.out.println(b.getPieces().size());

        b.addPiece(p2);
        System.out.println(b.getPieces().size());

        b.addPiece(p3);
        System.out.println(b.getPieces().size());

        b.addPiece(p4);
        System.out.println(b.getPieces().size());

        System.out.println(p.canMove(b, 2, 2));
        //System.out.println(p.canMove(b, ));
        System.out.println();
    }
}
