import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIndexedList<T> implements IndexedList<T>{

    private T[] elements;

    //next avaliable index
    private int rear;
    private static final int DEFAULT_SIZE = 5;

    public ArrayIndexedList() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayIndexedList(int capacity) {
        elements = (T[]) new Object[capacity];
        rear = 0;
    }

    @Override
    public boolean add(T element, int index) {
        if(index == rear) {
            return add(element);
        }

        //invalid index
        if(!validIndex(index)) {
            return false;
        }

        if(isFull()) {
            resize(elements.length * 2);
        }

        shiftRight(index);
        elements[index] = element;
        rear++;
        return true;

    }



    @Override
    public boolean add(T element) {
        if(isFull()) {
            resize(elements.length * 2);
        }
        elements[rear] = element;
        rear++;
        return true;
    }

    @Override
    public boolean set(T element, int index) {
        if(!validIndex(index)){
            return false;
        }

        elements[index] = element;
        return true;
    }

    @Override
    public T get(int index) {
        if(!validIndex(index)) {
            throw new IllegalArgumentException("Invalid Index");
        }
        return elements[index];
    }

    @Override
    public int indexOf(T element) {
        return locate(element);
    }

    @Override
    public T remove(int index) {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(index < 0) {
            throw new IllegalArgumentException();
        }

        T removedElement = get(index);

        for(int i = index; i < (rear - 1); i++) {
            elements[i] = elements[i + 1];
        }
        
        elements[rear] = null;
        rear--;

        if(rear > 0 && (rear < elements.length/4)) {
            resize(elements.length/2);
        }
        
        return removedElement;

    }

    @Override
    public T remove() {
        if(isEmpty()) {
            return null;
        }

        T removedElement = elements[rear];
        elements[rear] = null;
        rear--;

        
        if(rear > 0 && (rear < elements.length/4)) {
            resize(elements.length/2);
        }
        
        return removedElement;

    }

    @Override
    public T first(){
        if(isEmpty()){
            return null;
        }

        return elements[0];
    }

    @Override
    public T last(){
        if(isEmpty()){
            return null;
        }

        return elements[rear - 1];
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        return remove(0);
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        return remove(rear - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(elements, rear);
    }


    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public String toString() {
        String output = "";
        Iterator<T> itr = iterator();
        while(itr.hasNext()) {
            output += itr.next() + ", ";
        }

        return output;
    }

    private boolean isFull() {
        return rear == elements.length;
    }

    private void resize(int capacity) {
        T[] a = Arrays.copyOf(elements, capacity);
        elements = a;
    }

    private boolean validIndex(int index) {
        return (index >= 0) && (index < rear);
    }

    private void shiftRight(int index) {
        for(int i = rear - 1; i >= index; i--) {
            elements[i] = elements[i + 1];
        }
        elements[index] = null;
    }

    private int locate(T element) {
        for(int i = 0; i < rear; i++) {
            if(elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
