public class Test {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        Bishop bi1 = new Bishop(2, 2, "white");
        Bishop bi2 = new Bishop(7, 7, "black");
        board.addPiece(bi1);
        board.addPiece(bi2);
        //board.removeAt(7, 7);
        game.movePiece(bi1, 7, 7);
        /*for(Piece piece: board.getPieces()){
            System.out.println(piece.getCoordinatesX());
        }*/
        for(Move move: game.getMoveHistory()){
            System.out.println(move.getStartX() + " " + move.getEndX() + " " + move.getMovedPiece().getColor() + " " + move.getKilledPiece().getColor());
        }
    }
}
