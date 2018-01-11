import java.util.*;

public class Symbol{
	private int row;
	private int column;
	private int speed = 1;
	private int switchInterval = 0;
	private char value;

	public void setRandomSymbol(){
		value = (char)(0x30A0 + (Math.random() * 96)
	}

	public void rain(){
		
	}

	public void symbolSwitch(){
		switchInterval = 1 + (int)(Math.random() * 100);
	}





	public void setRow(int r){
		row = r;
	}

	public void setColumn(int c){
		column = c;
	}

	public void setValue(char v){
		value = v;
	}

	public int getRow(){
		return row;
	}

	public int getColumn(){
		return column;
	}

	public char getValue(){
		return value;
	}

}
