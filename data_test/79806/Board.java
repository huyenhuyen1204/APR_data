import java.util.ArrayList;

public class Board {
    public static final int WIDTH=8;
    public static final int HEIGHT=8;
    private ArrayList<Piece> pieces;

    Board(){

    }

    public boolean validate(int x,int y){
        return (1<=x)&&(y<=8);
    }

    public void addPiece(Piece piece){
        int n=pieces.size();
        for(int i=0;i<n;i++){
            if(!pieces.get(i).checkPosition(piece))return;
        }
        pieces.add(piece);
    }

    public Piece getAt(int x,int y){
        int n=pieces.size();
        for(int i=0;i<n;i++){
            if(pieces.get(i).getX()==x && pieces.get(i).getY()==y){
                return pieces.get(i);
            }
        }
        return null;
    }

    public void removeAt(int x,int y){
        pieces.remove(this.getAt(x,y));
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}