// Arnav Mathur
// 3/3/2020
// Homework 7
// Section: BC
// TA: Khushi Chaudhari

/* Class QuestionTree is a class which asks questions to the user and learns more answers
   to questions everytime it does not answer a question correctly by asking the user the answer to
   that question. Originally it only knows one answer which is "computer". The user can answer
   either yes or no to any question the program asks. The class can also write the questions to 
   an output file and read it back in. Uses class QuestionNode to function.   
*/
import java.util.*;
import java.io.*;

public class QuestionTree {

   private Scanner console;
   private QuestionNode overallRoot;   
   
   
   // Constructs the questions and answers tree.
   public QuestionTree() {
      console = new Scanner(System.in);
      overallRoot = new QuestionNode("computer");
   }
   
   // Replaces the current question tree with another. 
   public void read(Scanner input) {
      while(input.hasNext()) {
         overallRoot = inputReader(input);
      }
   }
   
   /* Replaces the current question tree with another by finding out what part of diagram is a
      question and what is an answer. Returns the previous question tree. 
   */
   private QuestionNode inputReader(Scanner input) {
      String dataType = input.nextLine();
      String data = input.nextLine();
      QuestionNode root = new QuestionNode(data);
      
      if(dataType.contains("Q:")) {
         root.yes = inputReader(input);
         root.no = inputReader(input);
      }
      return root;
   }
   
   /* pre: Checks if a specific part of the question tree is an answer or question.
      post: returns true if it is an answer, false if it is a question.
   */
   private boolean check(QuestionNode ans) {
      return(ans.yes == null || ans.no == null);
   }
   
   // Stores the current tree into a new file 
   public void write(PrintStream output) {
      write(overallRoot, output); 
   }
   
   /* pre: If the current part of tree is a question it writes the question
           otherwise writes the answer to the specific question
   */
   private void write(QuestionNode overallRoot, PrintStream output) {
      if(!check(overallRoot)) {
         output.println("Q:");
         output.println(overallRoot.data);
         write(overallRoot.yes, output);
         write(overallRoot.no, output);
      }
      else {
         output.println("A:");
         output.println(overallRoot.data);
      }
   }
   
   /* Asks questions to the user and if the program does not manage to guess correctly then
      adds the new answers to the original tree of questions and answers.
   */ 
   public void askQuestions() {
      overallRoot = askQuestions(overallRoot);
   }
   
   /* pre: Checks if the current part of tree is an answer.
      post: If it is an answer then it guesses the object, if the guess is right it wins the
            game otherwise asks questions to add the answer to the original tree.
            If it is a question then it continues the program to decide whether the answers are
            yes or no. Returns the tree of questions and answers.
   */
   private QuestionNode askQuestions(QuestionNode current) {
      if(check(current)) {
         if(yesTo("Would your object happen to be " + current.data + "?")) {
            System.out.println("Great, I got it right!");
         }
         else {
            System.out.print("What is the name of your object? ");
            QuestionNode answer = new QuestionNode(console.nextLine());
            System.out.println("Please give me a yes/no question that ");
            System.out.println("distinguishes between your object");
            System.out.print("and mine--> ");
            String line = console.nextLine();
            
            if(yesTo("And what is the answer for your object?")) {
               current = new QuestionNode(line, answer, current);
            }
            else {
               current = new QuestionNode(line, current, answer);
            }
         }              
      }
      else if(yesTo(current.data)) {
         current.yes = askQuestions(current.yes);
      }
      else {
         current.no = askQuestions(current.no);
      }
      return current;
   }
   
   // post: asks the user a question, forcing an answer of "y " or "n";
   // returns true if the answer was yes, returns false otherwise
   public boolean yesTo(String prompt) {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
      while (!response.equals("y") && !response.equals("n")) {
         System.out.println("Please answer y or n.");
         System.out.print(prompt + " (y/n)? ");
         response = console.nextLine().trim().toLowerCase();
      }
      return response.equals("y");
   }
}
