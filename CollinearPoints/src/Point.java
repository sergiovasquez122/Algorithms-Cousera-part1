import java.util.Comparator;

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y){

    }

    public void draw(){

    }

    public void drawTo(Point that){

    }

    public String toString(){
        return "";
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
        if(x == that.x && y == that.y) return Double.NEGATIVE_INFINITY;
        else if(y == that.y) return 0;
        else if(x == that.x) return Double.POSITIVE_INFINITY;
        return (that.y - y) / (double) (that.x - x);
    }

    public Comparator<Point> slopeOrder(){
        return null;
    }
}
