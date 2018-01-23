import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Symbol{

	private int FONT_SIZE;
	private int row = 0;
	private int column = 0;
	private int switchInterval = 0;
	private String value = "";
	private JLabel label = new JLabel(""+((char)(0x30A0 + (Math.random() * 96))));
	private JPanel panels;

	Symbol(int fontSize){
		FONT_SIZE = fontSize;
	}

	public JLabel labelSetUp(JPanel panel){
		panels = panel;

		label.setForeground(Color.GREEN);
		panels.add(label);
		label.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));

		label.setBounds(column, row, FONT_SIZE, FONT_SIZE);
		return label;
	}

	public void setPosition(int symbolColumn, int position, int yPos){
		row = (yPos*(FONT_SIZE / 2)) - (position * FONT_SIZE);
		column = symbolColumn*FONT_SIZE;
	}

	public void setRandomSymbol(){
		if(switchInterval < 5){
			value = "" + (char)(0x30A0 + (Math.random() * 96));
			label.setText(value);
		}
		switchInterval = (int)(Math.random() * 100);
	}

	public void rain(JLabel label, int resetPos, int speed){
		row = row > panels.getHeight() ? resetPos : (row + speed);
		label.setBounds(column, row, FONT_SIZE, FONT_SIZE);
		setRandomSymbol();
	}






	public void setJLabel(JLabel inputLabel){
		label = inputLabel;
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
