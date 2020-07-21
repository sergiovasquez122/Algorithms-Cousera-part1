import edu.princeton.cs.algs4.StdOut;
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
        UF = new WeightedQuickUnionUF(n*n + 2);
        // create sites that are closed initially
        sites = new boolean[N][N];
        // connect the virtual top site to the top row
        for(int i = 1;i <= N;++i)
            UF.union(0, i);
        int lastSite = N*N;
        for(int i = lastSite;i > lastSite - N;--i)
            UF.union(N*N + 1, i);
    }

    public void open(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        if(isOpen(row, col)) return;
        sites[row - 1][col - 1] = true;
        int positions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] pos : positions){
            int x = row + pos[0];
            int y = col + pos[1];
        }
        openSites++;
    }

    private boolean invalid(int row, int col){
        return !(row <= 0 || row > N || col <= 0 || col > N);
    }

    public boolean isOpen(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IndexOutOfBoundsException("Row or Col index out of bounds");
        if(!isOpen(row, col)) return false;
        return UF.connected(0, N * (row - 1) + col);
    }

    public int numOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        return UF.connected(0, N * N + 1);
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(2);
        StdOut.println(percolation.isOpen(1, 1));
    }
}
