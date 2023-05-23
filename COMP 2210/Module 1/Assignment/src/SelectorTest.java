import static org.junit.Assert.*;
import org.junit.Test;

public class SelectorTest {

    ///////////////////////////
    //test cases for min()   //
    ///////////////////////////

    //illegal cases for min()
    /**Tests min method with a.length = 0 **/
    @Test
    public void testMin_IllegalCase1() {
        int[] a = new int[0];
        try {
            Selector.min(a);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests min method when a = null **/
    @Test
    public void testMin_IllegalCase2() {
        int[] a = null;
        try {
            Selector.min(a);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //boundary cases for min()
    /**Tests min method with a.length = 1 **/
    @Test
    public void testMin_BoundaryCase1() {
        int[] a = {2};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with a.length = 2 **/
    @Test
    public void testMin_BoundaryCase2() {
        int[] a = {2,1};
        int expected = 1;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with MAX int value **/
    @Test
    public void testMin_BoundaryCase3() {
        int[] a = {4, Integer.MAX_VALUE, 3, 7, 5};
        int expected = 3;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with MIN int value **/
    @Test
    public void testMin_BoundaryCase4() {
        int[] a = {1, 6, 7, Integer.MIN_VALUE, 9};
        int expected = Integer.MIN_VALUE;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    //Typical Cases min()
    /**Tests min method with typical int values in a **/
    @Test
    public void testMin_TypicalCase1() {
        int[] a = {2, 8, 7, 3, 4};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with typical int values in a **/
    @Test
    public void testMin_TypicalCase2() {
        int[] a = {5, 9, 1, 7, 3};
        int expected = 1;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with typical int values in a **/
    @Test
    public void testMin_TypicalCase3() {
        int[] a = {8, 7, 6, 5, 4};
        int expected = 4;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    //special cases for min()
    /**Tests min method with duplicate minimum values**/
    @Test
    public void testMin_SpecialCase1() {
        int[] a = {3,2,2,2,3};
        int expected = 2;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with minimum values in the back **/
    @Test
    public void testMin_SpecialCase2() {
        int[] a = {222, 78, 99, 60, 60};
        int expected = 60;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    /**Tests min method with minimum values in the front **/
    @Test
    public void testMin_SpecialCase3() {
        int[] a = {11, 11, 43, 88, 100};
        int expected = 11;
        int actual = Selector.min(a);
        assertEquals(expected, actual);
    }

    ///////////////////////////
    //test cases for max()   //
    ///////////////////////////

    //illegal cases for max()
    /**Tests max method with a.length = 0 **/
    @Test
    public void testMax_IllegalCase1() {
        int[] a = new int[0];
        try {
            Selector.max(a);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests max method when a = null **/
    @Test
    public void testMax_IllegalCase2() {
        int[] a = null;
        try {
            Selector.max(a);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //boundary cases for max()
    /**Tests max method with a.length = 1 **/
    @Test
    public void testMax_BoundaryCase1() {
        int[] a = {2};
        int expected = 2;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    /**Tests max method with a.length = 2 **/
    @Test
    public void testMax_BoundaryCase2() {
        int[] a = {2,1};
        int expected = 2;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    /**Tests max method with MAX int value **/
    @Test
    public void testMax_BoundaryCase3() {
        int[] a = {4, Integer.MAX_VALUE, 3, 7, 5};
        int expected = Integer.MAX_VALUE;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    /**Tests max method with MIN int value **/
    @Test
    public void testMax_BoundaryCase4() {
        int[] a = {1, 6, 7, Integer.MIN_VALUE, 9};
        int expected = 9;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    //special cases for max()
    /**Tests max method with duplicate maximum values**/
    @Test
    public void testMax_SpecialCase1() {
        int[] a = {3,3,2,2,3};
        int expected = 3;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    /**Tests max method with maximum values in the back **/
    @Test
    public void testMax_SpecialCase2() {
        int[] a = {222, 222, 99, 600, 600};
        int expected = 600;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    /**Tests max method with maximum values in the front **/
    @Test
    public void testMax_SpecialCase3() {
        int[] a = {110, 110, 43, 88, 100};
        int expected = 110;
        int actual = Selector.max(a);
        assertEquals(expected, actual);
    }

    ///////////////////////////
    //test cases for kmin()   //
    ///////////////////////////

    //illegal cases for kmin()
    /**Tests kmin method with a.length = 0 **/
    @Test
    public void testKMin_IllegalCase1() {
        int[] a = new int[0];
        int k = 0;
        try {
            Selector.kmin(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests kmin method when a = null **/
    @Test
    public void testKMin_IllegalCase2() {
        int[] a = null;
        int k = 1;
        try {
            Selector.kmin(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /** Tests kmin method when k < 1 **/
    @Test
    public void testKMin_IllegalCase3() {
        int[] a = {1, 5, 3, 5, 7};
        int k = -1;
        try {
            Selector.kmin(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /** Tests kmin method when k > a.length **/
    @Test
    public void testKMin_IllegalCase4() {
        int[] a = {7, 6, 6, 8, 9, 10, 11};
        int k = 8;
        try {
            Selector.kmin(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //kmin() boundary cases
    /**Tests kmin method with a.length = 1 **/
    @Test
    public void testKMin_BoundaryCase1() {
        int[] a = {2};
        int expected = 2;
        int actual = Selector.kmin(a, 1);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with a.length = 2 **/
    @Test
    public void testKMin_BoundaryCase2() {
        int[] a = {1,2};
        int expected = 2;
        int actual = Selector.kmin(a, 2);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with MAX int value **/
    @Test
    public void testKMin_BoundaryCase3() {
        int[] a = {4, Integer.MAX_VALUE, 3, 7, 5};
        int expected = Integer.MAX_VALUE;
        int actual = Selector.kmin(a, 5);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with MIN int value **/
    @Test
    public void testKMin_BoundaryCase4() {
        int[] a = {1, 6, 7, Integer.MIN_VALUE, 9};
        int expected = Integer.MIN_VALUE;
        int actual = Selector.kmin(a, 1);
        assertEquals(expected, actual);
    }

    //Typical Cases min()
    /**Tests kmin method with typical int values in a, and k **/
    @Test
    public void testKMin_TypicalCase1() {
        int [] a = {2, 8, 7, 3, 4};
        int k = 1;
        int expected = 2;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with typical int values in a, and k **/
    @Test
    public void testKMin_TypicalCase2() {
        int [] a = {5, 9, 1, 7, 3};
        int k = 3;
        int expected = 5;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with typical int values in a, and k **/
    @Test
    public void testKMin_TypicalCase3() {
        int [] a = {8, 2, 8, 7, 3, 3, 4};
        int k = 3;
        int expected = 4;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    //special cases
    /**Tests kmin method with all duplicates in a, and k is larger than the number of distinct values in the array**/
    @Test
    public void testKMin_SpecialCase1() {
        int[] a = {7, 7, 7, 7, 7};
        int k = 4;
        try {
            Selector.kmin(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests kmin method with all duplicates in a, and k is equal to the number of distinct values in the array**/
    @Test
    public void testKMin_SpecialCase2(){
        int[] a = {7, 7, 7, 7, 7};
        int k = 1;
        int expected = 7;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with duplicates in the front **/
    @Test
    public void testKMin_SpecialCase3(){
        int[] a = {2, 2, 2, 7, 8};
        int k = 3;
        int expected = 8;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmin method with duplicates in the middle **/
    @Test
    public void testKMin_SpecialCase4() {
        int[] a = {3, 6, 6, 90, 20, 20, 20};
        int k = 3;
        int expected = 20;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }


    ///////////////////////////
    //test cases for kmax()   //
    ///////////////////////////

    //illegal cases for kmax()
    /**Tests kmax method with a.length = 0 **/
    @Test
    public void testKMax_IllegalCase1() {
        int[] a = new int[0];
        int k = 0;
        try {
            Selector.kmax(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests kmax method when a = null **/
    @Test
    public void testKMax_IllegalCase2() {
        int[] a = null;
        int k = 1;
        try {
            Selector.kmax(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /** Tests kmax method when k < 1 **/
    @Test
    public void testKMax_IllegalCase3() {
        int[] a = {1, 5, 3, 5, 7};
        int k = -1;
        try {
            Selector.kmax(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /** Tests kmax method when k > a.length **/
    @Test
    public void testKMax_IllegalCase4() {
        int[] a = {7, 6, 6, 8, 9, 10, 11};
        int k = 8;
        try {
            Selector.kmax(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //kmax() boundary cases
    /**Tests kmax method with a.length = 1 **/
    @Test
    public void testKMax_BoundaryCase1() {
        int[] a = {2};
        int expected = 2;
        int actual = Selector.kmin(a, 1);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with a.length = 2 **/
    @Test
    public void testKMax_BoundaryCase2() {
        int[] a = {3, 2};
        int expected = 2;
        int actual = Selector.kmax(a, 2);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with MAX int value **/
    @Test
    public void testKMax_BoundaryCase3() {
        int[] a = {4, Integer.MAX_VALUE, 3, 7, 5};
        int expected = Integer.MAX_VALUE;
        int actual = Selector.kmax(a, 1);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with MIN int value **/
    @Test
    public void testKMax_BoundaryCase4() {
        int[] a = {1, 6, 7, Integer.MIN_VALUE, 9};
        int expected = Integer.MIN_VALUE;
        int actual = Selector.kmax(a, 5);
        assertEquals(expected, actual);
    }

    //typical cases for kmax()

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase1() {
        int [] a = {2, 8, 7, 3, 4};
        int k = 1;
        int expected = 8;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase2() {
        int [] a = {5, 9, 1, 7, 3};
        int k = 3;
        int expected = 5;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase3() {
        int [] a = {8, 2, 8, 7, 3, 3, 4};
        int k = 3;
        int expected = 4;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    //special cases for kmax()
    /**Tests kmax method with all duplicates in a, and k is larger than the number of distinct values in the array**/
    @Test
    public void testKMax_SpecialCase1() {
        int[] a = {7, 7, 7, 7, 7};
        int k = 4;
        try {
            Selector.kmax(a, k);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests kmax method with all duplicates in a, and k is equal to the number of distinct values in the array**/
    @Test
    public void testKMax_SpecialCase2(){
        int[] a = {9, 9, 9, 9, 9};
        int k = 1;
        int expected = 9;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with duplicates in the front **/
    @Test
    public void testKMax_SpecialCase3(){
        int[] a = {3, 3, 3, 4, 5, 10, 80, 90};
        int k = 3;
        int expected = 10;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with duplicates in the middle **/
    @Test
    public void testKMax_SpecialCase4() {
        int[] a = {3, 6, 6, 90, 20, 20, 20};
        int k = 3;
        int expected = 6;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with duplicates in the back **/
    @Test
    public void testKMax_SpecialCase5() {
        int[] a = {3, 6, 6, 90, 90, 90, 90};
        int k = 2;
        int expected = 6;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    ///////////////////////////
    //test cases for range() //
    ///////////////////////////

    //illegal cases for range()
    /**Tests range method with a.length = 0 **/
    @Test
    public void testRange_IllegalCase1() {
        int[] a = new int[0];
        int low = 0;
        int high = 0;
        try {
            Selector.range(a, low, high);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests range method when a = null **/
    @Test
    public void testRange_IllegalCase2() {
        int[] a = null;
        int low = 4;
        int high = 7;
        try {
            Selector.range(a, low, high);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //range() boundary cases
    /**Tests range method with a.length = 1 & Qualifying value**/
    @Test
    public void testRange_BoundaryCase1() {
        int[] a = {2};
        int low = 2;
        int high = 2;
        int[] expected = {2};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with a.length = 1 & without Qualifying value**/
    @Test
    public void testRange_BoundaryCase2() {
        int[] a = {4};
        int low = 1;
        int high = 3;
        int[] expected = {};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests Range method with a.length = 2 & Qualifying value**/
    @Test
    public void testRange_BoundaryCase3() {
        int[] a = {3, 2};
        int low = 1 ;
        int high = 4;
        int[] expected = {3, 2};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests Range method with a.length = 2 & without Qualifying value**/
    @Test
    public void testRange_BoundaryCase4() {
        int[] a = {3, 2};
        int low = 5 ;
        int high = 9;
        int[] expected = {};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }
    /**Tests Range method with MAX & MIN int value **/
    @Test
    public void testRange_BoundaryCase5() {
        int[] a = {4, Integer.MAX_VALUE, 3, 7, Integer.MIN_VALUE};
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        int[] expected = {4, Integer.MAX_VALUE, 3, 7, Integer.MIN_VALUE};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    //typical cases for range()

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase1() {
        int [] a = {2, 8, 7, 3, 4};
        int low = 1;
        int high = 5;
        int[] expected = {2, 3, 4};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase2() {
        int [] a = {5, 9, 1, 7, 3};
        int low = 3;
        int high = 5;
        int[] expected = {5, 3};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase3() {

    }

    //special cases for range()
    /**Tests range method with all duplicates within the range**/
    @Test
    public void testRange_SpecialCase1() {
        int[] a = {9, 9, 9, 9, 9, 9, 9};
        int low = 8;
        int high = 9;
        int[] expected = {9, 9, 9, 9, 9, 9, 9};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with all duplicates not within the range**/
    @Test
    public void testRange_SpecialCase2(){
        int[] a = {9, 9, 9, 9, 9, 9, 9};
        int low = 10;
        int high = 11;
        int[] expected = {};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with duplicates in the front **/
    @Test
    public void testRange_SpecialCase3(){
        int[] a = {9, 9, 4, 5, 10, 2, 7};
        int low = 9;
        int high = 12;
        int[] expected = {9, 9, 10};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with duplicates in the middle **/
    @Test
    public void testRange_SpecialCase4() {
        int[] a = {1, 2, 4, 9, 9, 2, 7};
        int low = 6;
        int high = 12;
        int[] expected = {9, 9, 7};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);

    }

    /**Tests range method with duplicates in the back **/
    @Test
    public void testRange_SpecialCase5() {
        int[] a = {1, 2, 4, 9, 9, 2, 7, 7};
        int low = 6;
        int high = 11;
        int[] expected = {9, 9, 7, 7};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with duplicates scattered **/
    @Test
    public void testRange_SpecialCase6() {
        int[] a = {1, 2, 7, 9, 7, 2, 7, 7};
        int low = 7;
        int high = 7;
        int[] expected = {7, 7, 7, 7};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    /**Tests range method with low > high**/
    @Test
    public void testRange_SpecialCase7() {
        int[] a = {1, 2, 7, 9, 4, 2, 3, 7};
        int low = 10;
        int high = 7;
        int[] expected = {};
        int[] actual = Selector.range(a, low, high);
        assertArrayEquals(expected, actual);
    }

    ////////////////////////////
    //test cases for ceiling()//
    ////////////////////////////

    //illegal cases for ceiling()
    /**Tests ceiling method with a.length = 0 **/
    @Test
    public void testCeiling_IllegalCase1() {
        int[] a = new int[0];
        int key = 7;
        try {
            Selector.ceiling(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests ceiling method when a = null **/
    @Test
    public void testCeiling_IllegalCase2() {
        int[] a = null;
        int key = 9;
        try {
            Selector.ceiling(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests ceiling method when there is no qualifying value **/
    @Test
    public void testCeiling_IllegalCase3() {
        int[] a = {1, 6, 7, 9, 120};
        int key = 121;
        try {
            Selector.ceiling(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //boundary cases for ceiling()
    /**Tests ceiling method with a.length = 1 & Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase1() {
        int[] a = {2};
        int key = 1;
        int expected = 2;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Ceiling method with a.length = 1 & without Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase2() {
        int[] a = {4};
        int key = 5;
        try {
            Selector.ceiling(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests Ceiling method with a.length = 2 & Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase3() {
        int[] a = {7, 9};
        int key = 6;
        int expected = 7;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Ceiling method with a.length = 2 & without Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase4() {
        int[] a = {4, 9};
        int key = 10;
        try {
            Selector.ceiling(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests Ceiling method with MAX int value **/
    @Test
    public void testCeiling_BoundaryCase5() {
        int[] a = {3, Integer.MAX_VALUE, 8, 10, 11};
        int key = Integer.MAX_VALUE;
        int expected = Integer.MAX_VALUE;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Ceiling method with MIN int value **/
    @Test
    public void testCeiling_BoundaryCase6() {
        int[] a = {3, Integer.MIN_VALUE, 8, 10, 11};
        int key = Integer.MIN_VALUE;
        int expected = Integer.MIN_VALUE;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    //typical cases for ceiling()
    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase1() {
        int [] a = {2, 8, 7, 3, 4};
        int key = 1;
        int expected = 2;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase2() {
        int [] a = {5, 9, 1, 7, 3};
        int key = 7;
        int expected = 7;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase3() {
        int [] a = {8, 7, 6, 5, 4};
        int key = 0;
        int expected = 4;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase4() {
        int [] a = {8, 2, 8, 7, 3, 3, 4};
        int key = 5;
        int expected = 7;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    //special case for ceiling()
    /**Tests ceiling method with all duplicates in a **/
    @Test
    public void testCeiling_SpecialCase1() {
        int [] a = {8, 8, 8, 8, 8, 8, 8};
        int key = 5;
        int expected = 8;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with all duplicates in a in the front**/
    @Test
    public void testCeiling_SpecialCase2() {
        int [] a = {8, 8, 2, 7, 9, 81, 83};
        int key = 6;
        int expected = 7;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with all duplicates in a in the middle**/
    @Test
    public void testCeiling_SpecialCase3() {
        int [] a = {8, 8, 2, 7, 7, 81, 83};
        int key = 6;
        int expected = 7;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with all duplicates in a in the back**/
    @Test
    public void testCeiling_SpecialCase4() {
        int [] a = {8, 8, 2, 7, 7, 83, 83};
        int key = 80;
        int expected = 83;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with all duplicates in a scattered**/
    @Test
    public void testCeiling_SpecialCase5() {
        int [] a = {8, 3, 2, 3, 7, 83, 3};
        int key = 3;
        int expected = 3;
        int actual = Selector.ceiling(a, key);
        assertEquals(expected, actual);
    }

    ////////////////////////////
    //test cases for floor()//
    ////////////////////////////

    //illegal cases for floor()
    /**Tests floor method with a.length = 0 **/
    @Test
    public void testFloor_IllegalCase1() {
        int[] a = new int[0];
        int key = 7;
        try {
            Selector.floor(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests floor method when a = null **/
    @Test
    public void testFloor_IllegalCase2() {
        int[] a = null;
        int key = 9;
        try {
            Selector.floor(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests floor method when there is no qualifying value **/
    @Test
    public void testFloor_IllegalCase3() {
        int[] a = {1, 6, 7, 9, 120};
        int key = 0;
        try {
            Selector.floor(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    //boundary cases for floor()
    /**Tests Floor method with a.length = 1 & Qualifying value**/
    @Test
    public void testFloor_BoundaryCase1() {
        int[] a = {2};
        int key = 3;
        int expected = 2;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Floor method with a.length = 1 & without Qualifying value**/
    @Test
    public void testFloor_BoundaryCase2() {
        int[] a = {4};
        int key = 3;
        try {
            Selector.floor(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests Floor method with a.length = 2 & Qualifying value**/
    @Test
    public void testFloor_BoundaryCase3() {
        int[] a = {7, 9};
        int key = 10;
        int expected = 9;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Floor method with a.length = 2 & without Qualifying value**/
    @Test
    public void testFloor_BoundaryCase4() {
        int[] a = {4, 9};
        int key = 0;
        try {
            Selector.floor(a, key);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(IllegalArgumentException e) {
            assertTrue(true); //IllegalArgumentException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect Argument"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests Floor method with MAX int value **/
    @Test
    public void testFloor_BoundaryCase5() {
        int[] a = {3, Integer.MAX_VALUE, 8, 10, 11};
        int key = Integer.MAX_VALUE;
        int expected = Integer.MAX_VALUE;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests Floor method with MIN int value **/
    @Test
    public void testFloor_BoundaryCase6() {
        int[] a = {3, Integer.MIN_VALUE, 8, 10, 11};
        int key = Integer.MIN_VALUE;
        int expected = Integer.MIN_VALUE;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    //typical cases for floor()
    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase1() {
        int [] a = {2, 8, 7, 3, 4};
        int key = 6;
        int expected = 4;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase2() {
        int [] a = {5, 9, 1, 7, 3};
        int key = 1;
        int expected = 1;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase3() {
        int [] a = {8, 7, 6, 5, 4};
        int key = 9;
        int expected = 8;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase4() {
        int [] a = {8, 2, 8, 7, 3, 3, 4};
        int key = 5;
        int expected = 4;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    //tests special cases for floor()

    /**Tests floor method with all duplicates in a **/
    @Test
    public void testFloor_SpecialCase1() {
        int [] a = {8, 8, 8, 8, 8, 8, 8};
        int key = 9;
        int expected = 8;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with all duplicates in a in the front**/
    @Test
    public void testFloor_SpecialCase2() {
        int [] a = {8, 8, 2, 7, 9, 81, 83};
        int key = 7;
        int expected = 7;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with all duplicates in a in the middle**/
    @Test
    public void testFloor_SpecialCase3() {
        int [] a = {8, 8, 2, 7, 7, 81, 83};
        int key = 82;
        int expected = 81;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests floor method with all duplicates in a in the back**/
    @Test
    public void testFloor_SpecialCase4() {
        int [] a = {8, 8, 2, 7, 7, 83, 83};
        int key = 84;
        int expected = 83;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }

    /**Tests ceiling method with all duplicates in a scattered**/
    @Test
    public void testFloor_SpecialCase5() {
        int [] a = {8, 3, 2, 3, 7, 83, 3};
        int key = 4;
        int expected = 3;
        int actual = Selector.floor(a, key);
        assertEquals(expected, actual);
    }
}