// Arnav Mathur
// 2/19/2020
// Homework 4 (bonus)
// Section: BC
// TA: Khushi Chaudhari

// This is a subclass of the HangmanManager that extends HangmanManager
// and does the same thing as the previous class except when user have one guess
// left the class makes the word different to make the user left. It also makes 
// the sets unchangeable.

import java.util.*;
public class HangmanManager2 extends HangmanManager {

   private Set<String> dictionaryWords; 
   private Set<Character> charsUsed; 
   
   public HangmanManager2(Collection<String> dictionary, int length, int max) {
      super(dictionary, length, max);
      dictionaryWords = Collections.unmodifiableSet(super.words());
      charsUsed = Collections.unmodifiableSet(super.guesses());
   }
   
   // post: returns an unchangeable set of guesses
   public Set<Character> guesses() {
      if(charsUsed != super.guesses()) {
         charsUsed = Collections.unmodifiableSet(super.guesses());
      }
      return charsUsed;
   }
   
   // post: returns an unchangeable set of words
   public Set<String> words() {
      if(dictionaryWords != super.words()) {
         dictionaryWords = Collections.unmodifiableSet(super.words());
      }
      return dictionaryWords;
   }
   
   // post: if user has one guess left then it chooses another word
   //       which doesn't have the character guessed by the user to end
   //       the game quicker
   public int record(char guess) {
      if(super.guessesLeft() == 1) {
         Iterator<String> index = super.words().iterator();
         boolean check = true;
         while(index.hasNext() && check) {
            String word = index.next();
            if(word.indexOf(guess) == -1) {
               super.words().clear();
               super.words().add(word);
               check = false;
            }
         }
      }
      return super.record(guess);
   }
}
