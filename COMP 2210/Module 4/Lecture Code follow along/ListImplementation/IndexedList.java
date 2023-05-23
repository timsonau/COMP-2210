public interface IndexedList<T> extends List<T> {

    //adds element to a given index
    boolean add(T element, int index);

    //adds element to the last available index
    boolean add(T element);
    //changes the element at the index with new element passed in
    boolean set(T element, int index);

    //gets element at a given index
    T get (int index);

    //gives index of an element
    int indexOf(T element);

    //removes an element
    T remove (int index);
}
