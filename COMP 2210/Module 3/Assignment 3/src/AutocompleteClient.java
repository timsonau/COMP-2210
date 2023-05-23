import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Client for Autocomplete.
 */
public class AutocompleteClient {

   /** Drives execution. */
   public static void main(String[] args) {
      Term[] terms = null;
      try {
         Scanner scanner = new Scanner(new File("PLTeams."));
         int numLines = scanner.nextInt();
         terms = new Term[numLines];
         for (int i = 0; i < numLines; i++) {
            String query = scanner.next().strip();
            long weight = scanner.nextLong();
            scanner.nextLine();
            terms[i] = new Term(query, weight);
         }
      } catch (Exception e) {
         System.out.println("*****ERROR**** " + e.toString());
      }
      Autocomplete auto = new Autocomplete(terms);
      Term[] matches = auto.allMatches("comp");
      for (Term term : matches) {
         System.out.println(term);
      }
   }

}