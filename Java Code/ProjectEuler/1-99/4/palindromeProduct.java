/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class palindromeProduct{

	public static void main(String[] args){
		new palindromeProduct();
	}

	public palindromeProduct(){
		int largestPalindrome = 0;
		for(int i = 100; i < 1000; i++){
			for(int k = 100; k < 1000; k++){
				if(isPalindrome((i * k)) && (i * k) > largestPalindrome){
					largestPalindrome = (i * k);
				}
			}
		}
		System.out.println(largestPalindrome);
	}

	public boolean isPalindrome(int number){
		String current = Integer.toString(number);
		char[] stringArray = current.toCharArray();
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
		for(int i = 0; i < stringHalfSize; i++){
			if(firstHalf[i] != secondHalf[i]){
				return false;
			}
		}
		return true;
	}

}