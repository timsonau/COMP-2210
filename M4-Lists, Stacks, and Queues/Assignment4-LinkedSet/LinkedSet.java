import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author YOUR NAME (you@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

   //////////////////////////////////////////////////////////
   // Do not change the following three fields in any way. //
   //////////////////////////////////////////////////////////

   /** References to the first and last node of the list. */
   Node front;
   Node rear;

   /** The number of nodes in the list. */
   int size;

   /////////////////////////////////////////////////////////
   // Do not change the following constructor in any way. //
   /////////////////////////////////////////////////////////

   /**
    * Instantiates an empty LinkedSet.
    */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }

   //////////////////////////////////////////////////
   // Public interface and class-specific methods. //
   //////////////////////////////////////////////////

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this LinkedSet.
    *
    * @return a string representation of this LinkedSet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }


   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return (size == 0);
   }


   /**
    * Ensures the collection contains the specified element. Neither duplicate
    * nor null values are allowed. This method ensures that the elements in the
    * linked list are maintained in ascending natural order.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   public boolean add(T element) {
      //null check
      if(element == null) {
         return false;
      }
      
      //duplicate check
      if(contains(element)){
         return false;
      }
   
      //at this point we know it is a legal node to add
      
      //we shall use a pointer chain to find the node that should come after our element
      Node p = locate(element);

      //at this point we should know p has a node either bigger than the T element or p == null
      //connect this node to the linkedset.
      Node n = new Node(element);
      insertNode(n, p);
      return true;
   }

   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. This method, consistent with add, ensures
    * that the elements in the linked lists are maintained in ascending
    * natural order.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   public boolean remove(T element) {
      //null can't be removed
      if(element == null) {
         return false;
      }
      Node p = locate(element);
      //cant remove element if its not there
      if(p == null) {
         return false;
      }
      //we know we have past the desried element so it cannot be there
      if(element.compareTo(p.element) != 0) {
         return false;
      }
      removeNode(p);
      return true;
      
   }
   
   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection is to be tested.
    * @return  true if this collection contains the specified element, false otherwise.
    */
   public boolean contains(T element) {
      //linearly scans the this linkedstructure comparing each element to the param element to see if they are equal 
      if(locate(element) == null) {
         return false;
      }
      return true;
   }

   private Node locate(T element) {
      Node p = front;
      while(p != null &&  element.compareTo(p.element) > 0) {
         p = p.next;
      }
      return p;
   }
   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      //check if they have the same number of elements
      if(s.size() != this.size) {
         return false;
      }
   
      //linear scan through the linkedstructure looking at each element of the nodes
      for(T val : this) {
         //we must use the contains method because we cannot assume nature order of Set s.
         if(!s.contains(val)) {
            return false;
         }
      }
      
      return true;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(LinkedSet<T> s) {
      //if the number of nodes differ obviously they aren't the same
      //early exit
      if(this.size != s.size()) {
         return false;
      }
      
      Node p = s.front;
      Node n = this.front;
   
      //keeps going until n is exhausted. since n exhausted == p exhauste.
      while(n != null) {
         //if they are the same move along the Nodes
         if(n.element.compareTo(p.element) == 0) {
            n = n.next;
            p = p.next;
         }
         //LinkedSet == natural order. Therefore if two element aren't equal in the same node position the two sets cannot be equal
         else {
            return false;
         }
      }
      
      return true;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(Set<T> s){
      if(s == null || s.size() == 0) {
         return this;
      }
   
      Set<T> union = new LinkedSet<>();
      
      //takes elements of the param set and adds it to the union set
      for(T val : s) {
         //this add method will ensure natural order
         union.add(val);
      }
   
      //takes element of this set and adds it to the union set
      for(T val : this) {
         union.add(val);
      }
   
      return union;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(LinkedSet<T> s){
      LinkedSet<T> union = new LinkedSet<>();
      
      //if the set s is null or 0 there is nothing to add with the current Linkedset
      if(s == null || s.size() == 0) {
         return this;
      }
      
      //will represent the current node of this linkedset
      Node n = this.front;
      
      //will represent the current node of param (s) linkedset
      Node p = s.front;
      
      //one can be exhausted before the other
      while(p != null || n != null) {
         //if the p pointer runs out add every element from (n, this.rear)
         if(p == null) {
            union.addToBack(n.element);
            n = n.next;
         }
         //if the n pointer runs out add every element from (p, s.rear)
         else if (n == null) {
            union.addToBack(p.element);
            p = p.next;
         }
         
         //at this point we know the n and p pointer aren't exahsuted. 
         //if n.element < p.element, add the smaller element n to keep natural order
         else if(n.element.compareTo(p.element) < 0) {
            union.addToBack(n.element);
            n = n.next;
         }
         
         //if n.element > p.element, add the smaller element p to keep natural orer
         else if(n.element.compareTo(p.element) > 0) {
            union.addToBack(p.element);
            p = p.next;
         }
         
         //if both are equal add both
         else {
            union.addToBack(n.element);
            n = n.next;
            p = p.next;
         }
      }
   
      return union;
   }


   /**
    * Returns a set that is the intersection of this set and the parameter set.
    *
    * @return  a set that contains elements that are in both this set and the parameter set
    */
   public Set<T> intersection(Set<T> s) {
      Set<T> intersection = new LinkedSet<>();
      
      if(s == null || s.size() == 0) {
         return intersection;
      }
      
      for(T val : this) {
         if(s.contains(val)) {
            intersection.add(val);
         }
      }
      return intersection;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(LinkedSet<T> s) {
      LinkedSet<T> intersection = new LinkedSet<>();
      
      if(s == null || s.size() == 0) {
         return intersection;
      }
      
      //pointer for this linkedset
      Node n = this.front;
      
      //pointer for s set
      Node p = s.front;
      
      while(p != null && n != null) {
         if(n.element.compareTo(p.element) < 0) {
            n = n.next;
         }
         else if(n.element.compareTo(p.element) > 0) {
            p = p.next;
         }
         else {
            intersection.addToBack(p.element);
            n = n.next;
            p = p.next;
         }
      }
      return intersection;
   }


   /**
    * Returns a set that is the complement of this set and the parameter set.
    *
    * @return  a set that contains elements that are in this set but not the parameter set
    */
   public Set<T> complement(Set<T> s) {
      Set<T> complement = new LinkedSet<>();
      
      for(T val : this) {
         if(!s.contains(val)) {
            complement.add(val);
         }
      }
      return complement;
   }


   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(LinkedSet<T> s) {
      LinkedSet<T> complement = new LinkedSet<>();
   
      Node n = this.front;
      Node p = s.front;
      
      while(p != null || n != null) {
         //if no more elements left in n leave
         if(p != null && n == null) {
            break;
         }
         //if there are more elements in n put all that in the complement set since it means it cannot be in the p
         else if( p == null && n != null) {
            complement.addToBack(n.element);
            n = n.next;
         }
         //if the element in n is bigger than the element in p raise p up
         else if(n.element.compareTo(p.element) > 0) {
            p = p.next;
         
         }
         //if the element in n is less than the element in p we know that element does not exist in p
         //basically p passed the n element so element cannot exist in p.
         else if (n.element.compareTo(p.element) < 0){
            complement.addToBack(n.element);
            n = n.next;
         }
         //they are equal so no add just increment the pointers
         else {
            p = p.next;
            n = n.next;
         }
      }
   
      return complement;
   }


   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in ascending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> iterator() {
      return new linkedIterator();
   }

   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in descending natural order.
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> descendingIterator() {
      return new descendingIterator();
   }
 
   /**
    * Returns an iterator over the members of the power set
    * of this LinkedSet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new powerSetIterator();
   }



   //////////////////////////////
   // Private utility methods. //
   //////////////////////////////

   // Feel free to add as many private methods as you need.

   private void insertNode(Node n, Node p) {
      if(size == 0) { //if there are no current nodes in the structure
         front = n;
         rear = n;
      }
      else if(p == null) {//if Node n contains the biggest value so it must be inserted in the back
         //node n connects to the previous rear
         n.prev = rear;
         //the previous rear connect with n
         rear.next = n;
         //connect rear
         rear = n;
      }
      else if(p.equals(front)) { //add in the front + there already exists linked structure
         //make node n aware of the existing structure
         n.next = front;
         //make existing structure aware of the node n
         front.prev = n;
         //update front
         front = n;
      }
      else { 
         n.next = p;
         n.prev = p.prev;
      
         n.prev.next = n;
         p.prev = n;
      }
      size++;
   }

   private void removeNode(Node p) {
      if(p.equals(front)) { //if p points to a node in the front
         if(size == 1) {//special case when it is the only node
            front = null;
            rear = null;
         }
         else {//typical case when p points to node in front without being the only node
            front = front.next;
            front.prev.next = null;
            front.prev = null;
         }
      }
      else if(p.equals(rear)) { //if p points to the same node in back
         rear = rear.prev;
         rear.next.prev = null;
         rear.next = null;
      }
      else {//if p points to a node in the middle
         p.prev.next = p.next;
         p.next.prev = p.prev;
      }
      size--;
   }

   //adds to the back of the linkedlist in constant time
   //assumes that this element placement is consistent with the natural order of the linkedset
   private void addToBack(T element) {
      Node n = new Node(element);
      if(size == 0) {
         front = n;
         rear = n;
      }
      else { //add in back
         n.prev = rear;
         rear.next = n;
         rear = n;
      }
      size++;
   }

   private void addToFront(T element) {
      Node n = new Node(element);
      if(size == 0) { //if there are no current nodes in the structure
         front = n;
         rear = n;
      }
      else {
         n.next = front;
         front.prev = n;
         front = n;
      }
      size++;
   }

   
   ////////////////////
   // Nested classes //
   ////////////////////

   private class powerSetIterator implements Iterator<Set<T>> {
      private int current ;
      private int psSize;
      
      public powerSetIterator() {
         current = 0;
         psSize = 1 << size;
      }
      
      @Override
      public boolean hasNext() {
         return current < psSize;
      }
   
   
      @Override
      public Set<T> next() {
         LinkedSet<T> powerSet = new LinkedSet<>();
         if(!hasNext()) {
            throw new NoSuchElementException();
         }
      
         String binaryString = Integer.toBinaryString(current);
         char[] bitStringRep = binaryString.toCharArray();
         //this point we have a binary representation of the current with each bit taking up one node in the array
         Node p = rear;
         if(p == null) {
            return powerSet;
            
         }
         
         for(int i = bitStringRep.length - 1; i >= 0; i--) {
            if(bitStringRep[i] == '1') {
               powerSet.addToFront(p.element);
            }
            p = p.prev;
         }
         
         current++;
         return powerSet;
      }
   
   
   }
   private class linkedIterator implements Iterator<T> {
      private Node current;
      
      public linkedIterator() {
         current = front;
      }
      
      public boolean hasNext() {
         return current != null;
      }
   
      public T next() {
         if(!hasNext()) {
            throw new NoSuchElementException();
         }
      
         T result = current.element;
         current = current.next;
         return result;
      }
   
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   private class descendingIterator implements Iterator<T> {
      private Node current = rear;
   
      public boolean hasNext() {
         return current != null;
      }
   
      public T next() {
         if(!hasNext()) {
            throw new NoSuchElementException("there is no elements left");
         }
      
         T next = current.element;
         current = current.prev;
         return next;
      }
   
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   //////////////////////////////////////////////
   // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
   //////////////////////////////////////////////

   /**
    * Defines a node class for a doubly-linked list.
    */
   class Node {
      /** the value stored in this node. */
      T element;
      /** a reference to the node after this node. */
      Node next;
      /** a reference to the node before this node. */
      Node prev;
   
      /**
       * Instantiate an empty node.
       */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }
   
      /**
       * Instantiate a node that containts element
       * and with no node before or after it.
       */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }

}

