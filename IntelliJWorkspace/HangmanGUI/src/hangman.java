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

public class hangman {

    private Random rand = new Random();
    private List<String> wordList = new ArrayList<>();
    private int guesses = 4;
    private Scanner reader = new Scanner(System.in);
    private int wordLength;
    private char[] wordArr;
    private List<Character> wrongLetters;
    private int wordComplete;

    public String getRandomWord() {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("D:\\Code\\Java\\EclipseWorkspace\\hangMan\\src\\hangMan\\words.txt");
        //Path file = Paths.get("C:\\Users\\bengr\\Documents\\GitHub\\Java\\EclipseWorkspace\\hangMan\\src\\hangMan\\words.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        String word = wordList.get(rand.nextInt(wordList.size()));

        wordLength = word.length();

        return word;
    }

    public void play(String word) {

        wordLength = word.length();
        wordArr = new char[wordLength];
        wrongLetters = new ArrayList<>();


        for(int i = 0; i < wordLength; i+=2) {
            wordArr[i] = '_';
        }

        System.out.printf("Welcome to HangMan. Here's the word:%n");
        System.out.println(wordArr);

        wordComplete = 0;

        while(guesses > 0 && wordLength > wordComplete) {
            System.out.printf("Limbs left: %d%n", (guesses));
            System.out.printf("Incorect guesses: ");
            System.out.println(wrongLetters);
            System.out.printf("Enter a letter to guess: ");
            char s = reader.next().charAt(0);
            guess(word, s);
        }
        if(wordComplete == wordLength) {
            System.out.println("You won");
        }else {
            System.out.println("Unlucky you lost.");
            System.out.printf("The word was %s%n", word);
        }
    }

    public boolean guess(String word, Character s) {
        if(word.indexOf(s) >= 0) {
//			for(int i = 0; i < wordLength; i++) {
//				if(s == word.charAt(i)) {
//					wordArr[i] = s;
//					wordComplete++;
//				}
//			}
            return true;
        }else {
            return false;
        }
    }

    public int getWordLength() {
        return wordLength;
    }
}

