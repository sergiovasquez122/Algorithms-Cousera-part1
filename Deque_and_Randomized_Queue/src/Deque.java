import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    private class Node
    {
        Item item;
        Node next;
        Node prev;
    }

    public Deque(){
        head = new Node();
        tail = new Node();
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        if( item == null ){
            throw new IllegalArgumentException();
        }
        Node node = new Node();
        node.item = item;
        if( head == null ){
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(Item item){
        if( item == null ){
            throw new IllegalArgumentException();
        }
        Node node = new Node();
        node.item = item;
        if( tail == null ){
            tail = node;
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Item removeFirst(){
        if( isEmpty() ){
            throw new IllegalArgumentException();
        }
        Item item = head.item;
        head = head.next;
        if( head != null ) {
            head.prev = null; // remove linkage
        } else {
            tail = null; // ensure both head and tail null
        }
        size --;
        return item;
    }

    public Item removeLast(){
        if( isEmpty() ){
            throw new IllegalArgumentException();
        }
        Item item = tail.item;
        tail = tail.prev;
        if( tail != null ){
            tail.next = null; // remove linkage
        } else {
            head = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null && current.next != null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if( !hasNext() ){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());

        for( int i = 0; i < 10; ++i){
            deque.addFirst(i);
        }
        Iterator<Integer> iterator = deque.iterator();
        while(iterator.hasNext()){
            StdOut.println(iterator.next());
        }
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeFirst());
    }
}
