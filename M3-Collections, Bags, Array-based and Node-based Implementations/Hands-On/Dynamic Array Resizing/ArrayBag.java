import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

//Array(data structure), and Bag (interface)

public class ArrayBag<T> implements Bag<T>{

    private static final int DEFAULT_CAPACITY = 1;

    private T[] elements;
    private int size;

    public ArrayBag() {
        //parameter-less constructor calls the parameterized constructor
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        //because generic arrays can't be instantiated we must cast from Object Array
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean add(T element) {
        if(isFull()) {
            resize(elements.length * 2);
        }

        elements[size] = element;
        size++;
        return true;
    }

    public boolean remove(T element) {

        int i = locate(element);
        if(i < 0) {
            return false;
        }

        elements[i] = elements[--size];
        elements[size] = null;
        if(size > 0 && size < (elements.length / 4)) {
            resize(elements.length / 2);
        }
        return true;
    }

    public boolean contains(T element) {
        return locate(element) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        return new ArrayIterator<T>(elements, size);
    }

    private boolean isFull()  {
        return size == elements.length;
    }

    private int locate(T element) {
        for(int i = 0; i < size; i++) {
            if(elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int capacity) {
        T[] a = Arrays.copyOf(elements, capacity);
        elements = a;
    }

}
