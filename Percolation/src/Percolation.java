import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Percolation {
    private int N;
    private boolean[] sites;
    private int openSites;
    private WeightedQuickUnionUF UF;

    public Percolation(int n){
        if(n <= 0) throw new IllegalArgumentException("N must be greater than 0");
    }

    public void open(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
    }

    public boolean isOpen(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        throw new NotImplementedException();
    }

    public boolean isFull(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        throw new NotImplementedException();
    }

    public int numOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        throw new NotImplementedException();
    }

    public static void main(String[] args) {

    }
}
