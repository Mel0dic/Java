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
	
	@SuppressWarnings("unused")
	private Random rand = new Random();
	private List<String> wordList = new ArrayList<>();
	@SuppressWarnings("unused")
	private String wordToGuess;
	private int guesses = 4;
	private Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

//		getWords();
//		
//		wordToGuess = wordList.get(rand.nextInt(wordList.size()));
//		
//		play(wordToGuess);


	}

	public void getWords() {
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
	
	public void play(String word) {

		int wordLength = word.length();
		char[] wordArr = new char[wordLength];
		List<Character> wrongLetters = new ArrayList<>();

		
		for(int i = 0; i < wordLength; i++) {
			wordArr[i] = '_';
		}
		System.out.printf("Welcome to HangMan. Here's the word:%n");
		System.out.println(wordArr);
		
		int wordComplete = 0;
		
		while(guesses > 0 && wordLength > wordComplete) {
			System.out.printf("Limbs left: %d%n", (guesses));
			System.out.printf("Incorect guesses: ");
			System.out.println(wrongLetters);
			System.out.printf("Enter a letter to guess: ");
			char s = reader.next().charAt(0);
			if(word.indexOf(s) >= 0) {
				for(int i = 0; i < wordLength; i++) {
					if(s == word.charAt(i)) {
						wordArr[i] = s;
						wordComplete++;
					}
				}
				System.out.println(wordArr);
			}else {
				System.out.printf("Sorry %s is not in the word.%n%n", s);
				wrongLetters.add(s);
				guesses--;
				System.out.println(wordArr);
			}
		}
		if(wordComplete == wordLength) {
			System.out.println("You won");
		}else {
			System.out.println("Unlucky you lost.");
			System.out.printf("The word was %s%n", word);
		}
	}
}
