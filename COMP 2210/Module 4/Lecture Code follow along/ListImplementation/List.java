import java.util.Iterator;

public interface List<T> {
    T first();
    T last();
    T removeFirst();
    T removeLast();
    T remove();
    boolean isEmpty();
    int size();
    Iterator<T> iterator();
    String toString();
    

}
