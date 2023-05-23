import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * MinOfThreeTest.java
 * Illustrates JUnit tests for the MinOfThree class.
 *
 * @author Heeyoon Son
 * @version 2020-08-27
 *
 */
public class MinOfThreeTest {

    //////////////////
    //boundary cases//
    //////////////////

    /** Tests with max int value in the front w/min1 method **/
    @Test
    public void testMin1_Boundary1() {
        int a = Integer.MAX_VALUE;
        int b = 3;
        int c = 4;
        int expected = 3;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with max int value in the front w/min2 method **/
    @Test
    public void testMin2_Boundary1() {
        int a = Integer.MAX_VALUE;
        int b = 3;
        int c = 4;
        int expected = 3;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with max int value in the back w/min1 method **/
    @Test
    public void testMin1_Boundary2() {
        int a = 10;
        int b = 8;
        int c = Integer.MAX_VALUE;
        int expected = 8;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with max int value the back w/min2 method **/
    @Test
    public  void testMin2_Boundary2() {
        int a = 10;
        int b = 8;
        int c = Integer.MAX_VALUE;
        int expected = 8;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min int value in the front w/min1 method **/
    @Test
    public void testMin1_Boundary3() {
        int a = Integer.MIN_VALUE;
        int b = 7;
        int c = 4;
        int expected = Integer.MIN_VALUE;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min int value in the front w/min2 method **/
    @Test
    public void testMin2_Boundary3() {
        int a = Integer.MIN_VALUE;
        int b = 7;
        int c = 99;
        int expected = Integer.MIN_VALUE;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min int value in the back w/min1 method **/
    @Test
    public void testMin1_Boundary4() {
        int a = 10;
        int b = 99;
        int c = Integer.MIN_VALUE;
        int expected = Integer.MIN_VALUE;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min int value in the back w/min2 method **/
    @Test
    public void testMin2_Boundary4() {
        int a = 135;
        int b = 99;
        int c = Integer.MIN_VALUE;
        int expected = Integer.MIN_VALUE;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    ////////////////////
    // Typical Cases //
    ///////////////////

    /** Tests with the min value is in A w/min1 method **/
    @Test
    public void testMin1_FoundInA() {
        int a = 2;
        int b = 4;
        int c = 8;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with the min value is in A w/min2 method **/
    @Test
    public void testMin2_FoundInA() {
        int a = 2;
        int b = 4;
        int c = 8;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with the min value is in B w/min1 method **/
    @Test
    public void testMin1_FoundInB(){
        int a = 2;
        int b = 1;
        int c = 8;
        int expected = 1;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with the min value is in B w/min2 method **/
    @Test
    public void testMin2_FoundInB(){
        int a = 2;
        int b = 1;
        int c = 8;
        int expected = 1;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with the min value in C w/min1 method **/
    @Test
    public void testMin1_FoundInC(){
        int a = 2;
        int b = 1;
        int c = -2;
        int expected = -2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with the min value in C w/min2 method **/
    @Test
    public void testMin2_FoundInC(){
        int a = 2;
        int b = 1;
        int c = -2;
        int expected = -2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /////////////////
    //special cases//
    //0 = min      //
    //1 1= not min //
    /////////////////
    // a || b || c //
    // 0 || 0 || 0 //
    // 0 || 0 || 1 //
    // 0 || 1 || 0 //
    // 0 || 1 || 1 //
    // 1 || 0 || 0 //
    // 1 || 0 || 1 //
    // 1 || 1 || 0 //
    // 1 || 1 || 1/ /
    /** Test with all same values w/min1 method **/
    @Test
    public void testMin1_SpecialCase000() {
        int a = 2;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with all same values w/min2 method **/
    @Test
    public void testMin2_SpecialCase000() {
        int a = 7;
        int b = 7;
        int c = 7;
        int expected = 7;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min values in a and b (001) w/min1 method **/
    @Test
    public void testMin1_SpecialCase001() {
        int a = -4;
        int b = -4;
        int c = 0;
        int expected = -4;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min values in a and b (001) w/min2 method **/
    @Test
    public void testMin2_SpecialCase001(){
        int a = 1;
        int b = 1;
        int c = 2;
        int expected = 1;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in a and c (010) w/min1 method **/
    @Test
    public void testMin1_SpecialCase010(){
        int a = 9;
        int b = 11;
        int c = 9;
        int expected = 9;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in a and c (010) w/min2 method **/
    @Test
    public void testMin2_SpecialCase010(){
        int a = 10;
        int b = 77;
        int c = 10;
        int expected = 10;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in a (011) w/min1 method **/
    @Test
    public void testMin1_SpecialCase011(){
        int a = -1;
        int b = 7;
        int c = 7;
        int expected = -1;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in a (011) w/min2 method **/
    @Test
    public void testMin2_SpecialCase011() {
        int a = 0;
        int b = 1;
        int c = 1;
        int expected = 0;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in b and c (100) w/min1 method **/
    @Test
    public void testMin1_SpecialCase100() {
        int a = 11;
        int b = 3;
        int c = 3;
        int expected = 3;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in b and c (100) w/min2 method **/
    @Test
    public void testMin2_SpecialCase100() {
        int a = 18;
        int b = 9;
        int c = 9;
        int expected = 9;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in b (101) w/min1 method **/
    @Test
    public void testMin1_SpecialCase101() {
        int a = 20;
        int b = 1;
        int c = 20;
        int expected = 1;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in b (101) w/ min2 method **/
    @Test
    public void testMin2_SpecialCase101() {
        int a = 99;
        int b = 98;
        int c = 99;
        int expected = 98;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in c (110) w/ min1 method **/
    @Test
    public void testMin1_SpecialCase110() {
        int a = 111;
        int b = 111;
        int c = 109;
        int expected = 109;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Tests with min value in c (110) w/min 2 method **/
    @Test
    public void testMin2_SpecialCase110() {
        int a = -90;
        int b = -90;
        int c = -89;
        int expected = -90;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }


}