import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] items;
    private int size;
    private int current;

    public ArrayIterator(T[] items, int size){
        this.items = items;
        this.size = size;
        current = 0;
    }
    public boolean hasNext() {
        return current < size;
    }

    public T next(){
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[current++];
    }
}