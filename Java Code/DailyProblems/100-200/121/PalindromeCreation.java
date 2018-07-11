import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PalindromeCreation{

	public static void main(String[] args){
		// System.out.println(isPalindrome("HellolleH"));
		// System.out.println(isPalindrome("OlevpvolO"));
		// System.out.println(isPalindrome("Orangegnaro"));

		System.out.println(createPalindrome("awatearrfetawx", 4));
		System.out.println(k_palindrome("awatearrfetawx", 4));
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
			stringLetters = Arrays.copyOfRange(stringLetters, 1, stringLetters.length-1);
			if(stringLetters.length <= 1){
				return true;
			}
		}

		if(numberOfLettersDeletable == 0){
			return false;
		}

		return createPalindrome(String.valueOf(Arrays.copyOfRange(stringLetters, 0 , stringLetters.length-1)), numberOfLettersDeletable - 1) || createPalindrome(String.valueOf(Arrays.copyOfRange(stringLetters, 1, stringLetters.length)), numberOfLettersDeletable - 1);
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

	//SOLUTION 0^(N^2)
	public static boolean k_palindrome(String stringToBreak, int k){
		//If the string length - longest palindromic subsequence of the string is smaller than k ie less changes made than k return true
		return stringToBreak.length() - longest_palindromic_subsequence(stringToBreak) < k;
	}

	public static int longest_palindromic_subsequence(String string){
		// def longest_palindromic_subsequence(s):
	 //    	if s == s[::-1]:
	 //    	    return len(s)
		
	 //    	n = len(s)
	 //    	A = [[0 for j in range(n)] for i in range(n)]
		
	 //    	for i in range(n - 1, -1, -1):
	 //    	    A[i][i] = 1
	 //    	    for j in range(i + 1, n):
	 //    	        if s[i] == s[j]:
	 //    	            A[i][j] = 2 + A[i + 1][j - 1]
	 //    	        else:
	 //    	            A[i][j] = max(A[i + 1][j], A[i][j - 1])
	
  //   		return A[0][n - 1]

		char[] s = string.toCharArray();

		if(isPalindrome(string)){
			return s.length;
		}

		int n = s.length;
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(arr[i], 0);
		}

		for(int i = n - 1; i > -1; i--){
			arr[i][i] = 1;
			for(int j = i + 1; j < n; j++){
				if(s[i] == s[j]){
					arr[i][j] = 2 + arr[i + 1][j - 1];
				}else{
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
				}
			}
		}

		return arr[0][n - 1];

	}

}