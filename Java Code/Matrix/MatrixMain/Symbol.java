import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class Symbol{
	private int row;
	private int columns;
	private int switchInterval = 0;
	private String value;
	private JLabel label = new JLabel(""+((char)(0x30A0 + (Math.random() * 96))));

	public JLabel labelSetUp(int FONT_SIZE, JPanel panel, int column){
		row = 0*(FONT_SIZE / 2);
		columns = column*FONT_SIZE;

		label.setForeground(Color.GREEN);
		panel.add(label);
		label.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));

		label.setBounds(columns, row, FONT_SIZE, FONT_SIZE);
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
		row += 1;
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
