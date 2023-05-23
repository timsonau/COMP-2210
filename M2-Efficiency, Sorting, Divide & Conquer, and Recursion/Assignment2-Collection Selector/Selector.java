import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Defines a library of selection methods on Collections.
 *
 * @author  YOUR NAME HERE (you@auburn.edu)
 *
 */
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) {
        if (coll == null || comp == null ) {
            throw new IllegalArgumentException("the coll or comp can't be null");
        }

        if (coll.isEmpty()) {
            throw new NoSuchElementException("Cannot be an empty Collection");
        }

        Iterator<T> itr = coll.iterator();
        //early exit for when there is only one element and nothing to be compared to.
        if(coll.size() == 1) {
            return itr.next();
        }
        //we need a default value for minimum and since we know this cant be an empty collection this operation
        //is fine as it is
        T min = itr.next();

        //since each iterator will have a different cursor the min iterator wont effect the for each iterator.
        for(T val : coll) {
            if(comp.compare(val, min) < 0) {
                min = val;
            }
        }

        return min;
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) {
        if (coll == null || comp == null ) {
            throw new IllegalArgumentException("the coll or comp can't be null");
        }

        if (coll.isEmpty()) {
            throw new NoSuchElementException("Cannot be an empty Collection");
        }

        Iterator<T> itr = coll.iterator();
        //early exit
        if(coll.size() == 1) {
            return itr.next();
        }
        //we need a default value for minimum and since we know this cant be an empty collection this operation
        //is fine as it is
        T max = itr.next();

        //since each iterator will have a different cursor the max iterator wont effect the for each iterator.
        for(T val : coll) {
            if(comp.compare(val, max) > 0) {
                max = val;
            }
        }

        return max;
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
        if (coll == null || comp == null ) {
            throw new IllegalArgumentException("the coll or comp can't be null");
        }

        if (coll.isEmpty()) {
            throw new NoSuchElementException("Cannot be an empty Collection");
        }

        if(k <= 0) {
            throw new NoSuchElementException("There is no Kth Minimum");
        }

        //converts coll to ArrayList so it can be sorted
        List<T> list = new ArrayList<T>(coll);
        java.util.Collections.sort(list, comp);

        //early exit
        if(k == 1) {
            return list.get(0);
        }

        int kIndex = k - 1;
        Iterator<T> nextElement = list.iterator();

        //makes sure nextElement is always one element ahead of thisElement so a comparison can happen
        //like how array[i] needs to compare to array[i+1]
        nextElement.next();

        //counts index of Array
        int distinctKIndex = 0;
        //accounts for duplicates in the list
        for(T val : list) {

            //checks if
            if(distinctKIndex == kIndex) {
                return val;
            }
            //only if the elements in the indexes are different is the i incremented.
            if(comp.compare(val, nextElement.next()) != 0) {
                distinctKIndex++;
            }

        }

        throw new NoSuchElementException();
    }


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
        if (coll == null || comp == null ) {
            throw new IllegalArgumentException("the coll or comp can't be null");
        }

        if (coll.isEmpty()) {
            throw new NoSuchElementException("Cannot be an empty Collection");
        }

        if(k <= 0) {
            throw new NoSuchElementException();
        }

        //makes an a list with the elements of coll
        List<T> list = new ArrayList<T>(coll);
        java.util.Collections.sort(list, comp);

        //early exit
        if((list.size() == 1) && (k == 1)) {
            return list.get(0);
        }

        int kIndex = k - 1;
        int distinctKIndex = 0;
        //loops through the collection backwards
        int i2 = list.size() - 1;
        for(int i = list.size() - 1; i > 0; i--) {
            if(distinctKIndex == kIndex) {
                return list.get(i);
            }

            if(comp.compare(list.get(i), list.get(i-1)) != 0){
                distinctKIndex++;
            }
            i2--;
        }

        if(distinctKIndex == kIndex) {
            return list.get(i2);
        }

        throw new NoSuchElementException();
    }


    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                          Comparator<T> comp) {
        if(coll == null || comp == null) {
            throw new IllegalArgumentException();
        }

        if(coll.isEmpty()) {
            throw new NoSuchElementException();
        }

        Collection<T> coll2 = new ArrayList<T>();

        for(T val: coll) {
            if((comp.compare(val, high) <= 0) && (comp.compare(val, low) >= 0)) {
                coll2.add(val);
            }
        }

        if(coll2.isEmpty()) {
            throw new NoSuchElementException();
        }

        return coll2;
    }


    /**
     * Returns the smallest value in the Collection coll that is greater than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the ceiling value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the ceiling value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {

        if(coll == null || comp == null) {
            throw new IllegalArgumentException("coll or comp can't be null");
        }
        if(coll.isEmpty()) {
            throw new NoSuchElementException("cannot be an empty coll");
        }
        T ceiling = null;
        //tries to find a default ceiling (any value that could be the ceiling)
        for(T element : coll) {
            if(comp.compare(element, key ) >= 0){
                ceiling = element;
                break;
            }
        }
        //if there isn't a default ceiling candidate there is no ceiling at all so throw an exception
        if(ceiling == null) {
            throw new NoSuchElementException("There is no qualifying value");
        }

        if(comp.compare(ceiling, key) == 0) {
            return ceiling;
        }

        //tries to find any value smaller than the current ceiling. current ceiling != null, since that is checked in the if statement above.
        for(T element : coll) {
            //if the element can be a ceiling & is smaller than the current ceiling the element becomes the new ceiling
            if((comp.compare(element, key) >= 0) && (comp.compare(element, ceiling) < 0)){
                ceiling = element;
            }
        }

        return ceiling;
    }


    /**
     * Returns the largest value in the Collection coll that is less than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the floor value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the floor value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
        if(coll == null || comp == null) {
            throw new IllegalArgumentException("comp or coll can't be null");
        }

        if(coll.isEmpty()) {
            throw new NoSuchElementException("coll can't be empty");
        }

        T floor = null;

        for(T element : coll) {
            if(comp.compare(element, key) <= 0) {
                floor = element;
                break;
            }
        }

        //if no floor candidate is found there won't be a floor
        if(floor == null) {
            throw new NoSuchElementException("No qualifying values");
        }

        //if the floor is equal to key no need to iterate through the coll again since floor would be the closest value to key
        if(comp.compare(floor, key) == 0) {
            return floor;
        }

        for(T element : coll) {
            if((comp.compare(element, key) <= 0) && (comp.compare(element, floor) > 0)) {
                floor = element;
            }
        }

        return floor;
    }

}

