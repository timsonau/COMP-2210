import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<T> implements Bag<T> {
    private Node front;
    private int size;

    public LinkedBag () {
        front = null;
        size = 0;
    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;

    }

    public boolean add(T element) {
        //creates a node from the element
        Node n = new Node(element);

        //connects this node with already existing node in the front
        n.next = front;

        //connects the old first node to new first node
        if(n != null) {
            front.prev = n;
        }

        //n becomes the new front
        front = n;

        //successfully added element in the first node
        size++;
        return true;
    }

    public boolean contains(T element) {
        return locate(element) != null;
    }

    public boolean remove(T element) {
        //atempt to locate
        Node n = locate(element);

        //if unable to locate
        if(n == null) {
            return false;
        }

        //if locate but the size equals one
        if(size == 1) {
            front = null;
            size--;
            return true;
        }

        //if locate but its in the front
        if(n == front) {
            front = front.next;
            front.prev = null;
        }
        else {
            n.prev.next = n.next;
            if(n != null) {
                n.next.prev = n.prev;
            }
        }

        size--;
        return true;
    }

    private Node locate(T element) {
        //gets access to the existing linked nodes
        Node n = front;

        while(n != null) {
            if(n.element.equals(element)) {
                return n;
            }
            n = n.next;
        }

        return null;
    }

    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class Node {

        private T element;
        private Node next;
        private Node prev;

        public Node (T element) {
            this.element = element;
        }
    }

    private class LinkedIterator implements Iterator<T> {

        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if(!hasNext()) throw new NoSuchElementException("No more next element");
            T result = current.element;
            current = current.next;

            return result;

        }
    }

}
