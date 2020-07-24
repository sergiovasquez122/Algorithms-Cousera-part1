import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private boolean solvable;
    private Stack<Board> moves;
    public Solver(Board inital){
        if(inital == null){
            throw new IllegalArgumentException();
        }
    }

    public boolean isSolvable(){
        return solvable;
    }

    public int moves(){
        if(!isSolvable()){
            return -1;
        }
        return moves.size();
    }

    public Iterable<Board> solution(){
        if(!isSolvable()){
            return null;
        }
        return moves;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
