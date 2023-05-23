public class Node {

    private Object element;
    private Node next;

    public Node (Object element) {
        this.element = element;
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

}
