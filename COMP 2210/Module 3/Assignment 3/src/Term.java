import java.util.Comparator;

public class Term implements Comparable<Term> {

    private String query;
    private long weight;

    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
        if(query == null) {
            throw new NullPointerException("Querey can't be null");
        }

        if(weight < 0) {
            throw new IllegalArgumentException("Weight can't be negative");
        }
        this.query = query;
        this.weight = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
        Comparator<Term> compareByWeight = new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
                return Long.compare(t2.weight, t1.weight);
            }
        };

        return compareByWeight;
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
        if(length <= 0) {
            throw new IllegalArgumentException();
        }

        Comparator<Term> compareByPrefix = new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
                if(t1.query.length() < length || t2.query.length() < length) {
                    return t1.query.compareTo(t2.query);
                }
                return t1.query.substring(0, length).compareTo(t2.query.substring(0, length));
            }
        };

        return compareByPrefix;
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
        return this.query.compareTo(other.query);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
        return query + "\t" + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(obj == null) return false;

        if(!(obj instanceof Term)) return false;

        Term that = (Term) obj;

        return this.query.equals(that.query) && (this.weight == that.weight);

    }

    @Override
    public int hashCode() {
        return 0;
    }

}