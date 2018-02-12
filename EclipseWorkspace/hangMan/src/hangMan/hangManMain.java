package hangMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class hangManMain {
	
	private static Random rand = new Random();
	private static List<String> wordList = new ArrayList<>();
	private static String wordToGuess;
	private static int guesses = 0;
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		getWords();
		
		wordToGuess = wordList.get(rand.nextInt(wordList.size()));
		
		play(wordToGuess);
		
//		for(String word : wordList) {
//			System.out.println(word);
//		}

	}

	public static void getWords() {
		Charset charset = Charset.forName("US-ASCII");
		Path file = Paths.get("D:\\Code\\Java\\EclipseWorkspace\\hangMan\\src\\hangMan\\words.txt");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        wordList.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public static void play(String word) {
		System.out.println(word);
		int wordLength = word.length();
		char[] wordArr = new char[wordLength];
		for(int i = 0; i < wordLength; i++) {
			wordArr[i] = '_';
		}
		System.out.println(wordArr);
		
		while(guesses < 6) {
			char s = reader.next().charAt(0);
			if(word.indexOf(s) >= 0) {
				for(int i = 0; i < wordLength; i++) {
					if(s == word.charAt(i)) {
						wordArr[i] = s;
					}
				}
			}else {
				guesses++;
			}
			System.out.println(wordArr);
		}
	}
}
