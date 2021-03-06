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
        if(local.length > 3){
            Point[] temp = local.clone();
            for(Point p : local){
                Arrays.sort(temp, p.slopeOrder());
                findSegments(temp, p);
            }
        }
    }

    private void findSegments(Point[] local, Point p){
        int start = 1;
        double slope = p.slopeTo(local[1]);
        for(int i = 2;i < local.length;++i){
            double tempSlope = p.slopeTo(local[i]);
            if(Double.compare(slope, tempSlope) != 0){
                if(i - start >= 3){
                    ArrayList<Point> temp = new ArrayList<>();
                    temp.add(p);
                    for(int j = start;j < i;++j){
                        temp.add(local[j]);
                    }
                    temp.sort(null);
                    if(temp.get(0).compareTo(p) == 0){
                        segments.add(new LineSegment(p, temp.get(temp.size() - 1)));
                    }
                }
                start = i;
                slope = tempSlope;
            }
        }

        if(local.length - start >= 3){
            ArrayList<Point> temp = new ArrayList<>();
            temp.add(p);
            for(int j = start;j < local.length;++j){
                temp.add(local[j]);
            }
            temp.sort(null);
            if(temp.get(0).compareTo(p) == 0){
                segments.add(new LineSegment(p, temp.get(temp.size() - 1)));
            }
        }
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
