import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Symbol{
	private int yPosition;
	private int FONT_SIZE;
	private int column;
	private int row = 0;
	private int speed = 1;
	private int switchInterval = 0;
	private String value;
	private JLabel label = new JLabel(""+((char)(0x30A0 + (Math.random() * 96))));

	public JLabel labelSetUp(int FONT_SIZE, JPanel panel, int column){
		label.setForeground(Color.GREEN);
		panel.add(label);
		label.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));
		//new Font("monospaced", Font.PLAIN, FONT_SIZE)
		FONT_SIZE = FONT_SIZE;
		column = column*FONT_SIZE;
		yPosition = row*(FONT_SIZE / 2);
		label.setBounds(column, yPosition, FONT_SIZE, FONT_SIZE);
		return label;
	}

	public void setRandomSymbol(){
		if(switchInterval < 25){
			value = "" + (char)(0x30A0 + (Math.random() * 96));
			label.setText(value);
		}
		symbolSwitch();
	}

	public void rain(){
		//yPosition = row*(FONT_SIZE / 2);
		setRandomSymbol();
		label.setBounds(0, yPosition, FONT_SIZE, FONT_SIZE);
		row++;
	}

	public void symbolSwitch(){
		switchInterval = (int)(Math.random() * 100);
	}






	public void setJLabel(JLabel v){
		label = v;
	}

	public int getRow(){
		return row;
	}

	public int getColumn(){
		return column;
	}

	public JLabel getJLabel(){
		return label;
	}

}
