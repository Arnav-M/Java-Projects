// Arnav Mathur
// 10/6/2019
// CSE 142 B
// TA: Jun Song
// Assignment #2
// This program produces the Space Needle using for loops and variables. 
// It can also be increased in magnification as required.

public class SpaceNeedle {    
   public static void main(String[] args) {
      tip();
      secondPart();
      middle();
      thirdPart();
      tip();
      fourthPart();
      secondPart();
      middle();
   }
   
   // Allows the space needle to increase in size as required.
   public static final int SIZE = 4; 
   
   // Prints the tip of the needle
   public static void tip() {
      for (int i = 1; i <= SIZE ; i++) {
         for (int j = 1; j <= SIZE * 3; j++) {
            System.out.print(" ");
         }
            System.out.println("||");
      }
   }
   
   // Prints the next part of the needle 
   public static void secondPart() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1 ; j <= 3 * SIZE - 3 * i ; j++) {
            System.out.print(" ");
         }
            System.out.print("__/");
         for (int p = 1; p <= 3 * i - 3; p++) {
              System.out.print(":");
         }
         for (int k = 1; k <= 1; k++) {
            System.out.print("||");
         }
         for (int l = 1; l <= 3 * i - 3; l++) {
            System.out.print(":");
         }
         for (int m = 1; m <= 1; m++) {
            System.out.println("\\__");
         }
      
      }
   }
   
   // Prints the middle part which is also reused at the bottom of the needle
   public static void middle() {
      System.out.print("|");
      for (int i = 1; i <= 6 * SIZE; i++){
         System.out.print("\"");
      }
      System.out.println("|");   
   } 
   
   // Prints the part with hills  
   public static void thirdPart() {
      
      for (int line = 1; line <= SIZE; line++) {
         for (int i = 1; i <= 2 * line - 2; i++) {
            System.out.print(" ");
         }
            System.out.print("\\_");
         
         for (int j = 1; j <= -2 * line + (3 * SIZE + 1); j++) {
            System.out.print("/\\");
         }
         for (int k = 1; k <= 1; k++) {
            System.out.println("_/");
         }
      }
   }
   
   // Prints the part with percentage signs
   public static void fourthPart() {
   
      for (int i = 1; i <= SIZE * SIZE; i++) {
         for (int j = 1; j <= 2 * SIZE + 1; j++) {
            System.out.print(" ");
         }
            System.out.print("|");
         for (int k = 1; k <= SIZE - 2; k++) {
            System.out.print("%");
         } 
            System.out.print("||");
         for (int l = 1; l <= SIZE - 2; l++) {
            System.out.print("%");
         }
            System.out.println("|");
         }
   }
}     
