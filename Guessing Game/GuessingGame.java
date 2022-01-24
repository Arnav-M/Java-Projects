// Arnav Mathur
// 10/28/2019
// CSE 142 B
// TA: Jun Song
// Assignment #5
// This program plays a guessing game with the user in which a number
// from 1 to 100 is chosen randomly and the user has to guess that number.

import java.util.*;
public class GuessingGame {

   //decides the max number possible in the guess
   public static final int MAX = 100;
     
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      
      // initializes the variables
      int noOfGames = 0;
		int maxGuesses = 1000000; // assumes max no. of guesses is not more than a million
		double totalGuesses = 0;
		int userGuesses = 0;
      String choice = "";
		boolean gameEnd = false;
      
		intro();		
      
		// starts the game	
		while (gameEnd == false) {
			userGuesses = gameCode(console, totalGuesses, rand);
			totalGuesses += userGuesses;

			if (userGuesses < maxGuesses) {
				maxGuesses = userGuesses;
			}
			noOfGames++;
			
			System.out.print("Do you want to play again? ");
			choice = console.next();

         if(choice.startsWith("Y") || choice.startsWith("y")) {
            gameEnd = false;
         }
         else {
            gameEnd = true;
         }
		}
		gameStats(maxGuesses, noOfGames, totalGuesses); 
	}
	
   // haiku method
	public static void intro() {
		System.out.println("Let's play a game where");
      System.out.println("you type in numbers and guess");
      System.out.println("what is on my mind");
	}
   
   // method for the game	
   // returns total number of guesses input by the user
   // Scanner console: Takes in user input 
   // double totalGuesses: total no. of guesses
	public static int gameCode(Scanner console, double totalGuesses, Random rand) {
		System.out.println();
		System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
		
		int number = rand.nextInt(MAX) + 1; // values should be in range of 1 and MAX value
		boolean gameEnd = false;
		int noOfGuesses = 0;
		
		while (gameEnd == false) {
			System.out.print("Your guess? ");
			int guess = console.nextInt();
			noOfGuesses++;
			
			if (guess == number) {
            if (noOfGuesses != 1) {
				   System.out.println("You got it right in " + noOfGuesses + " guesses!");
				   gameEnd = true;
            }
            else {
               System.out.println("You got it right in 1 guess!");
               gameEnd = true;
            }
         }
         else if (guess > number) {
				System.out.println("It's lower.");
			}
         else {
				System.out.println("It's higher.");
			}
		}
		return noOfGuesses;
	}
	
   // calculates statistics for the game
   // returns a decimal value for Total Guesses
   // int maxGuesses: max no. of guesses
   // int games: total no. of games
	public static double gameStats(int maxGuesses, int games, double totalGuesses) {
      System.out.println();
      double decimalTotalGuesses = ((10*totalGuesses)/games)/10;
		System.out.println("Overall results:");
		System.out.println("Total games   = " + games);
		System.out.printf("Total guesses = %.0f \n" , totalGuesses);
		System.out.printf("Guesses/game  = %.1f \n" , decimalTotalGuesses);
		System.out.println("Best game     = " + maxGuesses);
      return decimalTotalGuesses;
	}
}