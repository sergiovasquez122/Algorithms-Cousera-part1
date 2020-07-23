import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private Queue<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points){
        if(points == null) throw new IllegalArgumentException();
        for(int i = 0;i < points.length;++i){
            if(points[i] == null){
                throw new IllegalArgumentException();
            }
        }

        for(int i = 1;i < points.length;++i){
            if(points[i].compareTo(points[i - 1]) == 0){
                throw new IllegalArgumentException();
            }
        }

        lineSegments = new Queue<>();
        for(int i = 0;i < points.length - 3;++i){
            for(int j = i + 1;j < points.length - 2;++j){
                for(int k = j + 1;k < points.length - 1;++k){
                    for(int l = k + 1;l < points.length;++l){
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if(p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)){
                            lineSegments.enqueue(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments(){
        return lineSegments.size();
    }

    public LineSegment[] segments(){
        int counter = 0;
        LineSegment[] segment = new LineSegment[lineSegments.size()];
        for(LineSegment l : lineSegments){
            segment[counter++] = l;
        }
        return segment;
    }

    public static void main(String[] args) {

            // read the n points from a file
            In in = new In(args[0]);
            int n = in.readInt();
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = in.readInt();
                int y = in.readInt();
                points[i] = new Point(x, y);
            }

            // draw the points
            StdDraw.enableDoubleBuffering();
            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
            for (Point p : points) {
                p.draw();
            }
            StdDraw.show();

            // print and draw the line segments
            BruteCollinearPoints collinear = new BruteCollinearPoints(points);
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
        }
}
