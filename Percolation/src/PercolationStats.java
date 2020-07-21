import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double mean;
    private double confidenceLo;
    private double confidenceHi;
    private double stdDev;

    public PercolationStats(int n, int trials){
        double[] openSites = new double[trials];
        for(int i = 0;i < trials;++i)
            openSites[i] = trial(n);
        mean = StdStats.mean(openSites);
        stdDev = StdStats.stddev(openSites);
        confidenceLo = mean - (1.96 * Math.sqrt(stdDev)) / Math.sqrt(trials);
        confidenceHi = mean + (1.96 * Math.sqrt(stdDev)) / Math.sqrt(trials);
    }

    private double trial(int n){
        Percolation p = new Percolation(n);
        while(!p.percolates()){
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            p.open(row, col);
        }
        return p.numOfOpenSites() / (double)n*n;
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

    public double confidentHi(){
        return confidenceHi;
    }
}
