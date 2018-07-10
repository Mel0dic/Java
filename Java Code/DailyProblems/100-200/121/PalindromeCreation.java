import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PalindromeCreation{

	public static void main(String[] args){
		// System.out.println(isPalindrome("HellolleH"));
		// System.out.println(isPalindrome("OlevpvolO"));
		// System.out.println(isPalindrome("Orangegnaro"));

		System.out.println(createPalindrome("waterrfetawx", 2));
	}


	/**
	 * Given a string which we can delete at most k, return whether you can make a palindrome.
	 *
	 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
	**/
	public static Boolean createPalindrome(String givenString, int numberOfLettersDeletable){
		char[] stringLetters = givenString.toCharArray();

		if(isPalindrome(givenString) || givenString.length() <= 1){return true;}

		while(stringLetters[0] == stringLetters[stringLetters.length-1]){
			stringLetters = Arrays.copyOfRange(stringLetters, 1, stringLetters.length-2);
		}

		if(numberOfLettersDeletable == 0){
			return false;
		}

		return createPalindrome(String.valueOf(Arrays.copyOfRange(stringLetters, 0 , stringLetters.length-2)), numberOfLettersDeletable - 1) || createPalindrome(String.valueOf(Arrays.copyOfRange(stringLetters, 1, stringLetters.length-1)), numberOfLettersDeletable - 1);
	}

	public static boolean isPalindrome(String palandrome){
		char[] stringArray = palandrome.toCharArray();
		int stringHalfSize = (int)(stringArray.length / 2);
		char[][] tempArray = copyList(stringArray, stringHalfSize);
		for(int i = 0; i < stringHalfSize; i++){
			if(tempArray[0][i] != tempArray[1][i]){
				return false;
			}
		}
		return true;
	}

	public static char[][] copyList(char[] listToFlip, int stringHalfSize){
		char[][] stringBreakDown = new char[2][stringHalfSize];
		if(listToFlip.length % 2 == 0){
			stringBreakDown[0] = Arrays.copyOfRange(listToFlip, 0, stringHalfSize);
			stringBreakDown[1] = Arrays.copyOfRange(listToFlip, (stringHalfSize), listToFlip.length);
		}else{
			stringBreakDown[0] = Arrays.copyOfRange(listToFlip, 0, stringHalfSize);
			stringBreakDown[1] = Arrays.copyOfRange(listToFlip, (stringHalfSize + 1), listToFlip.length);
		}
		stringBreakDown[1] = flipList(stringBreakDown[1]);
		return stringBreakDown;
	}

	public static char[] flipList(char[] listToFlip){
		char[] tempArray = new char[listToFlip.length];
		for(int i = listToFlip.length-1, y = 0; i >= 0; i--, y++){
			tempArray[y] = listToFlip[i];
		}
		return tempArray;
	}

}