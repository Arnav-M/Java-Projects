// Arnav Mathur
// 4/15/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #2
// This program prints out a random ascii art

public class AsciiArt {
   public static void main(String[] args) {
      System.out.println(" _____________________________________ ");
      slashes();
      middle();
      slashes();
      System.out.println("|_____________________________________|");
   }
   
   public static void slashes() {
      System.out.println("| \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\   //////////////// |");
   }
   
   public static void middle() {
      for (int i = 1; i <= 4; i++){
         System.out.println("|                 | |                 |");
      }  
   }
}
   