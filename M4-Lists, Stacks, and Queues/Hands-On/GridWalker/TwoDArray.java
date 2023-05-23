public class TwoDArray {
   public static void main(String[] args) {
      int[][] a = new int[4][3];
      for(int i = 0; i < a.length; i++) {
         for(int j =0; j < a[i].length; j++) {
            a[i][j] = 1;
         }
      }
      a[0][2] = 9;
   
      
      printStatement(a);
      
   }

   public static void printStatement(int[][] a) {
      for(int[] row : a) {
         for(int val : row) {
            System.out.print("[" + val + "]");
         }
         System.out.println("");
      }
   }

   
   
}
