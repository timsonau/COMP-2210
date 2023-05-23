public class DriverTester {
    public static void main(String[] ars) {
        Term t1 = new Term("Arsenal", 88);
        Term t2 = new Term("Tottenham", 10000);
        Term t3 = new Term("Holland", 40);
        Term t4 = new Term("Chelsea", 10000);
        Term t5 = new Term("Tottenham hotspur Stadium", 6000);
        Term t6 = new Term("Tottenham Hotspur", 9000);
        Term t7 = new Term("Tottenham Hotspur Players", 6000);
        Term t8 = new Term("Johnny Bruscos", 300);
        Term t9 = new Term("Soccer", 900000000);
        Term t10 = new Term("Harry Kane", 3000);
        Term t11 = new Term("Tottenham Kane", 900);
        Term t12 = new Term("Tottinham Day", 300);
        Term t13 = new Term("To", 200);


        Term[] terms = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t13};
        Autocomplete autoComplete = new Autocomplete(terms);
        Term[] allMatches = autoComplete.allMatches("Tott");

        for(int i = 0; i < allMatches.length; i++) {
            System.out.println(allMatches[i]);
        }
    }
}
