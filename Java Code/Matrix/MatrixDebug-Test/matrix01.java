import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	private static final int FONT_SIZE = 20;
	private static JPanel panel = new JPanel(null);
	private static Random random = new Random();
	private static int pWidth;
	private static JLabel label[];
	static JFrame frame;
	private static Stream streamClasses[];//Symbol symbols[] = new Symbol[((int) panel.getWidth()/FONT_SIZE)];

	public static void main(String[] args){

		//Toolkit.getDefaultToolkit().sync();

		matrix01 main = new matrix01();

		main.setup();

		int pheight = panel.getHeight();

		while(true){
			try{
				Thread.sleep(30);
			}catch(Exception exe){}
			for(int i = 0; i < pWidth; i++){
				streamClasses[i].render(panel, FONT_SIZE, pheight);
			}
		}

	}

	private void setup() {
		jframeSetup();
		frame.add(panel);
		panel.setBackground(Color.BLACK);

		frame.setVisible(true);

		pWidth = ((int) panel.getWidth()/FONT_SIZE);

		label = new JLabel[pWidth];
		streamClasses = new Stream[pWidth];

		setUpLabels();
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
		for(int i = 0; i < pWidth; i++){
			Stream streams = new Stream();
			//label[i] = symbolic.labelSetUp(FONT_SIZE, panel, i);
			streams.generateSymbols(i, FONT_SIZE);
			streamClasses[i] = streams;
		}
	}

}