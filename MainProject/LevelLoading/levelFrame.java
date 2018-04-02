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
	private int spawnX;
	private int spawnY;

	public levelFrame(int theBlockSize){
		blockSize = theBlockSize;
		loadFileToLevel mainClass = new loadFileToLevel();
		levelList = mainClass.getArrayOfArray();
		windowWidth = (levelList.get(0).size() * blockSize);
		windowHeight = (levelList.size() * blockSize);
		startLoop();
	}

	public void startLoop(){
		int xPos = 0;
		int yPos = 0;
		for(List<Character> nextArray : levelList){
			for(Character c : nextArray){
				if(c == '~'){
					spawnX = xPos;
					spawnY = yPos;
				}
				xPos += blockSize;
			}
			xPos = 0;
			yPos += blockSize;
		}
	}

	public void paintLevel(Graphics g){
		int xPos = 0;
		int yPos = 0;
		for(List<Character> nextArray : levelList){
			for(Character c : nextArray){
				switch(c){
					case '*':	g.setColor(Color.black);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								// System.out.println(yPos);
								break;
					case 'X':	g.setColor(Color.red);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
					case '~':	g.setColor(Color.pink);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
				}
				xPos += blockSize;
			}
			xPos = 0;
			yPos += blockSize;
		}
	}

	public List<List<Character>> getMap(){
		return levelList;
	}

	public int getSpawnX(){
		return spawnX;
	}

	public int getSpawnY(){
		return spawnY;
	}

	public int getWindowHeight(){
		return windowHeight;
	}

	public int getWindowWidth(){
		return windowWidth;
	}

}