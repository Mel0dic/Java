import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PalindromeCreation{

	public static void main(String[] args){
		System.out.println(isPalindrome("HellolleH"));
		System.out.println(isPalindrome("OlevpvolO"));
		System.out.println(isPalindrome("Orangegnaro"));

		System.out.println(createPalindrome("waterrfetawx", 2));
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

		char[][] lists = flipList(givenString);

		return true;
	}

	public static boolean isPalindrome(String palandrome){
		char[] stringArray = palandrome.toCharArray();
		int stringHalfSize = (int)(stringArray.length / 2);
		char[][] tempArray = flipList(stringArray, stringHalfSize);
		for(int i = 0; i < stringHalfSize; i++){
			if(tempArray[0][i] != tempArray[1][i]){
				return false;
			}
		}
		return true;
	}

	public static char[][] flipList(char[] listToFlip, int stringHalfSize){
		char[][] stringBreakDown = new char[2][stringHalfSize];
		if(listToFlip.length % 2 == 0){
			stringBreakDown[0] = Arrays.copyOfRange(listToFlip, 0, stringHalfSize);
			stringBreakDown[1] = Arrays.copyOfRange(listToFlip, (stringHalfSize), listToFlip.length);
		}else{
			stringBreakDown[0] = Arrays.copyOfRange(listToFlip, 0, stringHalfSize);
			stringBreakDown[1] = Arrays.copyOfRange(listToFlip, (stringHalfSize + 1), listToFlip.length);
		}
		char[] tempArray = new char[stringHalfSize];
		for(int i = stringBreakDown[0].length-1, y = 0; i >= 0; i--, y++){
			tempArray[y] = stringBreakDown[1][i];
		}
		stringBreakDown[1] = tempArray;
		return stringBreakDown;
	}

}