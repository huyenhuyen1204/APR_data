import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<Move>();
    }

    /** Make a piece move. **/
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            boolean killed = false;
            for (Piece p : board.getPieces()) {
                if (p.getCoordinatesX() == x && p.getCoordinatesY() == y && p.getColor() != piece.getColor()) {
                    moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece, p));
                    this.board.removeAt(x, y);
                    killed = true;
                    break;
                }
            }
            if (!killed) {
                moveHistory.add(new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece));
            }
            this.board.movePiece(piece, x, y);
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

    /** This is my try out for all the functions. **/
    public static void main(String[] args) {
        Game game = new Game(new Board());
        Rook r1 = new Rook(2, 3, "white");
        Rook r2 = new Rook(2, 6, "black");
        game.board.addPiece(r1);
        game.board.addPiece(r2);
        for (Piece p : game.board.getPieces()) {
            System.out.println(p.getColor() + p.getSymbol() + p.getCoordinatesX() + p.getCoordinatesY());
        }
        game.movePiece(r1, 2, 6);
        for (Move m : game.moveHistory) {
            System.out.println(m.toString());
        }
        for (Piece p : game.board.getPieces()) {
            System.out.println(p.getColor() + p.getSymbol() + p.getCoordinatesX() + p.getCoordinatesY());
        }
    }
}
