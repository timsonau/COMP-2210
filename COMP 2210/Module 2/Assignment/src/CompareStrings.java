import java.util.Comparator;

//compares two strings
public class CompareStrings implements Comparator<String> {
    //returns - if s1 < s2, + if s1 > s2, 0 if s1 == s2
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
