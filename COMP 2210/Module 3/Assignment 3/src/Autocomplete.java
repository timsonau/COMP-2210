
import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {

    private Term[] terms;
    /**
     * Initializes a data structure from the given array of terms.
     * This method throws a NullPointerException if terms is null.
     */
    public Autocomplete(Term[] terms) {

        if(terms == null) {
            throw new NullPointerException("terms cant be null");
        }
        Arrays.sort(terms);
        this.terms = terms;
    }

    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     * This method throws a NullPointerException if prefix is null.
     */
    public Term[] allMatches(String prefix) {
        if(prefix == null) {
            throw new NullPointerException("prefix can't be null");
        }
        Term prefixTerm = new Term(prefix, 0);
        Comparator<Term> prefixComparator = Term.byPrefixOrder(prefix.length());
        //searches through sorted terms[] to see where the first occurrence of the prefix happens. O(log(n))
        int firstIndexOf = BinarySearch.<Term>firstIndexOf(terms, prefixTerm, prefixComparator);
        //searches through sorted terms[] to see where the last occurrence of the prefix happens. O(log(n))
        int lastIndexOf = BinarySearch.<Term>lastIndexOf(terms, prefixTerm, prefixComparator);

        Term[] allMatches = Arrays.<Term>copyOfRange(terms, firstIndexOf, lastIndexOf + 1);

        //O(nlog(n))
        Arrays.sort(allMatches, Term.byDescendingWeightOrder());
        return allMatches;
    }

}