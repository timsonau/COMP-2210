import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SelectorTest {

    ///////////////////////////
    //test cases for min()   //
    ///////////////////////////

    //illegal cases for min()
    /**Tests min method with coll.length = 0 **/
    @Test
    public void testMin_IllegalCase1() {
        CompareInteger integerComparator = new CompareInteger();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        try {
            Selector.<Integer>min(intList, integerComparator);
            fail("Did not throw Illegal Argument Exception"); //message if any Exception isn't thrown
        }
        catch(NoSuchElementException e) {
            assertTrue(true); //NpSuchElementException is caught code those not move down the lin
        }
        catch(Exception e) {
            fail("threw incorrect exception"); //The exception was not IllegalArgumentException
        }
    }

    /**Tests min method when coll = null **/
    @Test
    public void testMin_IllegalCase2() {
        CompareStrings stringComparator = new CompareStrings();
        ArrayList<String> stringList = null;

        try {
            Selector.<String>min(stringList, stringComparator);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Must throw Illegal Argument Exception");
        }
    }

    /**Tests min method when comp = null **/
    public void testMin_IllegalCase3() {
        CompareInteger integerComparator = null;
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(20);
        intList.add(500);

        try {
            Selector.<Integer>min(intList, integerComparator);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Must throw Illegal Argument Exception");
        }
    }

    //boundary cases for min()
    /**Tests min method with coll.size() = 1 **/
    @Test
    public void testMin_BoundaryCase1() {
        CompareStrings stringComparator = new CompareStrings();
        List<String> stringList = new ArrayList<String>();
        stringList.add("Apples");
        String expected = "Apples";
        String actual = Selector.<String>min(stringList, stringComparator);
        assertTrue(expected.equals(actual));
    }

    /**Tests min method with a.length = 2 **/
    @Test
    public <T> void testMin_BoundaryCase2() {
        CompareStrings stringComparator = new CompareStrings();
        List<String> stringList = new ArrayList<String>();
        stringList.add("Apples");
        stringList.add("Bananas");
        String expected = "Apples";
        String actual = Selector.<String>min(stringList, stringComparator);
        assertEquals(expected, actual);

    }

    /**Tests min method with MAX int value **/
    @Test
    public void testMin_BoundaryCase3() {
        CompareInteger integerComparator = new CompareInteger();
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(499);
        intList.add(Integer.MAX_VALUE);
        intList.add(42);
        intList.add(-99);
        Integer expected = -99;
        Integer actual = Selector.<Integer>min(intList, integerComparator);
        assertEquals(expected, actual);
    }

    /**Tests min method with MIN int value **/
    @Test
    public void testMin_BoundaryCase4() {
        CompareInteger integerComparator = new CompareInteger();
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(499);
        intList.add(100);
        intList.add(42);
        intList.add(Integer.MIN_VALUE);
        Integer expected = Integer.MIN_VALUE;
        Integer actual = Selector.<Integer>min(intList, integerComparator);
        assertEquals(expected, actual);
    }

    //Typical Cases min()
    /**Tests min method with typical T values in coll **/
    @Test
    public void testMin_TypicalCase1() {
        CompareInteger integerComparator = new CompareInteger();
        Collection<Integer> intCollection = new ArrayList<Integer>();
        intCollection.add(5);
        intCollection.add(7777);
        intCollection.add(45610);
        intCollection.add(-1728);
        intCollection.add(2);
        int expected = -1728;
        int actual = Selector.min(intCollection, integerComparator);
        assertEquals(expected, actual);
    }

    /**Tests min method with typical int values in a **/
    @Test
    public void testMin_TypicalCase2() {
        CompareStrings stringComparator = new CompareStrings();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("1111");
        stringArrayList.add("1112");
        stringArrayList.add("F");
        String expected = "1111";
        String actual = Selector.min(stringArrayList, stringComparator);
        assertTrue(expected.equals(actual));
    }

    /**Tests min method with typical int values in a **/
    @Test
    public void testMin_TypicalCase3() {
        CompareInteger integerComparator = new CompareInteger();
        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(2);
        intList.add(8);
        intList.add(7);
        intList.add(3);
        intList.add(4);

        int expected = 2;
        int actual = Selector.min(intList, integerComparator);

        assertEquals(expected, actual);
    }

    //special cases for min()
    /**Tests min method with duplicate minimum values**/
    @Test
    public void testMin_SpecialCase1() {
        CompareStrings stringComparator = new CompareStrings();
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Harry KanE");
        strList.add("Son Heung Messi");
        strList.add("Steven Bergwijn");
        strList.add("Harry Kane");

        String expected = "Harry KanE";
        String actual = Selector.<String>min(strList, stringComparator);
        assertEquals(expected, actual);
    }

    /**Tests min method with minimum values in the back **/
    @Test
    public void testMin_SpecialCase2() {
        CompareInteger integerComparator = new CompareInteger();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(7);
        intList.add(-19);
        intList.add(-100);
        intList.add(20);
        intList.add(-10000);

        int expected = -10000;
        int actual = Selector.<Integer>min(intList, integerComparator);

        assertEquals(expected, actual);

    }

    /**Tests min method with minimum values in the front **/
    @Test
    public void testMin_SpecialCase3() {
        CompareInteger integerComparator = new CompareInteger();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(-70000);
        intList.add(-19);
        intList.add(-100);
        intList.add(20);
        intList.add(-10000);

        Integer expected = -70000;
        Integer actual = Selector.<Integer>min(intList, integerComparator);
        assertEquals(expected, actual);
    }

    ///////////////////////////
    //test cases for max()   //
    ///////////////////////////

    //illegal cases for max()
    /**Tests max method with a.length = 0 **/
    @Test
    public void testMax_IllegalCase1() {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        CompareInteger integerComparator = new CompareInteger();

        try {
            Selector.<Integer>max(intList, integerComparator);
        }
        catch(NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }

    }

    /**Tests max method when a = null **/
    @Test
    public void testMax_IllegalCase2() {
        ArrayList<Integer> intList = null;
        CompareInteger integerComparator = new CompareInteger();

        try {
            Selector.<Integer>max(intList, integerComparator);
        }
        catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }
    }

    /**Tests max method when comp = null **/
    public void testMax_IllegalCase3() {
        CompareInteger integerComparator = null;
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(20);
        intList.add(500);

        try {
            Selector.<Integer>max(intList, integerComparator);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Must throw Illegal Argument Exception");
        }
    }

    //boundary cases for max()
    /**Tests max method with a.length = 1 **/
    @Test
    public void testMax_BoundaryCase1() {
        ArrayList<String> strList = new ArrayList<String>();
        CompareStrings strComparator = new CompareStrings();
        strList.add("yonon");

        String expected = "yonon";
        String actual = Selector.<String>max(strList, strComparator);

        assertEquals(expected, actual);

    }

    /**Tests max method with a.length = 2 **/
    @Test
    public void testMax_BoundaryCase2() {
        ArrayList<String> strList = new ArrayList<String>();
        CompareStrings strComparator = new CompareStrings();
        strList.add("Yonon");
        strList.add("yonon");

        String expected = "yonon";
        String actual = Selector.<String>max(strList, strComparator);

        assertEquals(expected, actual);

    }

    /**Tests max method with MAX int value **/
    @Test
    public void testMax_BoundaryCase3() {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        CompareInteger integerComparator = new CompareInteger();
        intList.add(99);
        intList.add(100);
        intList.add(Integer.MAX_VALUE);

        int expected = Integer.MAX_VALUE;
        int actual = Selector.<Integer>max(intList, integerComparator);

        assertEquals(expected, actual);
    }

    /**Tests max method with MIN int value **/
    @Test
    public void testMax_BoundaryCase4() {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        CompareInteger integerComparator = new CompareInteger();
        intList.add(99);
        intList.add(100);
        intList.add(Integer.MIN_VALUE);

        int expected = 100;
        int actual = Selector.<Integer>max(intList, integerComparator);

        assertEquals(expected, actual);
    }

    //special cases for max()
    /**Tests max method with duplicate maximum values**/
    @Test
    public void testMax_SpecialCase1() {
        ArrayList<String> strList = new ArrayList<String>();
        CompareStrings strComparator = new CompareStrings();
        strList.add("Yonon");
        strList.add("Yonon");
        strList.add("yue");
        strList.add("yue");
        strList.add("sokka");

        String expected = "yue";
        String actual = Selector.<String>max(strList, strComparator);

        assertEquals(expected, actual);
    }

    /**Tests max method with maximum values in the back **/
    @Test
    public void testMax_SpecialCase2() {
        String[] a = {"yolo", "timba", "simba", "zohohoho"};
        Collection<String> coll = Arrays.<String>asList(a);
        CompareStrings strComparator = new CompareStrings();

        String expected = "zohohoho";
        String actual = Selector.<String>max(coll, strComparator);

        assertEquals(expected, actual);


    }

    /**Tests max method with maximum values in the front **/
    @Test
    public void testMax_SpecialCase3() {
        String[] a = {"zzolo", "timba", "simba", "zohohoho"};
        Collection<String> coll = Arrays.<String>asList(a);
        CompareStrings strComparator = new CompareStrings();

        String expected = "zzolo";
        String actual = Selector.<String>max(coll, strComparator);

        assertEquals(expected, actual);
    }

    ///////////////////////////
    //test cases for kmin()   //
    ///////////////////////////

    //illegal cases for kmin()
    /**Tests kmin method with coll.size() = 0 **/
    @Test
    public void testKMin_IllegalCase1() {
        Integer[] emptyArr = {};
        Collection<Integer> emptyColl = Arrays.<Integer>asList(emptyArr);
        CompareInteger integerComparator = new CompareInteger();
        int k = 3;

        try {
            Selector.<Integer>kmin(emptyColl, k, integerComparator);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }
    }

    /**Tests kmin method when coll = null **/
    @Test
    public void testKMin_IllegalCase2() {
        Collection<Integer> nullColl = null;
        CompareInteger comp = new CompareInteger();
        int k = 4;

        try {
            Selector.<Integer>kmin(nullColl, k, comp);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Wrong Exception");
        }

    }

    /** Tests kmin method when k < 1 **/
    @Test
    public void testKMin_IllegalCase3() {
        String[] strArr = {"Timbot", "Timbot", "Timbot", "John", "John", "Ala", "Ala"};
        Collection<String> strColl = Arrays.<String>asList(strArr);
        CompareStrings strComp = new CompareStrings();

        int k = -1;

        try{
            Selector.<String>kmin(strColl, k, strComp);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Wrong Exception");
        }

    }

    /** Tests kmin method when k > number of distinct values **/
    @Test
    public void testKMin_IllegalCase4() {
        String[] strArr = {"Timbot", "Timbot", "Timbot", "John", "John", "Ala", "Ala"};
        Collection<String> strColl = Arrays.<String>asList(strArr);
        CompareStrings strComp = new CompareStrings();

        int k = 4;

        try{
            Selector.<String>kmin(strColl, k, strComp);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Wrong Exception");
        }

    }

    //kmin() boundary cases
    /**Tests kmin method with a.length = 1 **/
    @Test
    public void testKMin_BoundaryCase1() {
        Integer[] intArr = {7};
        Collection<Integer> collInt = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;

        Integer expected = 7;
        Integer actual = Selector.<Integer>kmin(collInt, k, intComp);

        assertEquals(expected, actual);
    }

    /**Tests kmin method with a.length = 2 w/ MAX int & MIN int **/
    @Test
    public void testKMin_BoundaryCase2() {
        Integer[] intArr = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();

        int k = 2;

        Integer expected = Integer.MAX_VALUE;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);
        assertEquals(expected, actual);
    }

    //Typical Cases min()
    /**Tests kmin method with typical int values in coll, comp, and k **/
    @Test
    public void testKMin_TypicalCase1() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        CompareInteger integerComparator = new CompareInteger();
        intArrayList.add(1);
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.add(3);
        int k = 2;
        int expected = 2;
        int actual = Selector.kmin(intArrayList, k, integerComparator);
        assertEquals(expected, actual);

    }

    /**Tests kmin method with typical int values in coll, comp, and k **/
    @Test
    public void testKMin_TypicalCase2() {
        Integer[] intArr = {2, 8, 7, 3, 4};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;

        Integer expected = 2;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    /**Tests kmin method with typical int values in coll, comp, and k **/
    @Test
    public void testKMin_TypicalCase3() {
        Integer[] intArr = {5, 9, 1, 7, 3};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 3;

        Integer expected = 5;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);

    }

    /**Tests kmin method with typical int values in coll, comp, and k **/
    @Test
    public void testKMin_TypicalCase4() {
        Integer[] intArr = {8, 7, 6, 5, 4};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 5;

        Integer expected = 8;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);

    }

    /**Tests kmin method with typical int values in coll, comp, and k = coll.size() **/
    @Test
    public void testKMin_TypicalCase5() {
        Integer[] intArr = {8, 7, 6, 5, 4};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = intColl.size();

        Integer expected = Selector.<Integer>max(intColl, intComp);
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    /**Tests kmin method with typical int values in coll, comp, and k = 1 **/
    @Test
    public void testKMin_TypicalCase6() {
        Integer[] intArr = {8, 7, 6, 5, 4};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;

        Integer expected = Selector.<Integer>min(intColl, intComp);
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    //special cases
    /**Tests kmin method with all duplicates in coll, and k is larger than the number of distinct values in the array**/
    @Test
    public void testKMin_SpecialCase1() {
        Integer[] intArr = {1, 1, 1, 1, 1, 1, 1};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 2;

        try {
            Selector.<Integer>kmin(intColl, k, intComp);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong exception");
        }
    }

    /**Tests kmin method with all duplicates in comp, and k is equal to the number of distinct values in the array**/
    @Test
    public void testKMin_SpecialCase2(){
        Integer[] intArr = {7, 7, 7, 7, 7, 7, 7};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;

        Integer expected = 7;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    /**Tests kmin method with duplicates in the front **/
    @Test
    public void testKMin_SpecialCase3(){
        Integer[] intArr = {7, 7, 7, 3, 3, 3, 1, 1, 1};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;

        Integer expected = 1;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    /**Tests kmin method with duplicates in the middle **/
    @Test
    public void testKMin_SpecialCase4() {
        Integer[] intArr = {7, 7, 7, 3, 3, 3, 1, 1, 1};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 2;

        Integer expected = 3;
        Integer actual = Selector.<Integer>kmin(intColl, k, intComp);

        assertEquals(expected, actual);
    }


    ///////////////////////////
    //test cases for kmax()  //
    ///////////////////////////

    //illegal cases for kmax()
    /**Tests kmax method with a.length = 0 **/
    @Test
    public void testKMax_IllegalCase1() {
        Integer[] emptyArr = {};
        Collection<Integer> emptyColl = Arrays.<Integer>asList(emptyArr);
        CompareInteger integerComparator = new CompareInteger();
        int k = 3;

        try {
            Selector.<Integer>kmin(emptyColl, k, integerComparator);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }

    }

    /**Tests kmax method when a = null **/
    @Test
    public void testKMax_IllegalCase2() {
    }

    /** Tests kmax method when k < 1 **/
    @Test
    public void testKMax_IllegalCase3() {
    }

    /** Tests kmax method when there is no kTh Maximum value **/
    @Test
    public void testKMax_IllegalCase4() {
        Integer[] itrArr = {Integer.MIN_VALUE};
        Collection<Integer> itrColl = Arrays.<Integer>asList(itrArr);
        CompareInteger integerComparator = new CompareInteger();
        int k = 2;

        try {
            Selector.<Integer>kmax(itrColl, k, integerComparator);
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }
    }

    //kmax() boundary cases
    /**Tests kmax method with coll.size() = 1 **/
    @Test
    public void testKMax_BoundaryCase1() {
        Integer[] intArr = {1};
        Collection<Integer> intColl = Arrays.<Integer>asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 1;
        Integer expected = Selector.<Integer>max(intColl, intComp);
        Integer actual = Selector.<Integer>kmax(intColl, k, intComp);
        assertEquals(expected, actual);
    }

    /**Tests kmax method with coll.size() = 2 **/
    @Test
    public void testKMax_BoundaryCase2() {
        Integer[] intArr = {-4, 5};
        Collection<Integer> coll = Arrays.asList(intArr);
        CompareInteger itrComp = new CompareInteger();
        int k = 2;

        try {
            Selector.<Integer>kmax(coll, k, itrComp);
        }
        catch( NoSuchElementException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            fail("Wrong Exception");
        }
    }

    /**Tests kmax method with MAX int value **/
    @Test
    public void testKMax_BoundaryCase3() {
    }

    /**Tests kmax method with MIN int value **/
    @Test
    public void testKMax_BoundaryCase4() {
        Integer[] intArr = {2, 8, 7, 3, 4};

        Collection<Integer> intColl = Arrays.asList(intArr);
        CompareInteger intComp = new CompareInteger();
        int k = 5;

        Integer expected = 2;
        Integer actual = Selector.<Integer>kmax(intColl, k, intComp);

        assertEquals(expected, actual);
    }

    //typical cases for kmax()

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase1() {
    }

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase2() {
    }

    /**Tests kmax method with typical int values in a, and k **/
    @Test
    public void testKMax_TypicalCase3() {

    }

    //special cases for kmax()
    /**Tests kmax method with all duplicates in a, and k is larger than the number of distinct values in the array**/
    @Test
    public void testKMax_SpecialCase1() {
    }

    /**Tests kmax method with all duplicates in a, and k is equal to the number of distinct values in the array**/
    @Test
    public void testKMax_SpecialCase2(){
    }

    /**Tests kmax method with duplicates in the front **/
    @Test
    public void testKMax_SpecialCase3(){
    }

    /**Tests kmax method with duplicates in the middle **/
    @Test
    public void testKMax_SpecialCase4() {

    }

    /**Tests kmax method with duplicates in the back **/
    @Test
    public void testKMax_SpecialCase5() {
    }

    ///////////////////////////
    //test cases for range() //
    ///////////////////////////

    //illegal cases for range()
    /**Tests range method with a.length = 0 **/
    @Test
    public void testRange_IllegalCase1() {
    }

    /**Tests range method when a = null **/
    @Test
    public void testRange_IllegalCase2() {
    }

    //range() boundary cases
    /**Tests range method with a.length = 1 & Qualifying value**/
    @Test
    public void testRange_BoundaryCase1() {

    }

    /**Tests range method with a.length = 1 & without Qualifying value**/
    @Test
    public void testRange_BoundaryCase2() {
    }

    /**Tests Range method with a.length = 2 & Qualifying value**/
    @Test
    public void testRange_BoundaryCase3() {
    }

    /**Tests Range method with a.length = 2 & without Qualifying value**/
    @Test
    public void testRange_BoundaryCase4() {
    }
    /**Tests Range method with MAX & MIN int value **/
    @Test
    public void testRange_BoundaryCase5() {
    }

    //typical cases for range()

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase1() {
    }

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase2() {
    }

    /**Tests range method with typical int values in a, low, and high **/
    @Test
    public void testRange_TypicalCase3() {

    }

    //special cases for range()
    /**Tests range method with all duplicates within the range**/
    @Test
    public void testRange_SpecialCase1() {
    }

    /**Tests range method with all duplicates not within the range**/
    @Test
    public void testRange_SpecialCase2(){
    }

    /**Tests range method with duplicates in the front **/
    @Test
    public void testRange_SpecialCase3(){
    }

    /**Tests range method with duplicates in the middle **/
    @Test
    public void testRange_SpecialCase4() {

    }

    /**Tests range method with duplicates in the back **/
    @Test
    public void testRange_SpecialCase5() {
    }

    /**Tests range method with duplicates scattered **/
    @Test
    public void testRange_SpecialCase6() {
    }

    /**Tests range method with low > high**/
    @Test
    public void testRange_SpecialCase7() {
    }

    ////////////////////////////
    //test cases for ceiling()//
    ////////////////////////////

    //illegal cases for ceiling()
    /**Tests ceiling method with a.length = 0 **/
    @Test
    public void testCeiling_IllegalCase1() {
    }

    /**Tests ceiling method when a = null **/
    @Test
    public void testCeiling_IllegalCase2() {
    }

    /**Tests ceiling method when there is no qualifying value **/
    @Test
    public void testCeiling_IllegalCase3() {
    }

    //boundary cases for ceiling()
    /**Tests ceiling method with a.length = 1 & Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase1() {
    }

    /**Tests Ceiling method with a.length = 1 & without Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase2() {
    }

    /**Tests Ceiling method with a.length = 2 & Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase3() {
    }

    /**Tests Ceiling method with a.length = 2 & without Qualifying value**/
    @Test
    public void testCeiling_BoundaryCase4() {
    }

    /**Tests Ceiling method with MAX int value **/
    @Test
    public void testCeiling_BoundaryCase5() {
    }

    /**Tests Ceiling method with MIN int value **/
    @Test
    public void testCeiling_BoundaryCase6() {
    }

    //typical cases for ceiling()
    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase1() {
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase2() {
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase3() {
    }

    /**Tests ceiling method with typical int values in a and key**/
    @Test
    public void testCeiling_TypicalCase4() {
    }

    //special case for ceiling()
    /**Tests ceiling method with all duplicates in a **/
    @Test
    public void testCeiling_SpecialCase1() {
    }

    /**Tests ceiling method with all duplicates in a in the front**/
    @Test
    public void testCeiling_SpecialCase2() {
    }

    /**Tests ceiling method with all duplicates in a in the middle**/
    @Test
    public void testCeiling_SpecialCase3() {
    }

    /**Tests ceiling method with all duplicates in a in the back**/
    @Test
    public void testCeiling_SpecialCase4() {
    }

    /**Tests ceiling method with all duplicates in a scattered**/
    @Test
    public void testCeiling_SpecialCase5() {
    }

    ////////////////////////////
    //test cases for floor()//
    ////////////////////////////

    //illegal cases for floor()
    /**Tests floor method with a.length = 0 **/
    @Test
    public void testFloor_IllegalCase1() {
    }

    /**Tests floor method when a = null **/
    @Test
    public void testFloor_IllegalCase2() {
    }

    /**Tests floor method when there is no qualifying value **/
    @Test
    public void testFloor_IllegalCase3() {
    }

    //boundary cases for floor()
    /**Tests Floor method with a.length = 1 & Qualifying value**/
    @Test
    public void testFloor_BoundaryCase1() {
    }

    /**Tests Floor method with a.length = 1 & without Qualifying value**/
    @Test
    public void testFloor_BoundaryCase2() {
    }

    /**Tests Floor method with a.length = 2 & Qualifying value**/
    @Test
    public void testFloor_BoundaryCase3() {
    }

    /**Tests Floor method with a.length = 2 & without Qualifying value**/
    @Test
    public void testFloor_BoundaryCase4() {
    }

    /**Tests Floor method with MAX int value **/
    @Test
    public void testFloor_BoundaryCase5() {
    }

    /**Tests Floor method with MIN int value **/
    @Test
    public void testFloor_BoundaryCase6() {
    }

    //typical cases for floor()
    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase1() {
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase2() {
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase3() {
    }

    /**Tests floor method with typical int values in a and key**/
    @Test
    public void testFloor_TypicalCase4() {
    }

    //tests special cases for floor()

    /**Tests floor method with all duplicates in a **/
    @Test
    public void testFloor_SpecialCase1() {
    }

    /**Tests floor method with all duplicates in a in the front**/
    @Test
    public void testFloor_SpecialCase2() {
    }

    /**Tests floor method with all duplicates in a in the middle**/
    @Test
    public void testFloor_SpecialCase3() {
    }

    /**Tests floor method with all duplicates in a in the back**/
    @Test
    public void testFloor_SpecialCase4() {
    }

    /**Tests ceiling method with all duplicates in a scattered**/
    @Test
    public void testFloor_SpecialCase5() {
    }
}