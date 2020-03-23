import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args){
        int K = Integer.parseInt(args[0]);
         RandomizedQueue<String> queue = new RandomizedQueue<>();
         while(!StdIn.isEmpty())queue.enqueue(StdIn.readString());
         for(int i = 0;i<K;++i)
             StdOut.println(queue.dequeue());
    }
}
