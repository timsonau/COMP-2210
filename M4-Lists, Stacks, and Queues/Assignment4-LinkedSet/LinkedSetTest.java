import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LinkedSetTest {


   /** Typical Case **/
   @Test public void addTest1() {
      LinkedSet<Integer> intSet = new LinkedSet<>();
      intSet.add(1);
      intSet.add(3);
      intSet.add(4);
      intSet.add(0);
      intSet.add(-1);
      intSet.add(7);
      String expected = "[-1, 0, 1, 3, 4, 7]";
      String actual = intSet.toString();
      assertEquals(expected, actual);
   }
}
