public class SinglyLinked {
    public static void main(String[] args) {
        SinglyLinked linked = new SinglyLinked();
        linked.examples();
        linked.addExample();


    }

    private class Node {
        private Object element;
        private Node next;

        public Node (Object element) {
            this.element = element;
        }

        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }

        public int length(Node n) {
            Node p = n;
            int length = 0;

            while(p != null) {
                length ++;
                p = p.next;
            }

            return length;
        }

        public boolean contains(Node n, Object target) {
            Node p = n;

            while(p != null) {
                if(p.element.equals(target)) {
                    return true;
                }
                p = p.next;
            }

            return false;
        }

        public void add(Node front, Object element) {
            Node newNode = new Node(element, front.next);
            front = newNode;
        }

        public void add2(Node front, Object element, int k) {
            Node newNode = new Node(element);

            if(k == 1) {
                Node p = null;
            }
            else {


                Node p = this;

                int count = 0;
                while (p != null && (count < k - 2)) {
                    count++;
                    p = p.next;
                }

                newNode.next = p.next;
                p.next = newNode;
            }

        }


    }

    public void examples() {
        Node n = new Node(1);
        n.next = new Node(3);
        n.next = new Node(2, n.next);

    }

    public void addExample() {
        Node n = new Node(1, new Node(2));
        Node p = new Node(1, new Node(2));
        n.add2(p, 4, 1);
    }

}
