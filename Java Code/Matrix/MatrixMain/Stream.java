import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Stream{

	int totalSymbols = (int) Math.round(3 + (Math.random() * 10));
	int speed = 1;
	Symbol[] symbolArray = new Symbol[totalSymbols];

	public void generateSymbols(){
		for(int i = 0; i < totalSymbols; i++){
			Symbol singleSymbol = new Symbol();
			symbolArray.add(singleSymbol);
		}
	}

	public void render(){
		for(Symbol eachSymbol : symbolArray){
			eachSymbol.rain();
		}
	}

}