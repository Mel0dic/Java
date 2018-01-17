import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	private static final int FONT_SIZE = 20;
	private static JPanel panel = new JPanel(null);
	private static Random random = new Random();
	private static JLabel label[] = new JLabel[30];
	static JFrame frame;
	private static Stream streamClasses[] = new Stream[30];//Symbol symbols[] = new Symbol[((int) panel.getWidth()/FONT_SIZE)];

	public static void main(String[] args){

		Toolkit.getDefaultToolkit().sync();

		matrix01 main = new matrix01();

		main.setup();

		while(true){
			try{
				Thread.sleep(30);
			}catch(Exception exe){}
			for(int i = 0; i < 30; i++){
				streamClasses[i].render(panel, FONT_SIZE);
				//label[i], FONT_SIZE
			}
		}

	}

	private void setup() {
		jframeSetup();
		setUpLabels();

		frame.add(panel);
		panel.setBackground(Color.BLACK);

		frame.setVisible(true);
	}

	public void jframeSetup(){
		frame = new JFrame();
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(300, 200));
		frame.setLocationRelativeTo(null);
		frame.setTitle("MRain");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setUpLabels(){
		for(int i = 0; i < 30; i++){
			Stream streams = new Stream();
			//label[i] = symbolic.labelSetUp(FONT_SIZE, panel, i);
			streams.generateSymbols(i, FONT_SIZE);
			streamClasses[i] = streams;
		}
		frame.repaint();
	}

}