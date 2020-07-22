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
        root = insert(root, p, 0, 0, 1, 1, true);
    }

    public Node insert(Node x,Point2D p, double xmin, double ymin, double xmax, double ymax,boolean isVerticalOrientation){
        if(x == null){
            size++;
            return new Node(p, new RectHV(xmin, ymin, xmax, ymax));
        }
        if(isVerticalOrientation){
            int cmp = Double.compare(x.p.x(), p.x());
            if(cmp < 0){
                x.lb = insert(x.lb, p, xmin, ymin,x.p.x(), ymax, !isVerticalOrientation);
            } else if(cmp > 0){
                x.rt = insert(x.rt, p, x.p.x(), ymin, xmax, ymax, !isVerticalOrientation);
            }
        } else {
            int cmp = Double.compare(x.p.y(), p.y());
            if(cmp < 0){
                x.lb = insert(x.lb, p, xmin, ymin, xmax, x.p.y(), !isVerticalOrientation);
            } else if(cmp > 0){
                x.rt = insert(x.rt, p, xmin, x.p.y(), xmax, ymax, !isVerticalOrientation);
            }
        }
        return x;
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

        public Node(Point2D p, RectHV rect){
            this.p = p;
            this.rect = rect;
        }
    }
}
