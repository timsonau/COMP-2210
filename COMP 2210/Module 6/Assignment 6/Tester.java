import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        WordLadderGame doublets = new Doublets(new FileInputStream(new File("OWL.txt")));
        doublets.getWordCount();
        doublets.isWord("AA");

    }
    
}
