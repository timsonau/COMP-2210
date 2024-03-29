import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Boggle implements WordSearchGame {
   private TreeSet<String> lexicon;
   private boolean lexiconLoaded;
   private String[][] board;
   private boolean[][] visited;
   private int numRows;
   private int numColumns;
   private static final int MAX_NEIGHBORS = 8;
   
   public Boggle() {
      lexicon = null;
      lexiconLoaded = false;
   }

   /**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
      try {
         if(fileName == null) {
            throw new IllegalArgumentException();
         }
         File lexiconFile = new File(fileName);
         Scanner fileScanner = new Scanner(lexiconFile);
         lexicon = new TreeSet<String>();
      
         while(fileScanner.hasNext()) {
            String currLine = fileScanner.nextLine();
            int lastIndexOfWord = currLine.indexOf(" ");
            if(lastIndexOfWord == -1) {
               lastIndexOfWord = currLine.length();
            }
            lexicon.add(currLine.substring(0, lastIndexOfWord).toUpperCase());
         }
         fileScanner.close();
         lexiconLoaded = true;
      }
      catch(FileNotFoundException e) {
         throw new IllegalArgumentException("File not found / file cannot be opened");
      }
   }
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is not
    *     square.
    */
   public void setBoard(String[] letterArray){
      if(letterArray == null || !perfectSquareRoot(letterArray.length)) throw new IllegalArgumentException();
      numRows = numColumns = (int)Math.sqrt(letterArray.length);
      board = new String[numRows][numColumns];
      //shows the current index of letter array
      int indexOfLetterArray = 0;
      //goes through each row
      for(int x = 0; x < numRows; x++) {
         for(int y = 0; y < numColumns; y++) {
            board[x][y] = letterArray[indexOfLetterArray].toUpperCase();
            indexOfLetterArray++;
         }
      }
      markAllUnivisited();
   }
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard(){
      String result = "";
      for(String[] row : board) {
         result += "\n";
         for(String letter : row) {
            result += "[" + letter + "]";
         }
      }
      return result;
   }
   
   /**
    * Retrieves all scorable words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllScorableWords(int minimumWordLength){
      if(!lexiconLoaded) throw new IllegalStateException();
      if(minimumWordLength < 1) throw new IllegalArgumentException();
      
      SortedSet<String> allScorableWords = new TreeSet<>();
      for(String word : lexicon) {
         if(word.length() >= minimumWordLength) {
            List<Integer> path = isOnBoard(word);
            if(path.size() > 0) {
               allScorableWords.add(word.toUpperCase());
            }
         }
      }
      return allScorableWords;
   }

   /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength){
      if(!lexiconLoaded) throw new IllegalStateException();
      if(minimumWordLength < 1) throw new IllegalArgumentException();
      
      int score = 0;
      for(String word : words) {
         if(lexicon.contains(word)) {
            if(word.length() >= minimumWordLength){
               List<Integer> path = isOnBoard(word);
               if(path.size() > 0) {
                  score += (1+ (word.length() - minimumWordLength));
               }
            }
         }
      }
      return score;
   }
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      if(wordToCheck == null) throw new IllegalArgumentException();
      
      if(!lexiconLoaded) throw new IllegalStateException();
      
      return lexicon.contains(wordToCheck);
   }
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck){
      if(prefixToCheck == null) throw new IllegalArgumentException();

      if(!lexiconLoaded) throw new IllegalStateException();

      String e = lexicon.ceiling(prefixToCheck);
      return e != null && e.startsWith(prefixToCheck);
   }
       
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck){
      if(wordToCheck == null) throw new IllegalArgumentException("Word to check cannot be null");

      if(!lexiconLoaded) new IllegalStateException("lexicon has not been loaded");

      wordToCheck = wordToCheck.toUpperCase();
      List<Integer> path = new ArrayList<>();
      Position[] positions = letterPositions(wordToCheck);
      
      //if the first word or letter does not exist in the board the word cannot be made
      if(positions.length == 0) return path;

      
      for(Position p : positions) {
         markAllUnivisited();
         String wordSoFar = "";
         if(dfs(p, wordSoFar, path, wordToCheck)) {
            return path;
         }
      }
      return path;
   }

   public boolean dfs(Position p, String wordSoFar, List<Integer> path, String wordToCheck) {
      //base cases
      //if it already has been visited do not bother visiting
      if(visited[p.x][p.y]) {
         return false;
      }
      
      if(!wordToCheck.startsWith(wordSoFar)) {
         return false;
      }

      visit(p);
      wordSoFar += board[p.x][p.y];
      path.add(toRowMajorOrder(p));

      if(wordSoFar.compareTo(wordToCheck) == 0) {
         return true;
      }
      
      //visitis all the valid neighbors
      for(Position neighbor : p.neighbors()) {
         if(dfs(neighbor, wordSoFar, path, wordToCheck)) {
            return true;
         }
      }

      //no positions has a valid path
      wordSoFar = wordSoFar.substring(0, wordSoFar.length() - board[p.x][p.y].length());
      path.remove(path.size() - 1);
      unvisit(p);
      return false;

   }
   

   /**
    * converts the current (x, y) position to row major order
    */
   private int toRowMajorOrder(Position p) {
      return p.x * numColumns + p.y;
   }

   private class Position {

      int x;
      int y;
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }
   
      //string representation of the cordinate position of the object
      @Override
      public String toString() {
         return "(" + x + "," + y + ")";
      }
   
      /**
       * returns an array of positions adjacent to the current position
       */
      public Position[] neighbors() {
         Position[] neighbors = new Position[MAX_NEIGHBORS];
         int counter = 0;
         for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
               if(j != 0 || i != 0) {
                  Position p = new Position(x + i, y + j);
                  if(isValid(p)) {
                     neighbors[counter++] = p;
                  }
               }
            }
         }
         return Arrays.copyOf(neighbors, counter);
      }
   }

   //*************************************************************//
   //*****************Private Utility Methods********************//
   //************************************************************//
   
   /**
    * checks if a number is a perfect square root.
    */
   private boolean perfectSquareRoot(int num) {
      //if the number is a perfect square it must be a whole number
      double sqrtNum = Math.sqrt(num);
      //if the number is a whole number the closest whole number of sqrtNum and sqrtNum must be equal.
      return sqrtNum == Math.ceil(sqrtNum);
   }

   /**
    * intializes the visisted board to false
    */
   private void markAllUnivisited() {
      visited = new boolean[numRows][numColumns];
      for(int x = 0; x < numRows; x++) {
         for(int y = 0; y < numColumns; y++) {
            visited[x][y] = false;
         }
      }
   }


   /**
    * returns an array of postions of the index of a given word
    * ex letterPositions("Tottenham", 0) would return all the postions in the board that contain "T"
    */
   private Position[] letterPositions(String word) {
      Position[] letterPositions = new Position[numRows * numColumns];
      int count = 0;
      for(int x = 0; x < numRows; x++) {
         for(int y = 0; y < numColumns; y++) {
            //if the word sought after beings with any string in the board it could be a possible first string
            if(word.startsWith(board[x][y])) {
               letterPositions[count++] = new Position(x, y);
            }
         }
      }
      //brings back an array of possible first letter positions
      return Arrays.copyOf(letterPositions, count);
   }

   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.y >= 0) && (p.x < numRows) && (p.y < numColumns);
   }

   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }

   private void unvisit(Position p) {
      visited[p.x][p.y] = false;
   }
}
