import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {
    boolean add(T element);
    boolean remove(T element);
    boolean contains(T element);
    int size();
    boolean isEmpty();
    Iterator<T> iterator();

}