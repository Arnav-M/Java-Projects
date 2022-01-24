// Arnav Mathur
// 11/12/2019
// CSE 142 B
// TA: Jun Song
// Assignment #6
// This program creates a new mad lib file using placeholders and user input.
// It can either create or view a mad lib.

import java.io.*;
import java.util.*;

public class MadLibs {
	public static void main(String[] args)throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
      intro();
      
      boolean playGame = true;	
		while(playGame){
			playGame = menu(console);		
		}
	} 
   
   // introductory paragraph explaining what the code does, what the game is about.
   public static void intro(){
      System.out.println("Welcome to the game of Mad Libs.");
		System.out.println("I will ask you to provide various words ");
		System.out.println("and phrases to fill in a story.");
		System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // method that shows the menu for the user and asks for either a creation of a mad lib
   // or the viewing of a mad lib or quitting of the game.
	public static boolean menu(Scanner console) throws FileNotFoundException{
		System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
		String answer = console.nextLine();
      
		if(answer.toLowerCase().equals("c")){
			create(console);
			return true;
		}
		else if(answer.toLowerCase().equals("v")){
			view(console);
			return true;
		}
		else if(answer.toLowerCase().equals("q")){
			return false;
		}
		else{
			 return true;
		}
	}
   
   // Creates a mad lib, using a previous file.
   // Replaces placeholders with words input by users
   // Prompts again if previous file is not found.
	public static void create(Scanner console)throws FileNotFoundException{
		System.out.print("Input file name: ");
		String fileName = console.nextLine(); // checks for a previous file with placeholders.
      
		File inputFile = new File(fileName);
      
		while(!inputFile.exists()){
			System.out.print("File not found. Try again: ");
			fileName = console.nextLine(); // prompts the user for input again if file not found.
			inputFile = new File(fileName);
		}
      
		System.out.print("Output file name: "); 
      // creates a new file or overwrites a previous output.
		String outputFileName = console.nextLine();
      
		File outputFile = new File(outputFileName);
      System.out.println();
      
		PrintStream output = new PrintStream(outputFile);
		Scanner input = new Scanner(inputFile);
		
		while(input.hasNextLine()){
         String sentence = input.nextLine();
         Scanner line = new Scanner(sentence);
      
         while(line.hasNext()){
			   String text = line.next();
         
			   if(text.startsWith("<") && text.endsWith(">")){ // Replaces placeholders.
				
				   char letter = text.toLowerCase().charAt(1);
				   String first = aOrAn(letter);
            
               int length = text.length();
               text = text.substring(1, length - 1);
            
               text = text.replace("-", " ");
               text = " " + text;
            
               System.out.print("Please type" + first + text + ": ");
               String word = console.nextLine();
               output.print(word + " ");   
			      }
			   else{
				   output.print(text + " ");
			   }
		   }
      output.println();
	}
	System.out.println("Your mad-lib has been created!");
   System.out.println();
}	

   // Prints the file which has been previously been made
	public static void view(Scanner console)throws FileNotFoundException{
      System.out.print("Input file name: ");
      String name = console.nextLine();
      
      File outputFile = new File(name);
      
      while(!outputFile.exists()) {
         System.out.print("File not found. Try again: ");
         name = console.nextLine();
         outputFile = new File(name);
      }
      
      Scanner forLine = new Scanner(outputFile);
      System.out.println();
      
      while(forLine.hasNextLine()){
         String line = forLine.nextLine();
         System.out.println(line);
      }
      System.out.println();
   }
   
   // Checks for vowels to ensure grammar is correct.
	public static String aOrAn(char letter){
		String firstChar;
		if(letter == 'a' || letter == 'A' || letter == 'i' || letter == 'I' 
			|| letter == 'i' || letter == 'e' || letter == 'E' ||
			letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U'){
         
			firstChar = " an";
		}
		else{
			firstChar = " a";
		}
		return firstChar;
	}
}