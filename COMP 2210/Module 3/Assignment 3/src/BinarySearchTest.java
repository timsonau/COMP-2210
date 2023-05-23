import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void BinarySearchTest1() {
        Integer[] a =  {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 6, 6, 8, 8, 8, 8, 8, 8, 10};
        Integer target = 8;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 14;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest2() {
        Integer[] a =  {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 6, 6, 8, 8, 8, 8, 8, 8};
        Integer target = 1;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 0;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest3() {
        Integer[] a =  {0, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8};
        Integer target = 7;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 1;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest4() {
        Integer[] a =  {0, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8};
        Integer target = 7;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 5;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest5() {
        Integer[] a =  {0, 0, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8};
        Integer target = 0;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 0;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest6() {
        Integer[] a =  {0, 0, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8};
        Integer target = 0;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 1;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest7() {
        Integer[] a =  {2};
        Integer target = 0;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = -1;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest8() {
        Integer[] a =  {0, 2};
        Integer target = 2;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 1;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest9() {
        Integer[] a =  {1, 3, 7, 9};
        Integer target = 0;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = -1;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest10() {
        Integer[] a =  {1, 3, 7, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 11, 11 ,11};
        Integer target = 11;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 16;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest11() {
        Integer[] a =  {};
        Integer target = 9;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = -1;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest12() {
        Integer[] a =  {12, 12};
        Integer target = 12;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 1;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest13() {
        Integer[] a =  {12, 12, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 77, 77, 77, 77,};
        Integer target = 56;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 11;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest14() {
        Integer[] a =  {12, 12, 56, 56, 56, 56, 56, 56, 56, 56, 56, 56, 77, 77, 77, 77, 100, 100, 100, 100, 100};
        Integer target = 100;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 20;
        int actual = BinarySearch.<Integer>lastIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest15() {
        Integer[] a =  {12};
        Integer target = 9;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = -1;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest16() {
        Integer[] a =  {12};
        Integer target = 12;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 0;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest17() {
        Integer[] a =  {12, 12};
        Integer target = 12;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 0;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }

    @Test
    public void BinarySearchTest18() {
        Integer[] a =  {12, 12, 90, 95, 100, 100, 100, 100, 145, 145, 900, 900, 900, 1000, 1050, 1050, 1055};
        Integer target = 1050;
        Comparator<Integer> integerComparator = new AscendingInteger();

        int expected = 14;
        int actual = BinarySearch.<Integer>firstIndexOf(a, target, integerComparator);

        assertEquals(expected, actual);
    }


}