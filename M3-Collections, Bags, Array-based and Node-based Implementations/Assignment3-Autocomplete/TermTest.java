import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class TermTest {

    //when query == null.
    @Test
    public void constructorIllegalCase1() {
        try {
            Term term = new Term(null, 100);
        }
        catch(NullPointerException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }
    }

    //when weight is negative.
    @Test
    public void constructorIllegalCase2() {
        try {
            Term term = new Term("Tott", -1);
        }
        catch(IllegalArgumentException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong Exception");
        }
    }


    @Test
    public void byDescendingWeightOrderBoundaryCase1(){
        Term term1 = new Term("Tottenham", Long.MAX_VALUE);
        Term term2 = new Term("Arsenal", 1);

        //ask hendrix about how to calculate expected
        int expected = 1  ;
        int actual = Term.byDescendingWeightOrder().compare(term1, term2);
        assertTrue(actual < 0);
    }


    /*Tests to see if the comparator work on array of term objects**/
    @Test
    public void byDescendingWeightOrder1() {
        Term term1 = new Term("John", Long.MAX_VALUE);
        Term term2 = new Term("Joke", 1);
        Term term3 = new Term("Jeff", 880);
        Term term4 = new Term("Jack", 279998011);
        Term[] actualTerms = {term1, term2 , term3, term4};

        Comparator<Term> termComparator = Term.byDescendingWeightOrder();
        Arrays.sort(actualTerms, termComparator);

        Term term5 = new Term("John", Long.MAX_VALUE);
        Term term6 = new Term("Joke", 1);
        Term term7 = new Term("Jeff", 880);
        Term term8 = new Term("Jack", 279998011);
        Term[] expectedTerms = {term5, term8 , term7, term6};

        assertArrayEquals(expectedTerms, actualTerms);
    }

    /*Tests to see if the comparator work on array of term objects in ascending order**/
    @Test
    public void byDescendingWeightOrder2() {
        Term term1 = new Term("John", 1);
        Term term2 = new Term("Joke", 2);
        Term term3 = new Term("Jeff", 3);
        Term term4 = new Term("Jack", 4);
        Term[] actualTerms = {term1, term2 , term3, term4};

        Comparator<Term> termComparator = Term.byDescendingWeightOrder();
        Arrays.sort(actualTerms, termComparator);

        Term term5 = new Term("John", 1);
        Term term6 = new Term("Joke", 2);
        Term term7 = new Term("Jeff", 3);
        Term term8 = new Term("Jack", 4);
        Term[] expectedTerms = {term8, term7 , term6, term5};

        assertArrayEquals(expectedTerms, actualTerms);
    }

    /*Tests to see if the comparator work on array of term objects with duplicate weight and check for stability**/
    @Test
    public void byDescendingWeightOrder3() {
        Term term1 = new Term("John", 1);
        Term term2 = new Term("Jack", 1);
        Term term3 = new Term("Jeff", 3);
        Term term4 = new Term("Jack", 4);
        Term[] actualTerms = {term1, term2 , term3, term4};

        Comparator<Term> termComparator = Term.byDescendingWeightOrder();
        Arrays.sort(actualTerms, termComparator);

        Term term5 = new Term("John", 1);
        Term term6 = new Term("Jack", 1);
        Term term7 = new Term("Jeff", 3);
        Term term8 = new Term("Jack", 4);
        Term[] expectedTerms = {term8, term7 , term5, term6};

        assertArrayEquals(expectedTerms, actualTerms);
    }


    /**Tests byPrefixOrder() when length = 0 **/
    @Test
    public void byPrefixOrderIllegalCase1() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        Term[] terms = {term3, term1, term2, term4 , term5};

        try {
            Term.byPrefixOrder(0);

        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong exception");
        }
    }


    /**Tests byPrefixOrder() when length < 0 **/
    @Test
    public void byPrefixOrderIllegalCase2() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        try {
            Term.byPrefixOrder(Integer.MIN_VALUE);

        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            fail("Wrong exception");
        }
    }

    @Test
    public void byPrefixOrderTypicalCase1() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        Comparator<Term> prefixComparator = Term.byPrefixOrder(4);
        int actual = prefixComparator.compare(term1, term2);

        assertTrue(actual == 0);
    }

    @Test
    public void byPrefixOrderTypicalCase2() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        Comparator<Term> prefixComparator = Term.byPrefixOrder(4);
        int actual = prefixComparator.compare(term2, term3);

        assertTrue(actual == 0);
    }

    @Test
    public void byPrefixOrderTypicalCase3() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        Comparator<Term> prefixComparator = Term.byPrefixOrder(4);
        int actual = prefixComparator.compare(term3, term4);

        assertTrue(actual > 0);
    }

    @Test
    public void byPrefixOrderTypicalCase4() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottenhm Hotspurs", 40);
        Term term3 = new Term("Tottenham Players", 30);
        Term term4 = new Term("Arsenal", 1);
        Term term5 = new Term("Unrelated topic", 0);

        Comparator<Term> prefixComparator = Term.byPrefixOrder(4);
        int actual = prefixComparator.compare(term3, term5);

        assertTrue(actual < 0);
    }

    @Test
    public void byPrefixOrderBoundaryCase1() {
        Term term1 = new Term("Tottenham", 60);
        Term term2 = new Term("Tottinghams", 40);

        Comparator<Term> prefixComparator = Term.byPrefixOrder(4);
        int actual = prefixComparator.compare(term1, term2);

        assertTrue(actual == 0);
    }


    @Test
    public void compareTo() {
    }

    @Test
    public void testToString() {
    }
}