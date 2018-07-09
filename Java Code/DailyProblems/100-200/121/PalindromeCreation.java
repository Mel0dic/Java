import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PalindromeCreation{

	public static void main(String[] args){
		System.out.println(isPalindrome("HellolleH"));
		System.out.println(isPalindrome("OlevpvolO"));
		System.out.println(isPalindrome("Orangegnaro"));

		System.out.println(createPalindrome("TestingnitsgeT", 4));
	}


	/**
	 * Given a string which we can delete at most k, return whether you can make a palindrome.
	 *
	 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
	**/
	public static Boolean createPalindrome(String givenString, int numberOfLettersDeletable){
		String[] stringLetters = givenString.split("");

		if(isPalindrome(givenString)){return true;}

		int minHalfWayPoint = (int) (stringLetters.length / 2) - (numberOfLettersDeletable / 2);
		int maxHalfwayPoint =  ((int) (stringLetters.length / 2)) - 1;

		for(int i = minHalfWayPoint; i <= maxHalfwayPoint; i++){
			System.out.println(i);
		}

		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < stringLetters.length; i++) {
		   strBuilder.append(stringLetters[i]);
		}
		String newString = strBuilder.toString();
		return true;
	}

	public static boolean isPalindrome(String palandrome){
		char[] stringArray = palandrome.toCharArray();
		int stringHalfSize = (int)(stringArray.length / 2);
		char[] firstHalf = new char[stringHalfSize];
		char[] secondHalf = new char[stringHalfSize];
		if(stringArray.length % 2 == 0){
			firstHalf = Arrays.copyOfRange(stringArray, 0, stringHalfSize);
			secondHalf = Arrays.copyOfRange(stringArray, (stringHalfSize), stringArray.length);
		}else{
			firstHalf = Arrays.copyOfRange(stringArray, 0, stringHalfSize);
			secondHalf = Arrays.copyOfRange(stringArray, (stringHalfSize + 1), stringArray.length);
		}
		List<Character> tempList = new ArrayList<Character>();
		for(int i = firstHalf.length-1; i >= 0; i--){
			tempList.add(firstHalf[i]);
		}
		for(int i = 0; i < stringHalfSize; i++){
			if(tempList.get(i) != secondHalf[i]){
				return false;
			}
		}
		return true;
	}

}