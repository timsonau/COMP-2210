import java.util.*;
public class TesterDriver{
   public static void main(String[] args) {
      LinkedSet<Integer> intSet = new LinkedSet<>();
      Iterator itr = intSet.powerSetIterator();
      
      System.out.println(itr.next());
      System.out.println(itr.next());
      System.out.println(itr.next());
   }

}