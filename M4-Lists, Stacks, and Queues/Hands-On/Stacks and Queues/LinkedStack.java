public class LinkedStack<T> implements Stack<T>{

   Node top ;
   int size;
   
   public LinkedStack() {
      top = null;
      size = 0;
   }
   @Override
   public void push(T element) {
      top = new Node(element, top);
      size++;
   }

   @Override
   public T pop() {
      if(isEmpty()) {
         return null;
      }
      T topValue = top.element;
      top = top.next;
      size++;
      return topValue;
   }

   @Override
   public T peek() {
      if(isEmpty()) {
         return null;
      }
      return top.element;
   }

   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   @Override
   public int size() {
      return size;
   }

   private class Node {
      private Node next;
      private T element;
   
      public Node() {
         next = null;
      }
   
      public Node(T element, Node next) {
         this.element = element;
         this.next = next;
      }
   
      public Node(T element) {
         this.element = element;
      }
      
   }
   
}
