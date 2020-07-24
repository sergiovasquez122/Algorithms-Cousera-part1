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
    }

    public Iterable<Board> neighbors(){

    }

    public Board twin(){

    }

    public static void main(String[] args) {

    }
}
