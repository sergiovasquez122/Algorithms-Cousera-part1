import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

    private Node root = null;
    private int size = 0;
    public KdTree(){
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }

    public void insert(Point2D p){
        if(p == null) throw new IllegalArgumentException();
    }

    public boolean contains(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        return false;
    }

    public void draw(){

    }

    public Iterable<Point2D> range(RectHV rect){
        if(rect == null) throw new IllegalArgumentException();
        return null;
    }

    public Point2D nearest(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        return null;
    }

    public static void main(String[] args) {

    }

    private static class Node{
        private Point2D p;
        private RectHV rect;
        private Node lb;
        private Node rt;
    }
}
