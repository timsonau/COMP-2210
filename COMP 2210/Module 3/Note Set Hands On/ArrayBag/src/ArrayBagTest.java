import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBagTest {

    @Test
    public void addTest1() {
        Bag<Integer> bag = new ArrayBag<Integer>();
        boolean expected = true;
        boolean actual = bag.add(2);
        assertEquals(expected, actual);
    }

    @Test
    public void addTest2() {
        Bag<Integer> bag = new ArrayBag<Integer>();
        boolean expected = false;
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void testContains1() {
        Bag<Integer> bag = new ArrayBag<>(5);
        bag.add(1);
        bag.add(2);
        bag.add(11);
        bag.add(23);
        bag.add(1);

        boolean expected = true;
        boolean actual = bag.contains(23);

        assertEquals(expected, actual);

    }
}