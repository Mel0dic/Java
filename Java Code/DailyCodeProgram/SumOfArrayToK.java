//Given an array of numbers, return whether any two sums to K.
//For example, given [10, 15, 3, 7] and K of 17, return true since 10 + 7 is 17.

import java.util.Scanner;

public class SumOfArrayToK{

	int numToFind;
	int numArray[] = {10, 34, 8, 2, 14, 12, 4};

	public static void main(String[] args){
		SumOfArrayToK sumOfArray = new SumOfArrayToK();
	}

	public SumOfArrayToK(){
		Scanner scan = new Scanner(System.in);
		if(checkForSum(numArray, 16) == true){
			System.out.println("True");
		}
	}

	public Boolean checkForSum(int[] numberArray, int sum){
		for(int i : numberArray){
			if(i < sum){
				numToFind = sum - i;
				for(int k : numberArray){
					if(k == numToFind){return true;}
				}
			}
		}
		return false;
	}

}