//Needed for Lists
import java.util.*;

public class viginere{

	public static void main(String[] args){

		String encryptedValue = encrypt("Test Test Test", "Test");
		System.out.println(encryptedValue);

	}

	public static String encrypt(String toEncrypt, String encryptionKey){

		String lowerCaseEncryptionKey = encryptionKey.toLowerCase();
		char[] lowerCaseArray = lowerCaseEncryptionKey.toCharArray();
		List<Integer> key = new ArrayList<>();

		for(char letter : lowerCaseArray){
			key.add(((int) letter - 'a'));
		}

		char[] toEncryptArray = toEncrypt.toCharArray();

		int counts = 0;

		List<Character> encryptedArray = new ArrayList<>();

		for(int i = 0; i < toEncrypt.length(); i++){
			if(Character.isLowerCase(toEncryptArray[i])){
				encryptedArray.add(((char) ((((toEncryptArray[i] - 97) + key.get(counts)) % 26) + 97)));
				counts++;
			}else if(Character.isUpperCase(toEncryptArray[i])){
				encryptedArray.add(((char) ((((toEncryptArray[i] - 65) + key.get(counts)) % 26 ) + 65)));
				counts++;
			}else{
				encryptedArray.add(toEncryptArray[i]);
			}
			if(counts == (encryptionKey.length())){
				counts = 0;
			}
		}

		return encryptedArray.toString();
	}
}