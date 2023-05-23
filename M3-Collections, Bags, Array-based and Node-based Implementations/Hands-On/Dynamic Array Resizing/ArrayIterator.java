import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    //array of elements to be iterated over
    private T[] items;

    //number of elements in the array
    private int count;

    //the current position in the iteration
    private int current;

    public ArrayIterator(T[] items, int count) {
        this.items = items;
        this.count = count;
        current = 0;
    }

    public boolean hasNext() {
        return current < count;

    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public T next(){
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        return items[current++];
    }
}
