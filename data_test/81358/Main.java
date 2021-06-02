public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        Rook rook1 = new Rook(2, 3, "white");
        Rook rook2 = new Rook(2, 5, "black");
        board.addPiece(rook1);
        board.addPiece(rook2);

        for (int i = 0; i < board.getPieces().size(); i++) {
            System.out.println(board.getPieces().get(i));
        }

        game.movePiece(rook1, 2, 5);

        System.out.println("--------------");
        for (int i = 0; i < board.getPieces().size(); i++) {
            System.out.println(board.getPieces().get(i));
        }

        for (int i = 0; i < game.getMoveHistory().size(); i++) {
            System.out.println(game.getMoveHistory().get(i));
        }
    }
}
