import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Board {

    private int hamming;
    private int manhattan;
    private int[][] board;

    public Board(int[][] tiles){
        board = new int[tiles.length][tiles.length];
        for(int i = 0;i < tiles.length;++i){
            System.arraycopy(tiles[i], 0, board[i], 0, board.length);
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(board.length);
        result.append(System.lineSeparator());
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board.length;++j){
                result.append(" ");
                result.append(board[i][j]);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
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
        int arr[][] = {{0, 1}, {2, 3}};
        Board b = new Board(arr);
        StdOut.println(b);
    }
}
