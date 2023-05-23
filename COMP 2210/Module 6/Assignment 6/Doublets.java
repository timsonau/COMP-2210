import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Your Name (you@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-29
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////
    private HashSet<String> lexicon;
    //collection of word already visited.
    private HashSet<String> usedWords;
    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
            //////////////////////////////////////
            // INSTANTIATE lexicon OBJECT HERE  //
            lexicon = new HashSet<>();
            //////////////////////////////////////
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                /////////////////////////////////////////////////////////////
                // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
                /////////////////////////////////////////////////////////////
                lexicon.add(str.toUpperCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }


    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////

   /**
     * Returns the Hamming distance between two strings, str1 and str2. The
     * Hamming distance between two strings of equal length is defined as the
     * number of positions at which the corresponding symbols are different. The
     * Hamming distance is undefined if the strings have different length, and
     * this method returns -1 in that case. See the following link for
     * reference: https://en.wikipedia.org/wiki/Hamming_distance
     *
     * @param  str1 the first string
     * @param  str2 the second string
     * @return      the Hamming distance between str1 and str2 if they are the
     *                  same length, -1 otherwise
     */
    public int getHammingDistance(String str1, String str2){
        if(str1.length() != str2.length()) return -1;
    
        int hammingDistance = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

       /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
    public List<String> getMinLadder(String start, String end) {
        usedWords = new HashSet<>();
        List<String> ladder = new ArrayList<>();

        if(start.equals(end)) {
            ladder.add(start);
            return ladder;
        }
        
        Node linkedLadder = bfsMemorry(start.toUpperCase(), end.toUpperCase());
        if(linkedLadder == null) {
            return ladder;
        }

        while(linkedLadder != null) {
            ladder.add(0, linkedLadder.word);
            linkedLadder = linkedLadder.previous;
        }

        return ladder;
    }

    private Node bfsMemorry(String start, String end) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(start, null));
        use(start);
        while(!queue.isEmpty()) {
            Node n = queue.removeFirst();
            String word = n.word;
            for(String neighbor : getNeighbors(word)) {
                if(!isUsed(neighbor)) {
                    Node p = new Node(neighbor, n);
                    if(p.word.compareTo(end) == 0) {
                        return p;
                    }
                    queue.addLast(p);
                    use(p.word);
                }
            }
        }
        return null;
    }

    private void use(String word) {
        usedWords.add(word.toUpperCase());
    }

    //check if a given word has already been in the queue/ used
    private boolean isUsed(String word) {
        return usedWords.contains(word.toUpperCase());
    }


    /**
     * Returns all the words that have a Hamming distance of one relative to the
     * given word.
     *
     * @param  word the given word
     * @return      the neighbors of the given word
     */
    public List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<String>();
        word = word.toUpperCase();
        for(int i = 0; i < word.length(); i++) {
            String possible = word;
            for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                possible = possible.substring(0, i) + alphabet + possible.substring(i + 1, word.length());
                //if it is in the lexicon and it is not the given word add to the list
                if(lexicon.contains(possible) && !neighbors.contains(possible) && !possible.equals(word)) {
                    neighbors.add(possible);
                }
            }
        }

        return neighbors;
    }


    /**
     * Returns the total number of words in the current lexicon.
     *
     * @return number of words in the lexicon
     */
    public int getWordCount(){
        return lexicon.size();
    }


    /**
     * Checks to see if the given string is a word.
     *
     * @param  str the string to check
     * @return     true if str is a word, false otherwise
     */
    public boolean isWord(String str){
        return lexicon.contains(str.toUpperCase());
    }


    /**
     * Checks to see if the given sequence of strings is a valid word ladder.
     *
     * @param  sequence the given sequence of strings
     * @return          true if the given sequence is a valid word ladder,
     *                       false otherwise
     */
    public boolean isWordLadder(List<String> sequence) {
        if(sequence.size() == 0) {
            return false;
        }
        String prev = sequence.get(0).toUpperCase();

        for(int i = 1; i < sequence.size(); i++) {
            String current = sequence.get(i).toUpperCase();
            if(getHammingDistance(current, prev) != 1 || !lexicon.contains(current)) {
                return false;
            }
            prev = current;
        }

        return true;

    }

    ///////////////////////////////////////////////////////////////////////
    //                        PRIVATE CLASSES                            //
    ///////////////////////////////////////////////////////////////////////

    private class Node {
        Node previous;
        String word;

        public Node(String word, Node previous) {
            this.word = word;
            this.previous = previous;
        }
    }
}

