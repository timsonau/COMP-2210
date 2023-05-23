public class MBSTClient {
   public static void main(String[] args) {
      MyBinarySearchTree<Integer> mbst = new MyBinarySearchTree<>();
      mbst.add(10);
      mbst.add(9);
      mbst.add(11);
      mbst.add(8);
      mbst.delete(9);
      mbst.add(15);
      mbst.add(14);
      mbst.add(16);
      mbst.delete(15);
      mbst.delete(10);
   }
}
