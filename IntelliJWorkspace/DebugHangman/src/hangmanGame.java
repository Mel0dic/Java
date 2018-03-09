import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hangmanGame {

    private int wordLength;
    private String word;
    private char[] wordLetters;
    private String labelWord;
    private int guessedLetters = 0;
    private int wrongGuesses = 4;
    private List<String> wordList = new ArrayList<>();

    Random rand = new Random();

    public hangmanGame(int lengthOfWord){
        wordLength = lengthOfWord;

        wordLetters = new char[lengthOfWord];
        for(int i = 0; i < wordLength; i++){
            wordLetters[i] = '_';
        }
    }

    public String getRandomWord() {
        Charset charset = Charset.forName("US-ASCII");
        //Path file = Paths.get("D:\\Code\\Java\\IntelliJWorkspace\\DebugHangman\\Extra\\words.txt");
        Path file = Paths.get("C:\\Users\\bengr\\Documents\\GitHub\\Java\\IntelliJWorkspace\\DebugHangman\\Extra\\words.txt");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        word = wordList.get(rand.nextInt(wordList.size()));

        wordLength = word.length();

        setBegginingWord();

        System.out.println(word);

        return word;
    }

    public void setBegginingWord(){
        wordLetters = new char[wordLength];
        for(int i = 0; i < wordLength; i++){
            wordLetters[i] = '_';
        }
    }

    public String labelWord(){
        labelWord = "";
        for(int i = 0; i < wordLength; i++){
            if(i == (wordLength)){
                labelWord += wordLetters[i];
            }else{
                labelWord += wordLetters[i];
                labelWord += " ";
            }
        }
        System.out.println(labelWord);
        return labelWord;
    }

    //Add function to see if guess is char inside of word
    public boolean guess(Character guessMade){
        if(word.indexOf(guessMade) >= 0){
            return true;
        }else {
            wrongGuesses--;
            return false;
        }
    }

    public void updateGuessedLetters(char guess){
        for(int i = 0; i < wordLength; i++){
            if(word.charAt(i) == guess){
                wordLetters[i] = guess;
                guessedLetters++;
            }
        }
    }

    public int lettersGuess(){
        return guessedLetters;
    }

    public int winLoseChecker(){
        if(wrongGuesses == 0){
            return 2;
        }else if(guessedLetters >= wordLength){
            for(char i : wordLetters){
                if(i == '_'){
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    public int getGuessesLeft(){
        return wrongGuesses;
    }

}
