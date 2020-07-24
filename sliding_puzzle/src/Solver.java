import edu.princeton.cs.algs4.Stack;

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

    }
}
