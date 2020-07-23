import java.util.ArrayList;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments;
    public FastCollinearPoints(Point[] points){

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
        return segment;;
    }
}
