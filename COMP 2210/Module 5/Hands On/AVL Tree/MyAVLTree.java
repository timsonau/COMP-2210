public class MyAVLTree<T extends Comparable<T>> {
    /////////////////
	//   Fields    //
	/////////////////

	// the root of this avl tree
	private Node root;

	// the number of nodes in this avl tree
	private int size;

	/** The Node structure for this avl tree. */
	private class Node {
		private T element;
		private Node left;
		private Node right;
        //very useful to know the height of a given node to a subroot of a tree
        private int height;

		/** Contructs a node containing the given element. */
		public Node(T elem) {
			element = elem;
			height = 1;
		}
    
    }

    public void add(T element) {
        //replaces the current AVL tree with a new AVL tree with the added Node containg the element
        root = put(element, root);
    }


    //puts a given element in an appropriate node
    //n will be the start node
    public Node put(T element, Node n) {
        //recurisvely walk down the avl tree to find the right spot
        //the base case
        //when n == null we are at the place where n should go, the bottom of the tree!
        if(n == null) {
            return new Node(element);
        }

        //compares the element wanting to be added to this cool AVL party to the current element of the node being traversed.
        int cmp = element.compareTo(n.element);
        
        //if the element wanting to be added is bigger go to the right
        if(cmp > 0) {
            //replaces the current right AVL sub-tree with a new right AVL sub-tree with the added Node containg the element
            n.right = put(element, n.right);
        }
        
        //if the element wanting to be added is smaller go to the left.
        if(cmp < 0) {
            //replaces the current right AVL sub-tree with a new right AVL sub-tree with the added Node containg the element
            n.left = put(element, n.left);
        }
        //updates the height of this tree
        //which is the height of this node (1) + the tallest height of the subtree.
        n.height = 1 + Math.max(height(n.left), height(n.right));
        //will only rebalance a real node, ensures here that n is not null;
        return rebalance(n);

    }

    //returns a rebalanced node 
    public Node rebalance(Node n) {
        //this would be a left straight line
        if(balanceFactor(n) == 2) {
            //if the balance factor is 2 we know it is either a right zigzag of right straight line
            //if it is a zigzag we need an extra operations
            //rotate the middle node right once
            if(balanceFactor(n.right) < 0) {
                n.right = rotateRight(n.right);
            }
            //at this point we know it is a right stratight line
            //fix the rotation real quick
            n = rotateLeft(n);
        }
    }

    public Node rotateLeft(Node n) {
        Node p = n.right;
        n.right = p.left;
        p.left = n;
        return p;
    }

    //returns a balance factor of a given node
    public int balanceFactor(Node n) {
        
        return height(n.right) - height(n.left);
    }

    //returns a height of a given node
    public int height(Node n) {
        //if an empty node is given that height will always be 0
        if(n == null) {
            return 0;
        }
        //else now we know the n is a node with height so return the field height of that node
        return n.height;
    }
}
