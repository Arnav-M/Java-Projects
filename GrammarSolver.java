// Arnav Mathur
// 2/13/2020
// Homework 5
// Section: BC
// TA: Khushi Chaudhari

/* Class GrammarSolver is a program that gets a type of grammar and changes it 
   to make new phrases. It accesses each type of grammar and goes into its types
   to add more grammar. It uses BNF formatting for grammar. When it prints
   grammar it removes extra spaces.
*/

import java.util.*;

public class GrammarSolver {
   
   private SortedMap<String, String[]> grammar;
   
   /* pre: if the String list is empty it will throw a IllegalArgumentException.
           if the map that contains the grammar has two or more for the same
           non-terminal it throws IllegalArgumentException.
      post: constructs a map with grammar and splits the grammar into terminal 
            and non-terminals.
   */ 
   public GrammarSolver(List<String> rules) {
      if(rules.isEmpty()) {
         throw new IllegalArgumentException();
      }
      grammar = new TreeMap<>();
      for(String words : rules) {
         String[] splitOne = words.split("::=");
         String[] splitTwo = splitOne[1].trim().split("[|]");
         
         if(grammar.containsKey(splitOne[0])) {
            throw new IllegalArgumentException();
         }
         
         grammar.put(splitOne[0], splitTwo);
      }
   }
   
   // returns if grammar contains the symbol given. 
   public boolean grammarContains(String symbol) {
      return grammar.containsKey(symbol);
   }
   
   // returns the symbols in the form of Strings
   public String getSymbols() {
      return grammar.keySet().toString();
   }
   
   /* pre: if number of times is lesser than 0 then throw 
           IllegalArgumentException.
      post: Generates the grammar randomly using the helper method.
            returns a String array.
   */
   public String[] generate(String symbol, int times) {
      if(!grammarContains(symbol) || times < 0) {
         throw new IllegalArgumentException();
      }
      String[] result = new String[times];
      for(int i = 0; i < times; i++) {
         result[i] = helper(symbol).trim();
      }
      return result;
   }
   
   /* post: Creates a random number to generate rules with equal probability.
            Prints out random grammars depending on user input.
            Removes extra spaces between grammars. Returns the string result.
   */
   private String helper(String symbol) {
      String result = "";
      String[] terminal = grammar.get(symbol);
      Random r = new Random();
      int randomNumber = r.nextInt(terminal.length);
      String[] subTerminal = terminal[randomNumber].trim().split("[ \t]+");
      
      for(String words : subTerminal) {
         if(grammar.containsKey(words.trim())) {
            result += helper(words.trim());   
         }
         else {
            result += words + " ";
         }
      }
      return result;
   }
}