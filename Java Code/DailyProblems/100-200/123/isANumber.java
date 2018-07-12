import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
		System.out.println(isNumber("23."));
	}

	public static boolean isNumber(String number){
		char[] charTemp = number.toCharArray();
		List<Character> stringInArr = new ArrayList<Character>();

		for(int i = 0; i < charTemp.length; i++){
			stringInArr.add(charTemp[i]);
		}

		List<Character> charArr = Arrays.asList('.', '-', 'e', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0');
		List<Character> numberArr = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');

		if(stringInArr.contains('-') && stringInArr.get(0) != '-'){
			if(stringInArr.get(stringInArr.indexOf('-') - 1) != 'e'){
				return false;
			}
		}

		if(stringInArr.size() == 1 && stringInArr.get(0) == '-'){
			return false;
		}

		if(stringInArr.contains('.')){
			if(stringInArr.size() > 1 && (stringInArr.get(0) == '.' || stringInArr.get(stringInArr.size() - 1) == '.')){
				return false;
			}else if(!numberArr.contains(stringInArr.get(stringInArr.indexOf('.') - 1)) || !numberArr.contains(stringInArr.get(stringInArr.indexOf('.') + 1))){
				return false;
			}
		}

		if(stringInArr.contains('e') && (stringInArr.get(0) == 'e' || stringInArr.get(stringInArr.size() - 1) == 'e')){
			return false;
		}

		for(int i = 0; i < stringInArr.size(); i++){
			System.out.println(charArr.contains(stringInArr.get(i)) + " : " + stringInArr.get(i));
			if(!charArr.contains(stringInArr.get(i))){
				return false;
			}
		}

		return true;
	}

}