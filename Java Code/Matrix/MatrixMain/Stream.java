import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Stream{

	int totalSymbols = (int) Math.round(3 + (Math.random() * 10));
	int speed = 1 + ((int) Math.random() * 3);
	Symbol[] symbolArray = new Symbol[totalSymbols];
	JLabel[] labels = new JLabel[totalSymbols];
	int sleepTime = 0;
	int spawnPos;
	boolean endRow = true;

	public void generateSymbols(int column, int FONT_SIZE, JPanel panel){
		int positioning = ((int)Math.round(Math.random() * 25));
		for(int i = 0; i < totalSymbols; i++){
			Symbol singleSymbol = new Symbol();
			singleSymbol.setPosition(column, i, FONT_SIZE, positioning);
			symbolArray[i] = singleSymbol;
			labels[i] = symbolArray[i].labelSetUp(panel);
		}
	}

	public void render(int FONT_SIZE){
		for(int i = 0; i < totalSymbols; i++){
			symbolArray[i].rain(labels[i], sleepTime, spawnPos, speed);
			if(symbolArray[totalSymbols-1].getRow() < 5){
				spawnPos = (-1 * FONT_SIZE)	 - ((int)(Math.random() * 100));
			}
		}
	}

}