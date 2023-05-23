import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Heeyoon (hzs0093@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  8/29/2020
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     * <p>
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     */
    private Selector() {
    }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        try {
            int min = a[0];
            for (int element : a) {
                if (min > element) {
                    min = element;
                }
            }
            return min;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        try {
            int max = a[0];
            for (int element : a) {
                if (max < element) {
                    max = element;
                }
            }
            return max;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        try {
            int[] b = a.clone();
            Arrays.<Integer>sort(b);
            //Using kIndex instead of k to eliminate confusion.
            //Arrays start at 0 while kth minimum can only start from 1.
            int kIndex = k - 1;
            int maxIndex = b.length - 1;
            //loops through the array stopping at kIndex since the element after kIndex does not affect the position of k
            for (int i = 0; i < kIndex; i++) {
                //if there is a duplicate value before kmin is read the extra index should be accounted for.
                if (b[i] == b[i + 1]) {

                    //increased by 1 to account for duplicate taking up an index.
                    kIndex++;
                }
            }
            return b[kIndex];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
        try {
            int[] b = a.clone();
            Arrays.<Integer>sort(b);

            //Using kIndex instead of k to eliminate confusion.
            //Arrays start at 0 while kth maximum can only start from 1.
            int kIndex = k - 1;
            int maxIndex = b.length - 1;
            //since we are counting the kth maximum in a sorted ascending array, we must invert the index.
            kIndex = maxIndex - kIndex;
            //loops through the array stopping when we reach the the index of k.
            for (int i = maxIndex; i > kIndex; i--) {
                //if there is a duplicate value before kmax is read the extra index should be accounted for.
                if (b[i] == b[i - 1]) {
                    //decreased by 1 to account for duplicate taking up an index.
                    kIndex--;
                }
            }
            return b[kIndex];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        try {
            //if it is a zero length array it throws ArrayIndexOutOfBound Exception
            int checkIfZeroLength = a[0];
            int rangeArrayLength = 0;
            //Linear scans the int[] a to see how many values CAN be added to the range[]
            for (int value : a) {
                if ((value >= low) && (value <= high)) {
                    rangeArrayLength++;
                }
            }

            //makes range[] based on how much space is needed for the values. Ensures a full array
            int[] range = new int[rangeArrayLength];
            int currIndexOfRange = 0;

            //Linear Scans the int[] a to add the values in the range to range[].
            for (int value : a) {
                if ((value >= low) && (value <= high)) {
                    range[currIndexOfRange] = value;
                    currIndexOfRange++;
                }
            }
            return range;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        try {
            //ceiling is set to max int value so any number less or equal to MAX_VALUE can become the new ceiling.
            //this is more giving every value in the list a chance to become the ceiling.
            int ceiling = Integer.MAX_VALUE;
            boolean isThereQualifyingValue = false;
            for (int value : a) {
                //if value is less/equal to the key and closer/equal to key
                //*closer/equal in case the actual ceiling is the Integer.MAX_Value
                if ((value >= key) && (value <= ceiling)) {
                    //then the current ceiling is replaced by current value.
                    isThereQualifyingValue = true;
                    ceiling = value;
                }
            }

            if (isThereQualifyingValue == false) {
                throw new IllegalArgumentException();
            }
            return ceiling;

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        try {
            //floor is set to min int value so any number greater or equal to MAX_VALUE can become the new floor.
            //this is more about giving every value in the list a chance to become the floor.
            int floor = Integer.MIN_VALUE;
            boolean isThereQualifyingValue = false;
            for (int value : a) {
                //if value is less/equal to the key and closer/equal to key
                //*closer/equal in case the actual floor is the Integer.MIN_Value
                if ((value <= key) && (value >= floor)) {
                    isThereQualifyingValue = true;
                    //then the current floor is replaced by current value.
                    floor = value;
                }
            }

            if (isThereQualifyingValue == false) {
                throw new IllegalArgumentException();
            }
            return floor;

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
