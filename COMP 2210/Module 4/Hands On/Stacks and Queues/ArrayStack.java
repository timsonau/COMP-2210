public class ArrayStack<T> implements Stack<T> {
   private static final int DEFAULT_CAPACITY = 5;
   private T[] elements;
   private int top;

   public ArrayStack() {
      this(DEFAULT_CAPACITY);
   }

   public ArrayStack(int capacity) {
      elements = (T[]) new Object[capacity];
      top = 0;
   }
   @Override
   public void push(T element) {
      if(isFull()) {
         resize(top * 2);
      }
      elements[top++] = element;
   }

   @Override
   public T pop() {
      if(isEmpty()) {
         return null;
      }
   
      //find the element unfer top
      T topElement = elements[--top];
      //make that thang null
      elements[top] = null;
      
      if(size() > 0 && size() < elements.length / 4) {
         resize(elements.length / 2);
      }
   
      return topElement;
   }

   @Override
   public T peek() {
      if(isEmpty()) {
         return null;
      }
   
      return elements[top - 1];
   }

   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   @Override
   public int size() {
      return top;
   }

   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for(int i = 0; i < top; i++) {
         a[i] = elements[i];
      }
      elements = a;
   }

   private boolean isFull() {
      return top == elements.length;
   }

   
   
}
