import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIndexedList<T> implements IndexedList<T> {
    private Node front;
    private Node rear;
    private int size;

    public LinkedIndexedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean add(T element, int index) {

        // if the index equals the size we can put the element in the back
        if (index == size) {
            add(element);
        }

        if (!validIndex(index)) {
            return false;
        }

        Node n = new Node(element);

        if (index == 0) {
            n.next = front;
            front.previous = n;
            front = n;
            size++;
            return true;
        }

        Node p = front;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        // make new node aware of old linked structure
        n.next = p;
        n.previous = p.previous;

        // make old linked structure aware of the new node
        p.previous = n;
        p.previous.next = n;

        size++;
        return true;
    }

    @Override
    public boolean add(T element) {
        Node n = new Node(element);

        if (isEmpty()) {
            front = n;
            rear = n;
            size++;
            return true;
        }

        // connects n to the existing linked Nodes
        n.previous = rear;

        // connects the existing linked Nodes to n
        rear.next = n;

        // updates what is the rear node
        rear = n;

        size++;
        return true;
    }

    @Override
    public boolean set(T element, int index) {
        if (!validIndex(index)) {
            return false;
        }

        Node p = front;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        p.element = element;
        return true;

    }

    @Override
    public T get(int index) {
        if (!validIndex(index)) {
            return null;
        }

        Node p = front;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.element;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < size;
    }

    private class Node {
        private Node next;
        private Node previous;
        private T element;

        public Node(T element) {
            this.element = element;
        }
    }

    @Override
    public T first() {
        return get(0);
    }

    @Override
    public T last() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.element;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }
}
