public class PalindromeCreation{

	public static void main(String[] args){
		System.out.println("Ok");
	}


	/**
	 * Given a string which we can delete at most k, return whether you can make a palindrome.
	 *
	 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
	**/
	public static String createPalindrome(String givenString, int numberOfLetterDeletable){
		String[] stringLetters = givenString.split("");
		for(int i = 0; i < givenString.length(); i++){
			System.out.println(stringLetters[i]);
		}


		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < stringLetters.length; i++) {
		   strBuilder.append(stringLetters[i]);
		}
		String newString = strBuilder.toString();
		return stringLetters.toString();
	}

}