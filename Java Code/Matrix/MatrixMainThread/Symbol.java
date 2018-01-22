import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Symbol{
	private int speed = 1;
	private int FONT_SIZE = 20;
	private int row = 0;
	private int columns = 0;
	private int switchInterval = 0;
	private String value = "";
	private JLabel label = new JLabel(""+((char)(0x30A0 + (Math.random() * 96))));
	private JPanel panels;

	public JLabel labelSetUp(JPanel panel){
		panels = panel;

		label.setForeground(Color.GREEN);
		panels.add(label);
		label.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));

		label.setBounds(columns, row, FONT_SIZE, FONT_SIZE);
		return label;
	}

	public void setPosition(int column, int position, int FONT_SIZ, int yPos){
		FONT_SIZE = FONT_SIZ;

		row = (yPos*(FONT_SIZE / 2)) - (position * FONT_SIZE);
		columns = column*FONT_SIZE;
	}

	public void setRandomSymbol(){
		if(switchInterval < 10){
			value = "" + (char)(0x30A0 + (Math.random() * 96));
			label.setText(value);
		}
		symbolSwitch();
	}

	public void rain(JLabel label, int FONT_SIZE, int sleepTime){
		if(row > panels.getHeight()){
			row = -FONT_SIZE;
			try{
				Thread.sleep(100 * sleepTime);
			}catch(Exception exe){}
		}else{
			row += speed;
		}
		//row = row > panels.getHeight() ? -20 : (row + speed);
		label.setBounds(columns, row, FONT_SIZE, FONT_SIZE);
		setRandomSymbol();
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
		return columns;
	}

	public JLabel getJLabel(){
		return label;
	}

}
