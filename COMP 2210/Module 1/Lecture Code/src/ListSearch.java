public class ListSearch {
    public static int search(Object [] a, Object target) {
        int i = 0;
        while ((i < a.length) && (!a[i].equals(target))) {
            i++;
        }
        if(i < a.length) return  i;
        else return -1;
    }

    public static void main (String[] args) {

    }
}
