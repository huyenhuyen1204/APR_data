public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int desX, int desY) {
        /*for(Piece piece: board.getPieces()){
            if(piece.getCoordinatesX() != desX || piece.getCoordinatesY() != desY){

            }
            if(piece.getCoordinatesX() == desX && piece.getCoordinatesY() == desY) {
                if (Math.abs(this.getCoordinatesX() - desX) == Math.abs(this.getCoordinatesY() - desY)) {
                    return !piece.getColor().equals(this.getColor());
                }
            }
        }*/
        return true;
    }
}
