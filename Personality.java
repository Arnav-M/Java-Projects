// Arnav Mathur
// 5/25/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #7
// This program takes responses of a personality test (A or B) from an input file
// into types of personalities and outputs them into a file. It initially stores 
// the A and B counts in two arrays, then converts the counts into percentages 
// and then finally it converts them into the letters of the personality depending
// on the percentages. It doesn't count the '-' values in the file. 

import java.io.*;
import java.util.*;

public class Personality {
   public static final int TYPES = 4;
   public static void main(String[] args) throws FileNotFoundException {
   
      intro();
      Scanner console = new Scanner(System.in);   
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.next()));      
      System.out.print("output file name? ");
		PrintStream output = new PrintStream(new File(console.next())); 
      
      // Checks if input has a next line.
      while(input.hasNextLine()){
         output.print(input.nextLine() + ": ");
         String line = input.nextLine();
         int[] a = new int[TYPES];
         int[] b = new int[TYPES];
         count(line, a, b);
         int[] percentage = percentageCalculator(a, b); 
         output.println(Arrays.toString(percentage) + " = " + personalityType(percentage));
      }
   }
   
   // Prints out an introduction for the program.
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Counts the responses (either A or B) and increments the response into an array. 
   // Takes two integer arrays as parameters.
   public static void count(String line, int[] a, int[] b) {
      for(int i = 0; i < line.length(); i++){
         if (line.toUpperCase().charAt(i) == 'A') { 
            countIncrementer(a, i); 
		   }
         else if (line.toUpperCase().charAt(i) == 'B') { 
            countIncrementer(b, i);
		   }
      }
   }
   
   // Calculates the percentage of either A or B responses in the file.
   // Takes two integer arrays as parameters.
   // Rounds the number to a whole number.
   public static int[] percentageCalculator(int[] a, int[] b){
      int[] percentage = new int[TYPES];
      for(int i = 0; i < TYPES; i++){
         percentage[i] = (int) Math.round((double)(100 * b[i]) / (a[i] + b[i]));
      }
      return percentage; 
   }
   
   // Finds out the type of personality using the percentage of A's and B's.
   // Takes an integer array with percentages of A's and B's as a parameter.
   // If the A and B values for a specific question are equal, i.e they are 
   // 50 % each it gives X as a dimension.
   public static String personalityType(int[] percentage) {
      String[] options = {"E", "I", "S", "N", "T", "F", "J", "P"};
      String types = ""; 
      for (int i = 0; i < TYPES; i++){
         if (percentage[i] > 50) {
            types = types + options[i * 2 + 1];
         }
         else if (percentage[i] < 50) {
            types = types + options[i * 2];
         }
         else {
            types = types + "X";
         }
      }
      return types;
   }
   
   // Increments the count of A's and B's in their individual arrays.
   // The index of the array where it is incremented depends on its position in the file.
   // Takes an integer array and the position of the A or B as parameters.
   public static void countIncrementer(int[] count, int i) {
      if (i % 7 == 0) {
         count[0]++; 
      }
		if (i % 7 == 1 || i % 7 == 2) {  
		   count[1]++;
		}
		if (i % 7 == 3 || i % 7 == 4) {
		   count[2]++;
		}
		if (i % 7 == 5 || i % 7 == 6) {
		   count[3]++; 
 		}  
   }
}