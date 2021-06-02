import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<Move>();
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(this.board, x, y)) {
            boolean killed = false;
            for (Piece p : board.getPieces()) {
                if (p.getX() == x && p.getY() == y && p.getColor() != piece.getColor()) {
                    moveHistory.add(new Move(piece.getX(), x, piece.getY(), y, piece, p));
                    killed = true;
                    break;
                }
            }
            if (!killed) {
                moveHistory.add(new Move(piece.getX(), x, piece.getY(), y, piece));
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

    public static void main(String[] args) {
        Game game = new Game(new Board());
        Rook r1 = new Rook(1, 1, "white");
        Rook r2 = new Rook(1, 7, "black");
        game.board.addPiece(r1);
        game.board.addPiece(r2);
        game.moveHistory.add(new Move(1, 1, 1, 8, r1));
        game.movePiece(r1, 1, 8);
        for (Move m : game.moveHistory) {
            System.out.println(m.toString());
        }
    }
}
