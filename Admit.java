// Arnav Mathur
// 4/27/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #4
// This program takes in SAT/ACT scores and the GPA of two different students 
// and compares them in order to find out who the better candidate is. It takes
// in user input to get individual scores to calculate the overall score. It rounds
// up the printed scores to one decimal place.

import java.util.*;
public class Admit {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      introduction();
      
      double firstExamScore = information(console, 1);
      double firstGpa = gpaCalculation(console);
      double secondExamScore = information(console, 2);
      double secondGpa = gpaCalculation(console);
      
      double firstCandidate = firstExamScore + firstGpa;
      double secondCandidate = secondExamScore + secondGpa;
      
      scoreComparer(firstCandidate, secondCandidate);
   }
   
   // prints out an introduction for the program.
   public static void introduction() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   // asks the user for what type of exam is given by each applicant
   // prints out his/her individual exam score, returns the exam score.
   public static double information(Scanner console, int applicant) {
      double examScore = 0;
      System.out.println("Information for applicant #" + applicant + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int score = console.nextInt();
      
      if(score == 1) {
         examScore = satCalculation(console);
      }
      else {
         examScore = actCalculation(console);
      }
      
      System.out.printf("    exam score = %.1f", examScore);
      System.out.println();
      return examScore;
   }
   
   // Calculates the overall SAT score of the applicant by asking for individual scores. 
   // Returns the overall SAT score.
   public static double satCalculation(Scanner console) {
      System.out.print("    SAT math? "); 
      int satMath = console.nextInt();
      
      System.out.print("    SAT critical reading? ");
      int satReading = console.nextInt();
      
      System.out.print("    SAT writing? ");
      int satWriting = console.nextInt();
      
      double satExamScore = (2 * satMath + satReading + satWriting)/32.0;
      return satExamScore;
   }
   
   // Calculates the overall ACT score of the applicant by asking for individual scores. 
   // Returns the overall ACT  score.
   public static double actCalculation(Scanner console) {
      System.out.print("    ACT English? "); 
      int actEnglish = console.nextInt();
      
      System.out.print("    ACT math? ");
      int actMath = console.nextInt();
      
      System.out.print("    ACT reading? ");
      int actReading = console.nextInt();
      
      System.out.print("    ACT science? ");
      int actScience = console.nextInt();
      
      double actExamScore = (actEnglish + 2 * actMath + actReading + actScience) / 1.8;
      return actExamScore;
   }
   
   // Calculates the overall GPA of the applicant by asking for individual scores
   // and prints it out. Returns the overall GPA.
   public static double gpaCalculation(Scanner console) {
      System.out.print("    overall GPA? ");
      double gpa = console.nextDouble();
      
      System.out.print("    max GPA? " );
      double max = console.nextDouble();
      
      System.out.print("    Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      
      double gpaScore = (gpa/ max) * 100 * multiplier;
      System.out.printf("    GPA score = %.1f", gpaScore);
      System.out.println();
      System.out.println();
      
      return gpaScore;
   }
   
   // Compares the scores of the two Candidates and prints out the scores.
   // Determines who has the better score and prints out a statement showing who had the
   // better score. 
   public static void scoreComparer(double firstCandidate, double secondCandidate) {
      System.out.printf("First applicant overall score  = %.1f", firstCandidate);
      System.out.println();
      System.out.printf("Second applicant overall score = %.1f", secondCandidate);
      System.out.println();
      
      if(firstCandidate > secondCandidate) {
         System.out.println("The first applicant seems to be better");
      }
      else if(firstCandidate == secondCandidate) {
         System.out.println("The two applicants seem to be equal");
      }
      else {
         System.out.println("The second applicant seems to be better");
      }
   }
   
}