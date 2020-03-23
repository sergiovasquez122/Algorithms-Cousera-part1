import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] items = (Item[])new Object[10];
    public RandomizedQueue(){}
    public boolean isEmpty(){
        return size == 0;
    }
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0;i < size; i++){
            temp[i] = items[i];
        }
        items = temp;
    }

    public int size(){
        return size;
    }

    public void enqueue(Item item){
        if(item==null)throw new java.lang.IllegalArgumentException();
        if(size==items.length) resize(2*items.length);
        items[size++] = item;
    }
    public Item dequeue(){
        if(isEmpty())throw new java.util.NoSuchElementException();
        int index = StdRandom.uniform(size);
        swap(index,size - 1);
        Item ret = items[--size];
        items[size] = null;
        if(size>0 && size==items.length/4)resize(items.length/2);
        return ret;
    }

    private void swap(int a,int b){
        Item temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }
    public Item sample(){
        if(isEmpty())throw new java.util.NoSuchElementException();
        int index = StdRandom.uniform(size);
        return items[index];
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        int current = size;
        private Item[] a;
        ListIterator(){
            a = (Item[]) new Object[size];
            for(int i = 0;i < size ;++i){
                a[i] = items[i];
            }
            StdRandom.shuffle(a,0,size);
        }
        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public Item next() {
            if(!hasNext())throw new java.util.NoSuchElementException();
            return a[--current];
        }

        @Override
        public void remove() {
           throw new java.lang.UnsupportedOperationException();
        }
    }

    public static void main(String[] args){
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for(int i = 0;i<10;++i)
            queue.enqueue(i);
        StdOut.println(queue.sample());
    }
}
