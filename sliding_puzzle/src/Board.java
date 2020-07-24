import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Board {

    private int hamming = 0;
    private int manhattan = 0;
    private int[][] board;

    public Board(int[][] tiles){
        board = new int[tiles.length][tiles.length];
        for(int i = 0;i < tiles.length;++i){
            System.arraycopy(tiles[i], 0, board[i], 0, board.length);
        }

        computeHamming();
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

    private boolean isValid(int x, int y){
        return 0 <= x && x < board.length && 0 <= y && y < board.length;
    }

    private void swap(int x1, int y1, int x2, int y2){
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private int findZeroPosition(){
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board.length;++j){
                if(board[i][j] == 0){
                    return i * board.length + j + 1;
                }
            }
        }
        // (i - 1) * N + 1
        return -1;
    }

    public Iterable<Board> neighbors(){
        int zero_pos = findZeroPosition();
        Queue<Board> neighbors = new Queue<>();
        int x = zero_pos / board.length;
        int y = zero_pos % board.length;
        return neighbors;
    }

    public Board twin(){
        return null;
    }

    private void computeHamming(){
        int counter = 1;
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board.length;++j){
                if(board[i][j] != 0 && board[i][j] != counter){
                    hamming++;
                }
                counter++;
            }
        }
    }

    private int mapTo1D(int x, int y){
        return x * board.length + 1 + y;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);
        for(int i = 1;i <= 9;++i){
            StdOut.print((i - 1) / 3 + " ");
            StdOut.print((i - 1) % 3);
            StdOut.println();
        }
    }
}
