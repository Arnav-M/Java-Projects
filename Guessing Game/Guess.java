// Arnav Mathur
// 5/5/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #5
//
// This program plays a guessing game with the user in which a number
// from 1 to 100 is chosen randomly and the user has to guess that number.
// The game can be played multiple times and also prints out statistics at the
// end of the games which show the total games, total guesses, guesses per game
// and the best game. The user input to continue the game is not case sensitive.
// The range of numbers which can be the guess can be increased or decreased.

import java.util.*;
public class Guess {

   public static final int MAX_GUESS = 100;
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random r = new Random();
      int games = 0;
      int maximumGuesses = 10000;
      int totalGuesses = 0;
      int gameGuesses = 0;
      String choice = "";
      boolean gameWorking = true;
      
      introduction();
      
      // Starts the game.
      while(gameWorking) {
         gameGuesses = game(console, r);        
         if(gameGuesses < maximumGuesses) {
            maximumGuesses = gameGuesses;
         }
         games++;
         totalGuesses += gameGuesses;
         
         System.out.print("Do you want to play again? ");
         choice = console.next();
         System.out.println();
         if(!(choice.startsWith("Y") || choice.startsWith("y"))) {
            gameWorking = false;
         }
      }
      gameStatistics(maximumGuesses, games, totalGuesses);
   }
   
   // Prints out an introduction for what the program does.
   public static void introduction() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // This method is used to continue the game and also lets the user know if they
   // guessed the number correctly, if they haven't guessed the correct answer it 
   // gives a hint to help. Returns the amount of guesses in that particular game.
   // Takes scanner console for user input.
   // Takes a Random r for producing a random number
   public static int game(Scanner console, Random r) {
      System.out.println("I'm thinking of a number between 1 and " + MAX_GUESS + "...");
      
      int randomNum = r.nextInt(MAX_GUESS) + 1;
      boolean gameWorking = true;
      int guesses = 0; 
      
      while(gameWorking) {
         System.out.print("Your guess? ");
         int guess = console.nextInt();
         guesses++;       
         if(guess == randomNum) {
            gameWorking = false;
         }
         else if (guess > randomNum) {
            System.out.println("It's lower.");
			}
         else {
				System.out.println("It's higher.");
			}
      }
      
      if(guesses != 1) {
         System.out.println("You got it right in " + guesses + " guesses");
      }
      else {
         System.out.println("You got it right in 1 guess");
      }
      return guesses;
   }
   
   // Print out the statistics for all the games played.
   // Takes the least guesses guessed in one game, the number of games and the total
   // guesses in all the games as parameters. 
   public static void gameStatistics(int maximumGuesses, int games, int totalGuesses) {
      double guessesPerGame = ((10.0 * totalGuesses) / games) / 10;
      System.out.println("Overall results:");
		System.out.println("    total games   = " + games);
		System.out.println("    total guesses = " + totalGuesses);
		System.out.printf("    guesses/game  = %.1f \n" , guessesPerGame);
		System.out.println("    best game     = " + maximumGuesses);
   }
}