// Arnav Mathur
// 1/14/2020
// Homework 1
// Section: BC
// TA: Khushi Chaudhari

// Class LetterInventory can be used to convert string to numbers
// and store the integers, the integers can then be edited, accessed
// or added with other LetterInventories

public class LetterInventory{

   private int[] letterInventory; // stores the count of alphabets 
   private int size; // stores the size of LetterInventory

   public static final int CAPACITY = 26; 
   
   /* Increments the value in the LetterInventory depending on the
      character that is detected.
      Size of the Inventory also increases when values are added.
      String data is used to provide the original String user inputs */
   public LetterInventory(String data) {
      letterInventory = new int[CAPACITY]; 
      data = data.toLowerCase();
      for(int i = 0; i < data.length(); i++){
         char a = data.charAt(i);   
         if(a >= 'a'  && a <= 'z'){
            letterInventory[a - 'a']++;
            size++;
         }
      }
   } 
   
   // Returns the size of the Inventory
   public int size() {
      return size;
   }
   
   // Returns whether or not the Inventory is empty
   public boolean isEmpty() {
      return size == 0;
   }
   
   /* throws IllegalArgumentException if the character detected is not an alphabet
      pre: the letter has to be an alphabet and no other character 
      post:Gets you the number of times a specific letter is present in the string 
      char letter is used to provide a letter to find in the LetterInventory */
   public int get(char letter) {
      if(!Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }
      return letterInventory[Character.toLowerCase(letter) - 'a'];
   }
   
   /* Converts the numbers in the Inventory to alphabets in ascending order
      returns the values with square brackets to indicate it is an Inventory */
   public String toString() {
      String result = "[";
         for (int i = 0; i < CAPACITY; i++) {
            for(int j = 0; j < letterInventory[i]; j++) {
               result += (char)('a' + i);
            }
         }
      result += "]";
      return result;
   }
   
   /* pre: character has to be alphabet, input value for alphabet has to be 
           positive
      post: throws IllegalArgumentException if pre is not satisfied. 
      If pre is satisfied then size increases depending on what value user wants */
   public void set(char letter, int value) {
      if(!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException();
      }
      size += value - letterInventory[Character.toLowerCase(letter) - 'a'];
      letterInventory[Character.getNumericValue(letter) - 10] = value;
   }
   
   /* Creates a LetterInventory object and adds it to the other LetterInventory
      returns a new LetterInventory which is the addition of the two */
   public LetterInventory add(LetterInventory other) {
      LetterInventory newInventory = new LetterInventory("");
      for(int i = 0; i < CAPACITY; i++) {
         newInventory.letterInventory[i] = this.letterInventory[i] + other.letterInventory[i];
         newInventory.size += newInventory.letterInventory[i];
      }
      return newInventory;
   }
    
   /* Creates a LetterInventory object and subtracts the other with this 
      LetterInventory, returns a new LetterInventory which is the 
      difference of the two. If the difference is lesser than zero
      then the value returned is null.*/
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory modifiedInventory = new LetterInventory("");
      for(int i = 0; i < CAPACITY; i++) {
         modifiedInventory.letterInventory[i] = this.letterInventory[i] - other.letterInventory[i];
         modifiedInventory.size += modifiedInventory.letterInventory[i];
         if(modifiedInventory.letterInventory[i] < 0){
            return null;
         }
      }
      return modifiedInventory;
   }  
}
