import java.util.Arrays;

public class Board {

    private int hamming;
    private int manhattan;
    private int[][] board;

    public Board(int[][] tiles){

    }

    public String toString(){

    }

    public int dimensions(){
        return board.length;
    }

    public int hamming(){
        return hamming;
    }

    public int manhattan(){
        return manhattan;
    }

    public boolean isGoal(){
        return hamming == 0;
    }

    public boolean equal(Object y){
        if(y == this){
            return true;
        }

        if(y == null){
            return false;
        }

        if(y.getClass() != this.getClass()){
            return false;
        }
        Board b = (Board) y;
        return Arrays.deepEquals(board, b.board);
    }

    public Iterable<Board> neighbors(){
        return null;
    }

    public Board twin(){
        return null;
    }

    public static void main(String[] args) {

    }
}
