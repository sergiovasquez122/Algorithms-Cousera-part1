import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(){
        StdDraw.point(x, y);
    }

    public void drawTo(Point that){
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point rhs) {
        if(y < rhs.y) return -1;
        else if(y > rhs.y) return +1;
        else{
            if(x < rhs.x) return -1;
            else if(x > rhs.x) return 1;
            else return 0;
        }
    }

    public double slopeTo(Point that){
        if (x == that.x && y == that.y) return Double.NEGATIVE_INFINITY;
        if (x == that.x) return Double.POSITIVE_INFINITY;
        if (y == that.y) return +0.0;
        return (double) (that.y - y) / (that.x - x);
    }

    public Comparator<Point> slopeOrder(){
        Comparator<Point> t = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(slopeTo(o1), slopeTo(o2));
            }
        };
        return t;
    }
}
