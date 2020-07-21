import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Percolation {
    private int N;
    private boolean[][] sites;
    private int openSites;
    private WeightedQuickUnionUF UF;

    public Percolation(int n){
        if(n <= 0) throw new IllegalArgumentException("N must be greater than 0");
        this.N = n;
        UF = new WeightedQuickUnionUF(n + 2);
        // create sites that are closed initially
        sites = new boolean[N][N];
        // connect the virtual top site to the top row
        for(int i = 1;i <= N;++i)
            UF.union(0, i);
    }

    public void open(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
    }

    public boolean isOpen(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        throw new NotImplementedException();
    }

    public int numOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        return UF.connected(0, N * N + 1);
    }

    public static void main(String[] args) {

    }
}
