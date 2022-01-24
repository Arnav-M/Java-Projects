import java.util.*;

public class AnagramSolver {

    private List<String> dictionary;
    private Map<String, List<String>> anagramDictionary;

    public AnagramSolver(List<String> dictionary) {
        if (dictionary.isEmpty()) {
            throw new IllegalArgumentException("Dictionary is Empty!");
        } else {
            this.dictionary = dictionary;

            prepareAnagramDictionary();
        }
    }

	/**
	 * Store all combinations of words from the dictionary
	 * into an Anagram dictionary
	 */
    private void prepareAnagramDictionary(){
        anagramDictionary = new HashMap<String, List<String>>();

        for (String word : dictionary) {
            // Extract a Letter Inventory for each word
            LetterInventory key = new LetterInventory(word);
			// Store them into the Anagram Dictionary map
            if (anagramDictionary.containsKey(key.toString())){
                anagramDictionary.get(key.toString()).add(word);
            } else  {
                List<String> values = new ArrayList<String>();
				// Register a new value set
                values.add(word);
				// Assign the key with the new value set
                anagramDictionary.put(key.toString(),values);
            }
        }
    }

	/**
	 * Extract a String list from the given letter inventory
	 * Each element in the list serves as key for Anagram Dictionary map
	 */
    private List<String> allAnagramsOf(LetterInventory sLi){
        List<String> anagramList = new ArrayList<String>();

        for (String word : dictionary) {
	        // Extract a Letter Inventory for each word
            LetterInventory wordLi = new LetterInventory(word);
            // Extract a Letter inventory of leftover letters
            LetterInventory leftOverLi = sLi.subtract(wordLi);
            // If leftover words is unknown, store the word letter inventory
            if (leftOverLi != null && !anagramList.contains(wordLi.toString())){
                anagramList.add(wordLi.toString());
            }
        }

        return anagramList;
    }

	/**
	 * Recursively print all of the anagrams
	 * @param out           Stack of Chosen Strings
	 * @param root          Letters to use
	 * @param choices       Choices available
	 * @param max           Maximum size of Chosen String Stack
	 */
    private void printAnagrams(Stack<String> out, LetterInventory root,
                               List<String> choices,
                               int max){
        if (root!=null && (out.size()<=max||max==0)){x:
	        if (root.isEmpty() && (out.size()==max||max==0)){
		        debugLog(out);
	        } else {
		        for (String choice : choices) {
                    LetterInventory choiceLi = new LetterInventory(choice);
                    // For each choice, get a set of leftover letters
			        LetterInventory leftOverLi = root.subtract(choiceLi);
					// Get the list of word mapped to each choice
			        List<String> words = anagramDictionary.get(choice);
					// For each word in the word list:
			        for (String word : words) {
				        out.push(word);
						// Recursive with the new Stack:
				        printAnagrams(out, leftOverLi, choices, max);
						// Pop the word, Back track to Previous Stack
				        out.pop();
			        }
		        }
            }
        }
    }

    /**
     * Print all anagrams series of a given words. Each series are
     * restricted to a maximum word, and a given dictionary.
     * @param s                             String to search for anagram
     * @param max                           Maximum words for each anagram series
     * @throws IllegalArgumentException     If max is smaller than 0
     */
    public void print(String s, int max) {
        if (max < 0){
            throw new IllegalArgumentException("Max < 0");
        } else {
            LetterInventory lettersToUse = new LetterInventory(s);
			// Extract a list of keys from the word
            List<String> choices = allAnagramsOf(lettersToUse);

            Stack<String> answerStack = new Stack<String>();
			// Begin the Back track Recursion Loop:
            printAnagrams(answerStack, lettersToUse, choices, max);
        }
    }

}