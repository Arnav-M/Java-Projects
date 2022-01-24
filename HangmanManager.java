// Arnav Mathur
// 2/5/2020
// Homework 4
// Section: BC
// TA: Khushi Chaudhari

/* Class HangmanManager is a class that plays a different version of the
   normal hangman game in which the computer doesn't pick a word until
   it needs to, however it picks a pattern and uses that to select the 
   largest set of words with similar patterns and this makes it harder for
   the user to guess that word */

import java.util.*;

public class HangmanManager {
   
   private Set<String> dictionaryWords; 
   private Set<Character> charsUsed; 
   
   private int guesses;
   private String pattern;
    
   /* pre: throws an IllegalArgumentException if length of word is lesser than 1
           or if the maximum number of guesses is lesser than zero
      post: creates a set of the words in that specific dictionary, which means
            there are no duplicates. Also uses a collection of words to make the
            dictionary. Only adds words into the set if they are a specific length
   */        
   public HangmanManager(Collection<String> dictionary, int length, int max) {
      if(length < 1 || max < 0) {
         throw new IllegalArgumentException();
      }
      
      dictionaryWords = new TreeSet<>();
      charsUsed = new TreeSet<>();
      guesses = max;
      pattern = "- "; 
      
      for(String words : dictionary) {
         if(words.length() == length) {
            dictionaryWords.add(words);
         }
      }
      
      for(int i = 1; i < length; i++) {
         pattern += "- ";
      }
   }
   
   // returns the Set of words from the text files currently being used
   public Set<String> words() {
      return dictionaryWords;
   }
   
   // returns the guesses the user has left
   public int guessesLeft() {
      return guesses;
   }
   
   // returns the characters the user has already used to guess
   public Set<Character> guesses() {
      return charsUsed;
   }
   
   /* pre: if the set of words from dictionary is empty it throws IllegalArgument
           -Exception
      post: returns the pattern of words currently being used     
   */
   public String pattern() {
      if(dictionaryWords.isEmpty()) {
         throw new IllegalStateException();
      }
      return pattern;
   }
   
   /* pre: if guesses is lesser than 1 or if the set of words is empty it throws
           IllegalStateException
           if the previous condition is not true and the character set contains the
           guess already guessed then it throws IllegalArgumentException
      post: adds the guess by the user to the character set of characters
            uses patternCreator to create a pattern and use it to see how many
            occurences of that specific pattern are present
            reduces the guesses left if a wrong letter is guessed
            returns occurrences of the guessed letter in the pattern
   */
   public int record(char guess) {
            
      if(guesses < 1 || dictionaryWords.isEmpty() ) {
         throw new IllegalStateException();
      }
 
      if(!dictionaryWords.isEmpty() && charsUsed.contains(guess)) {
         throw new IllegalArgumentException();
      }
      
      Map<String, Set<String>> wordPatterns = new TreeMap<>();
      int ocurrences = 0;
      charsUsed.add(guess);
      
      patternCreator(guess, wordPatterns);
      
      for(int i = 0; i < pattern.length(); i++) {
         if(pattern.charAt(i) == (guess)) {
            ocurrences++;
         }
      }
      if(ocurrences == 0) {
         guesses--;
      }
      return ocurrences;
    }
    
    /* post: creates the patterns and decides which one to use to get an
             adequate word. If the guess is correct it adds it to the pattern. 
             Adds spaces between the dashes to show the letters 
             present in the word. Uses the set which has the most number of words 
             with that specific pattern to confuse the user
    */         
    private void patternCreator(char guess, Map<String, Set<String>> wordPatterns) {
      int most = 0;
      for(String words : dictionaryWords) {
         String newPattern = pattern;
         int spaces = 0;
         for(int i = 0; i < words.length(); i++) {
            if(words.charAt(i) == guess) {
               newPattern = newPattern.substring(0, spaces) + guess + newPattern.substring(spaces + 1);
            }
            spaces += 2;
         }
         if(!wordPatterns.containsKey(newPattern)) {
            wordPatterns.put(newPattern, new TreeSet<>());
         }
         wordPatterns.get(newPattern).add(words);
      }
      for(String pattern : wordPatterns.keySet()) {
         Set<String> word = wordPatterns.get(pattern);
         if(word.size() > most) {
            dictionaryWords = word;
            this.pattern = pattern;
            most = word.size();
         }
      }
    }
}