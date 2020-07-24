import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private boolean solvable = false;
    private Stack<Board> moves;
    public Solver(Board inital){
        if(inital == null){
            throw new IllegalArgumentException();
        }
        moves = new Stack<>();
        MinPQ<Node> frontier = new MinPQ<>();
        frontier.insert(new Node(inital, 0, null));
        frontier.insert(new Node(inital.twin(), 0, null));
        while(!frontier.isEmpty()){
            Node current = frontier.delMin();
            if(current.b.isGoal()){
                Node x;
                for(x = current;x.prev != null;x = x.prev){
                    moves.push(x.b);
                }
                moves.push(x.b);
                if(x.b.equals(inital)){
                    solvable = true;
                }
                return;
            }

            for(Board b : current.b.neighbors()){
                if(current.prev != null && !current.prev.b.equals(b)){
                    frontier.insert(new Node(b, current.moves + 1, current));
                } else if(current.prev == null){
                    frontier.insert(new Node(b, current.moves + 1, current));
                }
            }
        }
    }

    public boolean isSolvable(){
        return solvable;
    }

    public int moves(){
        if(!isSolvable()){
            return -1;
        }
        return moves.size() - 1;
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

    private class Node implements Comparable<Node> {
        private Board b;
        private Node prev;
        private int moves;

        public Node(Board b, int moves, Node prev){
            this.b = b;
            this.moves = moves;
            this.prev = prev;
        }

        private int manhattanPriorityFunction(){
            return b.manhattan() + moves;
        }

        private int hammingPriorityFunction(){
            return b.hamming() + moves;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(hammingPriorityFunction(), o.hammingPriorityFunction());
        }
    }

}
