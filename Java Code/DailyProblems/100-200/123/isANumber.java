import java.util.Arrays;

public class isANumber{

	/**
	 * Given a string, return whether it represents a number. Here are the different kinds of numbers:
	 *
	 *		"10", a positive integer
	 *		"-10", a negative integer
	 *		"10.1", a positive real number
	 *		"-10.1", a negative real number
	 *		"1e5", a number in scientific notation
	 *
	 *	And here are examples of non-numbers:
	 *	
	 *		"a"
	 *		"x 1"
	 *		"a -2"
	 *		"-"
	 */
	public static void main(String[] args){
		System.out.println(isNumber("124-"));
	}

	public static boolean isNumber(String number){
		char[] stringInArr = number.toCharArray();

		char[] allowedChars = {'.', '-', 'e', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

		for(int i = 0; i < stringInArr.length; i++){
			System.out.println(Arrays.asList(allowedChars).contains(stringInArr[i]) + " : " + stringInArr[i]);
			if(!Arrays.asList(allowedChars).contains(stringInArr[i])){
				return false;
			}
		}

		return true;
	}

}