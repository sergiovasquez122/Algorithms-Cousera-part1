import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

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
            int cmp = Double.compare(p.x(), x.p.x());
            if(cmp < 0){
                x.lb = insert(x.lb, p, xmin, ymin,x.p.x(), ymax, !isVerticalOrientation);
            } else if(cmp > 0){
                x.rt = insert(x.rt, p, x.p.x(), ymin, xmax, ymax, !isVerticalOrientation);
            }
        } else {
            int cmp = Double.compare(p.y(), x.p.y());
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
        return get(p) != null;
    }

    private Point2D get(Point2D p){
        return get(root, p, true);
    }

    private Point2D get(Node x, Point2D p, boolean isVerticalOrientation){
        if(x == null) return null;
        int cmp;
        if(isVerticalOrientation) cmp = Double.compare(x.p.x(), p.x());
        else cmp = Double.compare(x.p.y(), p.y());
        if(cmp == 0) return x.p;
        else if(cmp < 0) return get(x.lb, p, !isVerticalOrientation);
        else return get(x.rt, p, !isVerticalOrientation);
    }

    public void draw(){
        draw(root, true);
    }

    public void draw(Node x, boolean isVerticalOrientation){
        if(x == null) return;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        x.p.draw();
        if(isVerticalOrientation){
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            StdDraw.line(x.p.x(), x.rect.ymin(), x.p.x(), x.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius();
            StdDraw.line(x.rect.xmin(), x.p.y(), x.rect.xmax(), x.p.y());
        }
        isVerticalOrientation = !isVerticalOrientation;
        draw(x.lb, isVerticalOrientation);
        draw(x.rt, isVerticalOrientation);
    }

    public Iterable<Point2D> range(RectHV rect){
        if(rect == null) throw new IllegalArgumentException();
        return null;
    }

    public Point2D nearest(Point2D p){
        if(p == null) throw new IllegalArgumentException();
        return null;
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
