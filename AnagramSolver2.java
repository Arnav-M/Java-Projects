import java.util.*;
public class AnagramSolver2 {
   
   Map<String, LetterInventory> dictionary;
   public AnagramSolver2(List<String> list) {
      dictionary = new HashMap<>();
      for(String s : list) {
         dictionary.put(s, new LetterInventory(s));
      }
   }
   
   public void print(String s, int max) {
      if(max < 0) {
         throw new IllegalArgumentException();
      }
      LetterInventory word = new LetterInventory(s);
      Stack<String> toPrint = new Stack<>();
      Map<String, LetterInventory> refined = new HashMap<>();
      for(String check : dictionary.keySet()) {
         if(word.subtract(dictionary.get(check)) != null) {
            refined.put(check, dictionary.get(check));
         }
      }
      explore(word, max, toPrint, refined);
   }
   
   private void explore(LetterInventory word, int max, Stack<String> toPrint, Map<String, LetterInventory> refined) {
      if(max != 0 && toPrint.size() == max && word.isEmpty()) {
         System.out.println(toPrint);
      }
      else if(max == 0 && word.isEmpty()) {
         System.out.println(toPrint);
      }
      else {
         for(String s : refined.keySet()) {
            if(word.subtract(refined.get(s)) != null) {
               toPrint.push(s);
               explore(word.subtract(refined.get(s)), max, toPrint, refined);
               toPrint.pop();
            }
         }
      }
   }
}