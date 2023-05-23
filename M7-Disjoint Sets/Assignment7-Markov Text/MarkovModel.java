import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Your Name (you@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2018-04-17
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   private List<String> KGramsList;
   // add other fields as you need them ...


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      KGramsList = new ArrayList<String>();
      int originalK = K;
      
      while(K <= sourceText.length()) {   
         String kgram = sourceText.substring(K - originalK, K);
         String charsThatFollow = "";
         if (K == sourceText.length()) {
            charsThatFollow = "";
         }
         else if(model.containsKey(kgram)) {
            charsThatFollow = model.get(kgram) + sourceText.substring(K, K + 1);
         }
         else{
            charsThatFollow = sourceText.substring(K, K + 1);
         }
         model.put(kgram, charsThatFollow);
         
         if(!KGramsList.contains(kgram)) {
            KGramsList.add(kgram);
         }
         K++;
      }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return KGramsList.get(0); 
   }



   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      Random rand = new Random();
      int randIndex = rand.nextInt(getAllKgrams().size());
      return KGramsList.get(randIndex);
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    public Set<String> getAllKgrams() {
      return model.keySet();
   }

   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      String charsThatFollow = model.get(kgram);
      if(charsThatFollow == null) {
         return '\u0000';
      }
      if(charsThatFollow.length() == 0) {
         return '\u0000';
      }

      Random rand = new Random();
      int randIndex = rand.nextInt(charsThatFollow.length());
      return charsThatFollow.charAt(randIndex);
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    @Override
    public String toString() {
      return model.toString();
   }

}
