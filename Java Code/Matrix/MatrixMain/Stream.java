import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Stream{

	private int FONT_SIZE;
	private int column;
	private int totalSymbols = (int) Math.round(3 + (Math.random() * 10));
	private int speed = (int)(1 + Math.random() * 3);
	private int spawnPos = (-1 * 20)	 - ((int)(Math.random() * 100));
	private int positioning = ((int)Math.round(Math.random() * 25));
	private boolean endRow = true;
	private Symbol[] symbolArray = new Symbol[totalSymbols];
	private JLabel[] labels = new JLabel[totalSymbols];

	Stream(int fontSize, int streamColumn){
		FONT_SIZE = fontSize;
		column = streamColumn;
	}

	public void generateSymbols(JPanel panel){
		for(int i = 0; i < totalSymbols; i++){
			Symbol singleSymbol = new Symbol(FONT_SIZE);
			singleSymbol.setPosition(column, i, positioning);
			symbolArray[i] = singleSymbol;
			labels[i] = symbolArray[i].labelSetUp(panel);
		}
	}

	public void render(){
		for(int i = 0; i < totalSymbols; i++){
			symbolArray[i].rain(labels[i], spawnPos, speed);
			if(symbolArray[totalSymbols-1].getRow() < 5){
				spawnPos = (-1 * FONT_SIZE)	 - ((int)(Math.random() * 100));
			}
		}
	}

}