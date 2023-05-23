public class SearchMethods {
    public SearchMethods(){
    }

    public static int BinarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;

            if(target < a[middle]) {
                right = middle - 1;
            }

            if(target > a[middle]) {
                left = middle + 1;
            }

            if(target == a[middle]) {
                return middle;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] a , int target) {

        for(int i = 0; i < a.length; i++) {
            if(a[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
