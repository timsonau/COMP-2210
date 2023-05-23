import java.util.List;
import java.util.SortedSet;

public class ExampleGameClient {
   public static void main(String[] args) {
      Boggle game = new Boggle();
       game.loadLexicon("words_medium.txt");
       game.setBoard(new String[]{"H","E","B","E","Z","K","T","S","T"});     
       System.out.print(game.getAllScorableWords(3));

       
   }
}
