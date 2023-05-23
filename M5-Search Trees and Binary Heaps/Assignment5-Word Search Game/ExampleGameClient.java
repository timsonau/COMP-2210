import java.util.List;
import java.util.SortedSet;

public class ExampleGameClient {
   public static void main(String[] args) {
      WordSearchGame game = WordSearchGameFactory.createGame();
      game.loadLexicon("words_medium.txt");
      game.setBoard(new String[]{"TIGER"});
      System.out.println(game.getScoreForWords(game.getAllScorableWords(5), 5));

   }
}
