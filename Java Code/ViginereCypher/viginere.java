//Needed for Lists
import java.util.*;

//Create the class viginere
public class viginere{

	//Make the main function called upon running program
	public static void main(String[] args){

		//Static can call only other static methods and variables
		//viginere uno = new viginere(); //Needs to be used if encrypt is not a static method

		//Set encrypted value to the return value of encrypt()
		String encryptedValue = encrypt("Test Test Test", "Test");
		//Print out encryptedValue
		System.out.println(encryptedValue);

	}

	//Define function encrypt public and static so that you don't need a instance of the class to access.
	public static String encrypt(String toEncrypt, String encryptionKey){

		//Create a string to hold the lower case string of encryptionKey
		String lowerCaseEncryptionKey = encryptionKey.toLowerCase();
		//Create an char array to hold the lowerCaseString in array form
		char[] lowerCaseArray = lowerCaseEncryptionKey.toCharArray();
		//Create a empty list for the key
		List<Integer> key = new ArrayList<>();

		//Loop through the lower case array and set letter to alphabet number so 1-26 add it to key
		for(char letter : lowerCaseArray){
			key.add(((int) letter - 'a'));
		}

		//Create char array of letters in toEncrypt
		char[] toEncryptArray = toEncrypt.toCharArray();

		//Set counts to 0
		int counts = 0;

		//Create a empty list called encrypted array to store the letters once encrypted
		List<Character> encryptedArray = new ArrayList<>();

		//Loop through every letter needed to be encrypted
		for(int i = 0; i < toEncrypt.length(); i++){
			//If the charachter is lowerCase encrypt as a lower case letter
			if(Character.isLowerCase(toEncryptArray[i])){
				encryptedArray.add(((char) ((((toEncryptArray[i] - 97) + key.get(counts)) % 26) + 97)));
				counts++;
			}
			//If the charachter is upperCase encrypt as a upper case letter
			else if(Character.isUpperCase(toEncryptArray[i])){
				encryptedArray.add(((char) ((((toEncryptArray[i] - 65) + key.get(counts)) % 26 ) + 65)));
				counts++;
			}
			//Else just add spaces and punctuation the List
			else{
				encryptedArray.add(toEncryptArray[i]);
			}
			//If counts == length of encryptionkey set it to 0
			if(counts == (encryptionKey.length())){
				counts = 0;
			}
		}

		//Create an empyty string
		String returnString = "";

		//Loop through encrypted array and put letters into a string
		for(char letter : encryptedArray){
			returnString += letter;
		}

		//Return encrypted string
		return returnString;
	}
}