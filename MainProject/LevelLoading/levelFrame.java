import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class levelFrame{

	private JFrame frame;
	private List<List<Character>> levelList;
	private int windowWidth;
	private int windowHeight;
	private int blockSize;

	public levelFrame(int theBlockSize){
		blockSize = theBlockSize;
		loadFileToLevel mainClass = new loadFileToLevel();
		levelList = mainClass.getArrayOfArray();
		windowWidth = (levelList.get(0).size() * blockSize);
		windowHeight = (levelList.size() * blockSize);
	}

	public void paintLevel(Graphics g){
		int xPos = 0;
		int yPos = 0;
		for(List<Character> nextArray : levelList){
			for(Character c : nextArray){
				switch(c){
					case '*':	g.setColor(Color.black);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
					case 'X':	g.setColor(Color.red);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
				}
				xPos += blockSize;
			}
			xPos = 0;
			yPos += blockSize;
		}
	}

	public int getWindowHeight(){
		return windowHeight;
	}

	public int getWindowWidth(){
		return windowWidth;
	}

}