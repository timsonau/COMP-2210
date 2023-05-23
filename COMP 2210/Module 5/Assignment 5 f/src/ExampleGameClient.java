import java.util.List;
import java.util.SortedSet;

public class ExampleGameClient {
   public static void main(String[] args) {
      WordSearchGame game = WordSearchGameFactory.createGame();
      game.loadLexicon("CSW12.txt");
   }
}
