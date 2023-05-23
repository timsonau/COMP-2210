public class LinkedQueue<T> implements Queue<T> {
   private Node front ;
   private Node rear;
   private int size;
   
   public LinkedQueue() {
      front = null;
      rear = null;
      size = 0;
   }
   @Override
   public void enqueue(T element) {
      Node n = new Node(element);
      if(isEmpty()) {
         front = n;
         rear = front;
      }
      else {
         rear.next = n;
         rear = n;
      }
      size++;
   }

   @Override
   public T dequeue() {
      if(isEmpty()) {
         return null;
      }
      T first = front.element;
      front = front.next;
      if(size() == 1) {
         rear = front;
      }
      size--;
      return first;
   }

   @Override
   public T peek() {
      if(isEmpty()) {
         return null;
      }
      return front.element;
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