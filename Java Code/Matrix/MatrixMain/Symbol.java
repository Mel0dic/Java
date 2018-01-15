import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Symbol{
	private int row;
	private int column;
	private int speed = 1;
	private int switchInterval = 0;
	private String value;
	private JLabel label;

	public void setRandomSymbol(){
		if(switchInterval < 25){
			value = "" + (char)(0x30A0 + (Math.random() * 96));
			label.setText(value);
		}
		symbolSwitch();
	}

	// public void rain(){
		
	// }

	public void symbolSwitch(){
		switchInterval = (int)(Math.random() * 100);
	}





	// public void setRow(int r){
	// 	row = r;
	// }

	// public void setColumn(int c){
	// 	column = c;
	// }

	public void setJLabel(JLabel v){
		label = v;
	}

	// public int getRow(){
	// 	return row;
	// }

	// public int getColumn(){
	// 	return column;
	// }

	public JLabel getJLabel(){
		return label;
	}

}
