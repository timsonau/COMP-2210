import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Array-based implementation of the IndexList interface.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-20
 */
public class ArrayIndexedList<T> implements IndexedList<T> {

	/** stores elements of list. */
   T[] elements;

	/** index of next insertion point; number of elements in list. */
   int rear;

	/** Constructs an instance of this list. */
   @SuppressWarnings("unchecked")
   public ArrayIndexedList(int capacity) {
      elements = (T[]) new Object[capacity];
      rear = 0;
   }

	/** Returns the first element in this list. */
   public T first() {
      return get(0);
   }

	/** Returns the last element in this list. */
   public T last() {
      return get(rear - 1);
   }

	/** Removes the first element in this list. */
   public T removeFirst() {
      return null;
   }

	/** Removes the last element in this list. */
   public T removeLast() {
      return null;
   }

	/** Removes the specified element from this list. */
   public T remove(T element) {
      int index = indexOf(element);
      if(index < 0) {
         throw new NoSuchElementException("Such element does not exist");
      }
   
      return remove(index);
   
   }

	/** Returns true if this list has no elements, false otherwise. */
   public boolean isEmpty() {
      return rear == 0;
   }

	/** Returns the number of elements in this list. */
   public int size() {
      return rear;
   }

	/** Returns an iterator over the elements in this list. */
   public Iterator<T> iterator() {
      return null;
   }

	/** Returns a string representation of this list. */
   public String toString() {
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (int i = 0; i < rear; i++) {
         result.append(elements[i]);
         result.append(", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

	/** Adds the given element at the specified index in this list. */
   public boolean add(T element, int index) {
      if (index == rear) {
         return add(element);
      }
      if (!validIndex(index)) {
         return false;
      }
      if (isFull()) {
         resize(elements.length * 2);
      }
      shiftRight(index);
      elements[index] = element;
      rear++;
      return true;
   }

	/** Adds the given element at the end of this list. */
   public boolean add(T element) {
      if (isFull()) {
         resize(elements.length * 2);
      }
      elements[rear] = element;
      rear++;
      return true;
   }

	/** Replaces the current element at the specified index with the given elemeent. */
   public boolean set(T element, int index) {
      return false;
   }

	/** Returns the element at the given index in this list. */
   public T get(int index) {
      if(!validIndex(index)) {
         throw new IllegalArgumentException("invalid index");
      }
   
      return elements[index];
   }

	/** Returns the index of the specified element in this list. */
   public int indexOf(T element) {
      for (int i = 0; i < rear; i++) {
         if(elements[i].equals(element)) {
            return i;
         }
      }
      return -1;
   }

	/** Removes the element at the specified index in this list. */
   public T remove(int index) {
      if(!validIndex(index)) {
         throw new IllegalArgumentException("Invalid index");
      }
   	
      T removedElement = elements[index];
      shiftLeft(index);
      rear--;
      return removedElement;
   }

	/** Returns true if the array is full, false otherwise. */
   private boolean isFull() {
      return rear == elements.length;
   }

	/** Resizes the array to the specified size, copying corresonding elements. */
   @SuppressWarnings("unchecked")
   void resize(int capacity) {
      assert (capacity >= rear);
      T[] newArray = (T[]) new Object[capacity];
      for (int i = 0; i < rear; i++) {
         newArray[i] = elements[i];
      }
      elements = newArray;
   }

	/** Moves elements from index..rear-1 one index to the right. */
   private void shiftRight(int index) {
      if(!validIndex(index)) {
      
      }
      else {
         for(int i = rear - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
         }
         elements[index] = null;
      }
   }

   private void shiftLeft(int index) {
      if(!validIndex(index)) {
      
      }
      else {
         for(int i = index; i < rear - 1; i++) {
            elements[i] = elements[i + 1];
         }
         elements[rear - 1] = null;
      }
   }

	/** Returns true if specified index is in the legal range, false otherwise. */
   private boolean validIndex(int index) {
      return (index >= 0) && (index < rear);
   }

}
