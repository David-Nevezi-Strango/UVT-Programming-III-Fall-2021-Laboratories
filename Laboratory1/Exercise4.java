package Laboratory1;

/*
 * Given a sentence from the command line, write functions to:
 * a) Display the number of words in the sentence.
 * b) Display the number of palindrome words in the sentence.
 * c) Display the last X sentence's characters.
 * d) Transform the sentence upper case and lower case.
 * e) Check if a subsequence is present in the sentence.
 * f) Transform the sentence so that each X vocal is substituted by XpX.
 * For example: A -> ApA, E -> EpE.
 * 
 * ATTENTION! A word can be separated by one or more non-letter characters.
 */

public class Exercise4 {
	public static void main(String args[]) {
		final String sentence = args[0];

		/*
		 * a) Display the number of words in the sentence.
		 */
		System.out.println(countWords(sentence));

		/*
		 * b) Display the number of palindrome words in the sentence.
		 */
		System.out.println(countPalindromeWords(sentence));

		/*
		 * c) Display the last X sentence's characters.
		 */
		int X = 10;
		System.out.println(sentence.substring(sentence.length() - X));

		/*
		 * d) Transform the sentence upper case and lower case.
		 */
		System.out.println(sentence.toUpperCase());
		System.out.println(sentence.toLowerCase());

		/*
		 * e) Check if a subsequence is present in the sentence.
		 */
		String subsequenceToFind = "radar";
		if (sentence.contains(subsequenceToFind)) {
			System.out.println(sentence + " contains: " + subsequenceToFind);
		} else {
			System.out.println(sentence + " does not contain: " + subsequenceToFind);
		}

		/*
		 * f) Transform the sentence so that each X vocal is substituted by XpX. For
		 * example: A -> ApA, E -> EpE.
		 */
		System.out.println(transformSentence(sentence));
	}

	private static int countWords(String sentence) {
		int wordsCounter = 0;
		boolean lastCharacterWasLetter = false;
		for (int i = 0; i < sentence.length(); ++i) {
			if (Character.isLetter(sentence.charAt(i))) {
				if (!lastCharacterWasLetter) {
					wordsCounter++;
					lastCharacterWasLetter = true;
				}
			} else {
				lastCharacterWasLetter = false;
			}
		}
		return wordsCounter;
	}

	/*
	 * Lecture: How to extract words from a String using regular expressions?
	 * https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a
	 * -string-array-of-words-in-java
	 */
	private static int countPalindromeWords(String sentence) {
		int palindromeWordsCounter = 0;
		sentence += " ";
		boolean lastCharacterWasLetter = false;
		String currentWord = "";
		for (int i = 0; i < sentence.length(); ++i) {
			if (Character.isLetter(sentence.charAt(i))) {
				if (!lastCharacterWasLetter) {
					lastCharacterWasLetter = true;
				}
				currentWord += sentence.charAt(i);
			} else {
				if (lastCharacterWasLetter) {
					palindromeWordsCounter += (isPalindrome(currentWord) ? 1 : 0);
					currentWord = "";
				}
				lastCharacterWasLetter = false;
			}
		}
		return palindromeWordsCounter;
	}

	private static boolean isPalindrome(String word) {
		int size = word.length();
		for (int i = 0; i < size; ++i) {
			if (word.charAt(i) != word.charAt(size - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	private static String transformSentence(String sentence) {
		char[] vocals = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (char vocal : vocals) {
			sentence = sentence.replace("" + vocal, vocal + "p" + vocal);
		}
		return sentence;
	}
}