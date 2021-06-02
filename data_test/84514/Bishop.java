public class Bishop extends Piece {
    public Bishop() {

    }

    public Bishop(int x, int y) {
        super(x, y);
    }

   public Bishop(int x, int y, String color) {
        super(x, y, color);
   }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int distanceX = x - getCoordinatesX();
        int distanceY = y - getCoordinatesY();

        if (distanceX == distanceY || distanceX == -distanceY) {
            int stepX = distanceX < 0 ? -1 : 1;
            int stepY = distanceY < 0 ? -1 : 1;

            for (int i = 1; i < Math.abs(distanceX); i++) {
                if (board.getAt(getCoordinatesX() + i * stepX,
                        getCoordinatesY() + i * stepY) != null) {
                    return false;
                }
            }

            if (board.getAt(x, y) == null) {
                return true;
            } else if (board.getAt(x, y).getColor().equals(getColor()) == false) {
                return true;
            }

        }

        return false;
    }
}
