import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double mean;
    private double confidenceLo;
    private double confidenceHi;
    private double stdDev;

    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0) throw new IllegalArgumentException();
        double[] openSites = new double[trials];
        for(int i = 0;i < trials;++i)
            openSites[i] = trial(n);
        mean = StdStats.mean(openSites);
        stdDev = StdStats.stddev(openSites);
        confidenceLo = mean - (1.96 * Math.sqrt(stdDev * stdDev)) / Math.sqrt(trials);
        confidenceHi = mean + (1.96 * Math.sqrt(stdDev * stdDev)) / Math.sqrt(trials);
    }

    private double trial(int n){
        Percolation p = new Percolation(n);
        while(!p.percolates()){
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            p.open(row, col);
        }
        return p.numberOfOpenSites() / (double)(n*n);
    }

    public double mean(){
        return mean;
    }

    public double stddev(){
        return stdDev;
    }

    public double confidenceLo(){
        return confidenceLo;
    }

    public double confidenceHi(){
        return confidenceHi;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(N, T);

        String confidence = "[" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]";
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + confidence);

    }
}
