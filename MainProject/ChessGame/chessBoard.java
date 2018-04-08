import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Color;

public class chessBoard{

	private int spaceSize;
	private boolean boxToHighlight = false;

	public chessBoard(int spaceSize){
		this.spaceSize = spaceSize;
	}

	public void drawBoard(Graphics g){
		//For row in board
		for(int i = 0; i < 8; i++){
			//For column in row
			for(int j = 0; j < 8; j++){
				//If j is an even number and i is an even number
				if(j % 2 == 0 && i % 2 == 0){
					//Set color to black and fill a square at that position
					g.setColor(Color.black);
					g.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}
				//Else if j is not even (odd) and i is odd
				else if(j % 2 != 0 && i % 2 != 0){
					g.setColor(Color.black);
					g.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}
			}
		}
	}

	public void highlightBox(int x, int y){
		System.out.println(x + ", " + y);
	}

}