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
	private static threadingTest threads[] = new threadingTest[30];

	public static void main(String[] args){

		Toolkit.getDefaultToolkit().sync();

		matrix01 main = new matrix01();

		main.setup();

		for(int i = 0; i < 30; i++){
			threadingTest test = new threadingTest(i, streamClasses[i]);
			test.start();
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
			streams.generateSymbols(i, FONT_SIZE, panel);
			streamClasses[i] = streams;
		}
		frame.repaint();
	}

	// public void run(){
	// }

}

class threadingTest implements Runnable{

	private static Thread t;
	private static int column;
	private static Stream threadStream;
	private static int FONT_SIZE = 20;

	threadingTest(int column, Stream stream){
		column = column;
		threadStream = stream;
	}

	public void run(){
		while(true){
			try{
				Thread.sleep(30);
			}catch(Exception exe){}
			threadStream.render(FONT_SIZE);
		}
	}

	public void start () {
		if (t == null) {
			t = new Thread(this);
			t.start ();
		}
	}

}