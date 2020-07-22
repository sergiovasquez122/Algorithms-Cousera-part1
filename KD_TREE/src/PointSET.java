import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {

    private SET<Point2D> redBlackTree;
    public PointSET(){
        redBlackTree = new SET<>();
    }

    public boolean isEmpty(){
        return redBlackTree.isEmpty();
    }

    public int size(){
        return redBlackTree.size();
    }

    public void insert(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        redBlackTree.add(p);
    }

    public boolean contains(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        return redBlackTree.contains(p);
    }

    public void draw(){

    }

    public Iterable<Point2D> range(RectHV rect){
        if(rect == null) throw new IllegalArgumentException();
        Queue<Point2D> on_queue = new Queue<>();
        for(Point2D p : redBlackTree){
            if(rect.contains(p)){
                on_queue.enqueue(p);
            }
        }
        return on_queue;
    }

    public Point2D nearest(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        Point2D result = null;
        double minDistance = Double.POSITIVE_INFINITY;
        for(Point2D point : redBlackTree){
            if(minDistance > p. distanceTo(point)){
                result = point;
                minDistance = p.distanceTo(point);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
