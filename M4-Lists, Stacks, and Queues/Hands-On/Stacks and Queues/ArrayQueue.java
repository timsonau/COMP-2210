public class ArrayQueue<T> implements Queue<T> {
   private T[] elements;
     //the index containing the front element
   private int front;
     //the index of the next elemenet that should come
   private int rear;
   
   private int size;
   private static final int DEFAULT_CAPACITY = 5;
     
   public ArrayQueue() {
      this(DEFAULT_CAPACITY);
   }
     
   public ArrayQueue(int capacity) {
      elements = (T[]) new Object[capacity];
   }
   
   public void enqueue(T element) {
      if(isFull()) {
         resize(elements.length * 2);
      }
      
      elements[rear] = element;
      rear = (rear + 1) % elements.length;
      size++;
      
   }
   
   public T dequeue() {
      if(isEmpty()) {
         return null;
      }
      
      T val = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      size--;
      return val;
   }
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public T peek() {
      if(isEmpty()) {
         return null;
      }
      return elements[front];
   }
   
   private void resize(int capacity) {
      T[] newArray = (T[]) new Object[capacity];
      int i = 0;
      int j = front;
      
      for(int k = 0; k < size; k++) {
         newArray[i] = elements[j];
         i++;
         j = (j + 1) % elements.length;
      }
      
      //version 2?
      
      for(int z = 0; z < size; z++) {
         newArray[z] = elements[j];
         j = (j + 1) % elements.length;
      }
      
      elements = newArray;
      front = 0;
      rear = size;
   }
   
   private boolean isFull() {
      return size == elements.length;
   
   }
   

}