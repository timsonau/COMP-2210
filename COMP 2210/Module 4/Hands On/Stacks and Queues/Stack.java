public interface Stack<T> {
   //insert an element to the top
   void push(T element);
   //pop out the element in the top
   T pop();
   //peek at the elment at the top
   T peek();

   //checks if the stack is empty
   boolean isEmpty();

   //num of elements in the stack
   int size();

}