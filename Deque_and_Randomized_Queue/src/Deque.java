import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node head , tail;
    private int size;

    public Deque(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        if(item==null)throw new java.lang.IllegalArgumentException();
        if(isEmpty()){
           head = new Node();
           head.item = item;
           tail =head;
        }
        else{
            Node oldHead = head;
            head = new Node();
            head.next = oldHead;
            oldHead.prev = head;
            head.item = item;
        }
        size++;
    }

    public void addLast(Item item){
        if(item==null)throw new java.lang.IllegalArgumentException();
        if(isEmpty()){
            head = new Node();
            head.item = item;
            tail = head;
        }
        else{
            Node oldTail = tail;
            tail = new Node();
            tail.prev = oldTail;
            oldTail.next=tail;
            tail.item = item;
        }
        size++;
    }

    public Item removeFirst(){
        if(isEmpty())throw new java.util.NoSuchElementException();
        Item ret = head.item;
        if( size == 1){
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return ret;
    }

    public Item removeLast(){
        if(isEmpty())throw new java.util.NoSuchElementException();
        Item ret = tail.item;
        if( size == 1 ) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return ret;
    }

    private class Node{
        Node next;
        Node prev;
        Item item;
    }

    public Iterator<Item>  iterator()
    {return new ListIterator();}

    private class ListIterator implements Iterator<Item>{
        private Node current = head;

        public boolean hasNext(){
            return current!=null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if(!hasNext())throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String [] args){
    }
}
