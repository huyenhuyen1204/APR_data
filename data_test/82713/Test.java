public class Test {
    public static void main(String[] args) {
        Board board = new Board();
        Bishop bi = new Bishop(2, 2, "black");
        System.out.println(bi.canMove(board, 3, 3));
    }
}
