import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments;
    public FastCollinearPoints(Point[] points){
        if(points == null) throw new IllegalArgumentException();
        for(int i = 0;i < points.length;++i){
            if(points[i] == null){
                throw new IllegalArgumentException();
            }
        }

        Point[] local = points.clone();
        Arrays.sort(local);
        for(int i = 1;i <  local.length;++i){
            if(local[i].compareTo(local[i - 1]) == 0){
                throw new IllegalArgumentException();
            }
        }

        segments = new ArrayList<>();
    }

    public int numberOfSegments(){
        return segments.size();
    }

    public LineSegment[] segments(){
        int counter = 0;
        LineSegment[] segment = new LineSegment[segments.size()];
        for(LineSegment l : segments){
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
