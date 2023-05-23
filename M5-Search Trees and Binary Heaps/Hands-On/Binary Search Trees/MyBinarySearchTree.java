import java.util.Iterator;

import javax.lang.model.util.ElementScanner6;

public class MyBinarySearchTree<T extends Comparable<T>>  {

   //root node
   private Node root;  
   //number of nodes in the binarytree
   private int size;
   
   class Node {
      Node left;
      Node right;
      T element;
   
      public Node(T element) {
         this.element = element;
      }
   }

   public int height(Node n) {
      //base case
      //height of an empty tree , where n == null is 0
      //an empty tree cannot contribute to the height
      if(n == null) {
         return 0;
      }
      //recursive case/ reduction step
      //else return the height of the current node (which is always 1) + the height of the tallest subtree of this node
      int leftHeight = height(n.left);
      int rightHeight = height(n.right);
      return 1 + Math.max(leftHeight, rightHeight); 
   }
   
   public int height() {
      return height(root);
   }

   /**
    * a method that recursively counts all the nodes in the subtree rooted at n
    * @param n the root of the subtree
    * @return number of Nodes in that subtree
    */
   public int size(Node n) {
      //base case
      if(n == null) {
         return 0;
      }
      //recrusive case
      //in some order
      //a. visit the root node of the subtree (current Node)
      //b. recursively count all nodes in the left subtree
      //c.recursively count all nodes in the right subtree
      int sizeOfLeft = size(n.left);
      int sizeOfRight = size(n.right);
      //1 is accounting for the current node this method is calling on
      //this will be postorder
      //LRN
      return 1 + (sizeOfLeft + sizeOfRight);
   }
   
   //recursively counts all nodes in the current tree
   public int size() {
      return size(root);
   }

   //recursive search method on a binary tree
   public boolean search(Node n, T target) {
      //three places the target can be the current node, some node in the left subtree, some node in the right subtree, or not there at all
      //Base Case
      //(0)the target isnt there in this subtree, we have reached an empty tree
      if(n == null) {
         return false;
      }
      
      //Recursive case
      //(1)the target in the current node
      if(n.element.equals(target)) {
         return true;
      }
   
      //(2)the target might be in a node in the left subtree
      boolean isFound = search(n.left, target);
      //(3) the target might be in a node in the right subtree
      if(!isFound) {
         isFound = search(n.right, target);
      }
      
      //if it is in the left or right subtree this will return true otherwise false
      return isFound;
   }

   public void delete(T element) {
      Node n = root;
      Node parent = null;
      int cmp = 0;
      while(n != null) {
         cmp = n.element.compareTo(element);  
         if(cmp > 0) {
            parent = n;
            n = n.left;
         }
         else if(cmp < 0) {
            parent = n;
            n = n.right;
         }
         else {
            break;
         }
      }
   
      //case 0
      if(n.left == null && n.right == null) {
         case0(n, parent);
      }
      //case 1
      else if(n.left == null || n.right == null) {
         case1(n, parent);
      }
      //case 2
      else {
         case2(n);
      }
   }
   
   private void case0(Node child, Node parent) {
      if(parent.element.compareTo(child.element) > 0) {
         parent.left = null;
      }
      else{
         parent.right = null;
      }
      size--;
   }

   private void case1(Node child, Node parent) {
      if(parent.element.compareTo(child.element) < 0) {
         if(child.left == null) {
            parent.right = child.right;
         }
         else{
            parent.right = child.left;
         }
      }else {
         if(child.left == null) {
            parent.left = child.right;
         }
         else{
            parent.left = child.left;
         }
      }
      size--;
   }

   private void case2(Node x) {
      Node n = x.left;
      Node parent = x;
      while(n.right != null) {
         parent = x;
         n = n.right;
      }
   
      T temp = n.element;
      //replacement would be the right most node in the bst
      if(n.left == null) {
         //leaf node is the right most
         case0(n, parent);
         x.element = temp;
      }
      else {
         //node with one non empty subtree is the right most
         case1(n, parent);
         x.element = temp;
      }
   }
   public void add(T element) {
      if(root == null) {
         root = new Node(element);
         size++;
         return;
      }
   
      Node parent = null;
      Node n = root;
      int cmp = 0;
     //if we fall out the tree the node before the fall must be the parent node for this element
      while(n != null) {
         //saves the n before the changes the are made, so if the n were to become null the parent position would be saved
         parent = n;
         cmp = n.element.compareTo(element);  
         //if the current element is bigger than the element trying to be added the element must be added somewhere in the left subtree
         if(cmp > 0) {
            n = n.left;
         }
         //if the current element is bigger than the element trying to be added the element must be added somewhere in the right subtree
         else if(cmp < 0) {
            n = n.right;
         }
         //we shouldnt add duplicates so just dont do anything
         else {
            return;
         }
      }
   
      //at this point we know what the parent of the Node containg the element should be
      //if the parent element is bigger the new element should go to its left
      if(cmp > 0) {
         parent.left = new Node(element);
      }else {
         parent.right = new Node(element);
      }
      size++;
   }

   //search the whole tree at the trees root
   public boolean searchBst1(T target) {
      return searchBst1(root, target);
   }
   
   //search at a given subroot
   public boolean searchBst1(Node n, T target) {
      //base case
      if(n == null) {
         return false;
      }
   
      //recursive case
      int cmp = n.element.compareTo(target);
      if(cmp == 0) {
         return true;
      }
      else if(cmp > 0) {
         return searchBst1(n.left, target);
      }
      else {
         return searchBst1(n.right, target);
      }
   }
   
 
   
   

   //iterative approahc to finding target in bst
   public boolean searchBst2(Node n, T target) {
      boolean found = false;
      while(n != null && !found) {
         if(n.element.compareTo(target) == 0) {
            found = true;
         }
         else if(n.element.compareTo(target) > 0) {
            n = n.left;
         }
         else {
            n = n.right;
         }
      }
      return found;
   }
   
   public Node getRoot() {
      return new Node(root.element);
   }
   

   

   
}
