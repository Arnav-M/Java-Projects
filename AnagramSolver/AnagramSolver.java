// Arnav Mathur
// 2/28/2020
// Homework 6
// Section: BC
// TA: Khushi Chaudhari

/* Class AnagramSolver is used by AnagramMain to create anagrams of input typed by the user
   using a dictionary that is already pre-defined. The words input can be upper or lowercase.
   It uses LetterInventory class to search through words and make their anagrams. The user can
   also set a maximum which decides how many words will be present in the anagrams. If 0 is 
   entered all the possible anagrams will be printed.
*/
import java.util.*;

public class AnagramSolver {
   
   private Map<String, LetterInventory> anagrams;
   private List<String> dictionary;
   
   /* uses the dictionary to find words and stores them
   */
   public AnagramSolver(List<String> dictionary) {
      anagrams = new HashMap<>();
      this.dictionary = dictionary;
      for(String words : dictionary) {
         anagrams.put(words, new LetterInventory(words));
      } 
   }
   
   /* pre: if max entered by user is lesser than zero then it throws IllegalArgumentException
      post: prints out anagrams of the original word
   */
   public void print(String text, int max) {
      if(max < 0) {
         throw new IllegalArgumentException();
      }
      
      LetterInventory usableWords = new LetterInventory(text);
      Queue<String> listOfAnagrams = new LinkedList<>();
      Stack<String> finalStack = new Stack<String>();
      
      for(String words : dictionary) {
         if(usableWords.subtract(anagrams.get(words)) != null) {
             listOfAnagrams.add(words);
          }
      }
      recursivePrinting(finalStack, usableWords, listOfAnagrams, max);
   }
   
   /* pre: 1) - number of words in the same anagram found are lesser than or equal to max and 
              - all anagrams are found and 
              - max is not equal to zero
              
           2) - all anagrams are found and 
              - max is equal to zero
              
      post: prints out the anagrams if either of the two conditions are true
            otherwise continues to find anagrams of the word provided.
   */ 
   private void recursivePrinting(Stack<String> finalStack, LetterInventory letters, 
                                 Queue<String> listOfAnagrams, int max) {
      if((finalStack.size() <= max && letters.isEmpty() && max != 0) || 
         (letters.isEmpty() && max == 0)) {
         System.out.println(finalStack);
      }
      else {
         for(String words : listOfAnagrams) {
            if(letters.subtract(anagrams.get(words)) != null) {
               finalStack.push(words);
               recursivePrinting(finalStack,letters.subtract(anagrams.get(words)), 
                                                         listOfAnagrams, max);
               finalStack.pop();
            }
         }
      }
   }
}
