// Arnav Mathur
// 4/15/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #2
// This program prints out a Rocket ship which can be made of variable sizes

public class DrawRocket {

   // changing this value will increase or decrease the overall size of the
   // rocket
   public static final int SIZE = 3;
   
   public static void main(String[] args) {
      top();
      seperator();
      upperHalf();
      lowerHalf();
      seperator();
      lowerHalf();
      upperHalf();
      seperator();
      
      // this prints out the booster engine part of the rocket using the 
      //conical shape used at the top
      top();
   }
   
   // Prints out the top conical part of the rocket ship
   public static void top() {
      for(int i = 1; i <= SIZE * 2 - 1; i++) {
         for(int j = 1; j <= SIZE * 2 - i; j++) {
            System.out.print(" ");
         }
         for(int k = 1; k <= i; k++) {
            System.out.print("/");
         }
         System.out.print("**");
         for(int m = 1; m<= i; m++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   // prints out a seperating line between the top and the body of the rocket
   public static void seperator() {
      System.out.print("+");
      for(int i = 1; i <= 2 * SIZE; i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   // prints out the upper half of the body of the rocket
   public static void upperHalf() {
      for(int i = 1; i <= SIZE; i++) {
         System.out.print("|");
         for(int j = 1; j <= 2; j++) {
            for(int k = 1; k<= SIZE - i; k++) {
               System.out.print(".");
            }
            for(int l = 1; l<= i; l++) {
               System.out.print("/\\");
            }
            for(int m = 1; m<= SIZE - i; m++) {
               System.out.print(".");
            }
         }   
         System.out.println("|");
      }
   }
   
   // prints out a reversed lower half of the rocket body
   public static void lowerHalf() {
      for(int i = SIZE; i >= 1; i--) {
         System.out.print("|");
         for(int j = 1; j <= 2; j++) {
            for(int k = 1; k<= SIZE - i; k++) {
               System.out.print(".");
            }
            for(int l = 1; l<= i; l++) {
               System.out.print("\\/");
            }
            for(int m = 1; m<= SIZE - i; m++) {
               System.out.print(".");
            }
         }   
         System.out.println("|");
      }
   }
}