public class CountNegatives {
    /*** Returns the number of negative values in the given array.*/

    public static int countNegatives(int[]a) {
        int negativeCount = 0;
        for (int value : a) {
            if (value < 0) {
                negativeCount++;
            }
        }
        return negativeCount;
    }
}
