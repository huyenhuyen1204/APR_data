import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board = new Board();

    private ArrayList<Move> moveHistory = new ArrayList<Move>();

    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                Piece p = board.getAt(x, y);
                Move move1 = new Move(piece.getX(), x, piece.getY(), y, piece, p);
                moveHistory.add(move1);
                board.removeAt(x, y);
            }
            else {
                Move move = new Move(piece.getX(), x, piece.getY(), y, piece);
                moveHistory.add(move);
            }
            piece.setX(x);
            piece.setY(y);
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
        Game game = new Game(new Board());
        Rook r = new Rook(2, 6);
        Rook r1 = new Rook(2, 5);
        r1.setColor("black");
        game.board.addPiece(r);
        game.board.addPiece(r1);
        game.movePiece(r1, 2 , 6);
        System.out.println(game.moveHistory);
    }
}

