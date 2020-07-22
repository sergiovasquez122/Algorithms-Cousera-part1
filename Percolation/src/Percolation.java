import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int N;
    private boolean[][] sites;
    private int openSites;
    private final WeightedQuickUnionUF UF;

    public Percolation(int n){
        if(n <= 0) throw new IllegalArgumentException("N must be greater than 0");
        this.N = n;
        UF = new WeightedQuickUnionUF(n*n + 2);
        openSites = 0;
        // create sites that are closed initially
        sites = new boolean[N][N];
        // connect the virtual top site to the top row
        for (int i = 1; i <= N; ++i)
            UF.union(0, i);
        int lastSite = N * N;
        for (int i = lastSite; i > lastSite - N; --i)
            UF.union(N * N + 1, i);
    }

    public void open(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IllegalArgumentException("Row or Col index out of bounds");
        if(isOpen(row, col)) return;
        sites[row - 1][col - 1] = true;
        int positions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] pos : positions){
            int x = row + pos[0];
            int y = col + pos[1];
            if(valid(x, y) && sites[x - 1][y - 1]){
                UF.union(N * (row - 1) + col, N*(x - 1) + y);
            }
        }
        openSites++;
    }

    private boolean valid(int row, int col){
        return row >= 1 && row <= N && col >= 1 && col <= N;
    }

    public boolean isOpen(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IllegalArgumentException("Row or Col index out of bounds");
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col){
        if(row <= 0 || row > N || col <= 0 || col > N) throw new IllegalArgumentException("Row or Col index out of bounds");
        if(!isOpen(row, col)) return false;
        return UF.find(0) == UF.find(N * (row - 1) + col);
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        if(N == 1) return sites[0][0];
        return UF.find(0) == UF.find(N * N  + 1);
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(2);
        StdOut.println(percolation.isOpen(1, 1));
    }
}
