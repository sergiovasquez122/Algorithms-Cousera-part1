import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    public BruteCollinearPoints(Point[] points){
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
        for(int i = 0;i < local.length - 3;++i){
            for(int j = i + 1;j < local.length - 2;++j){
                for(int k = j + 1;k < local.length - 1;++k){
                    for(int l = k + 1;l < local.length;++l){
                        Point p = local[i];
                        Point q = local[j];
                        Point r = local[k];
                        Point s = local[l];
                        if(p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)){
                            Point[] temp = new Point[4];
                            temp[0] = p;
                            temp[1] = q;
                            temp[2] = r;
                            temp[3] = s;
                            Arrays.sort(temp);
                            LineSegment segment = new LineSegment(temp[0], temp[3]);
                            segments.add(segment);
                        }
                    }
                }
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
            BruteCollinearPoints collinear = new BruteCollinearPoints(points);
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
        }
}
