import java.util.Arrays;
import java.util.Comparator;

//this only takes in stuff that can compare with itself
public class Sort <T extends Comparable<T>> {
    private T[] aux;

    public static void main(String[] args) {
        Integer[] a = {1,6, 7, 8, 10, 13 , 45, 60, -10 , 6};
        Sort<Integer> sort = new Sort<Integer>();
        sort.mergeSort(a, 0, a.length -1);
        int[] b = {1,2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 19, 90};
        int i = sort.binarySearch2(b, 11);
        System.out.println(i);

        //sort.InsertionSort(a);
        //for(Integer val: a)
        //System.out.print(val + ", ");
    }

    public int binarySearch1(int[] a, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;

        if(a[middle] == target) {
            return middle;
        }
        if(a[middle] < target) {
            return binarySearch1(a, target, middle + 1, right);
        }

        return binarySearch1(a, target, left, middle - 1);
    }

    public int binarySearch2(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if(a[middle] < target) left = middle + 1;

            else if(a[middle] > target) right = middle - 1;

            else return middle;
        }

        return -1;
    }
    public void SelectionSort(T[] a) {
        for(int i = 0; i< a.length; i++) {
            //the current i should be default current minimum index
            int currMinIndex = i;

            //this loop checks for any element of the array that is less than the element in the currentMinIndex
            for (int j = i + 1; j < a.length; j++) {
                //if it is that element becomes the new current element. The loop is repeated again now with a new currMin Element.
                if(less(a[j], a[currMinIndex])) {
                    //the currMinIndex is changed to the index with smaller value
                    currMinIndex = j;
                }
            }
            swap(a, i, currMinIndex);
        }
    }

    public void mergeSort(T[] a, int left, int right) {
        aux = Arrays.copyOf(a, a.length);
        if(left == right) {
            return;
        }

        int middle = left + (right - left) / 2 ;
        //merge sorts the left side
        mergeSort(a, left, middle);
        //merge sorts the right side
        mergeSort(a, middle + 1, right);

        merge(a, left, middle, right);

    }

    private void merge(T[] a, int left, int mid, int right) {
        for(int k = left; k <= right; k++) {
            aux[k] = a[k];
        }

        int i = left;
        int j = mid + 1;

        for(int k = left; k <= right; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            }
            else if(j > right) {
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }

    }
    public int max(int[] a, int left, int right) {
        if(left == right) {
            return a[0];
        }

        int middle = (left + right) / 2;
        int lm = max(a, left, middle);
        int rm = max(a, middle+1, right);

        if(lm > rm)
            return lm;
        else
            return rm;
    }
    public void InsertionSort(T[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0; j--) {
                //the current element is checked to the one before. If it isn't less it can't be less than any other ones before that so no point in going all the way through.
                if(less(a[j], a[j - 1])) {
                    //swaps two elements using their indeses
                    swap(a , j, j -1);
                }
                else {
                    break;
                }
            }
        }
    }

    private void swap(T[] a, int i, int j) {
        //a[i] is stored in a temporary variable
        T temp = a[i];

        //the a[j] takes the place of a[i]. Now in theory a[i] == a[j]
        a[i] = a[j];

        //the a[i] that was in the temporary replaces the old a[j]
        a[j] = temp;
    }

    private boolean less(T e1, T e2) {

        //return true if the first element is less than the second element.
        return e1.compareTo(e2) < 0;
    }
}
