import java.util.Arrays;

public class SelectorDriver {

    public static void main (String[] args){
        int[] a = {1, 1, 2, 4, 5};

    }

    public static int kmax2(int[] a, int k){
        try {
            int[] b = a.clone();
            Arrays.sort(b);

            //Using kIndex instead of k to eliminate confusion.
            //Arrays start at 0 while kth maximum can only start from 1.
            int kIndex = k - 1;
            int maxIndex = b.length - 1;
            //loops through the array stopping when i = kIndex since only duplicates before the kIndex should be counted.
            for (int i = 0; i < maxIndex; i++) {
                //if there is a duplicate index of k
                if (b[i] == b[i + 1]) {
                    //increased by 1 to account for duplicate taking up an index.
                    kIndex++;
                }
            }

            //since we are counting the kth maximum with the kmin method we must invert the index.
            kIndex = maxIndex - kIndex;
            return b[kIndex];
        }
        catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
