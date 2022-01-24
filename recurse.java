public class recurse {
   public static void main(String[] args) {
      int n = 10;
      printSequence(n);
   }
   
   public static void printSequence(int n) {
      if(n < 1) {
         throw new IllegalArgumentException();
      }
      else if(n == 1) {
         System.out.print("*");
      }
      else if(n == 2 ) {
         System.out.print("**");
      }
      else {
         if((n+1) % 4 == 0) {
            System.out.print("<");
            printSequence(n-2);
            System.out.print(">");

         }
         else {
            System.out.print(">");
            printSequence(n-1);
            System.out.print("<"); 
         }
      }
   }
}