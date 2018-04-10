import java.awt.event.MouseListener;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

public class chessBoard{

	private List<List<Integer>> canMoveTo;
	private boolean boxToHighlight = false;
	private boolean canMoveToHighlight = false;
	private boolean pieceInSpace = false;
	private int boxToHighlightX;
	private int boxToHighlightY;
	private int spaceSize;
	private int boardSize;
	private int tempBoxToHighlightX;
	private int tempBoxToHighlightY;

	public chessBoard(int spaceSize){
		this.spaceSize = spaceSize;
		boardSize = spaceSize * 8;
	}

	public void drawBoard(Graphics2D g2){
		//For row in board
		for(int i = 0; i < 8; i++){
			//For column in row
			for(int j = 0; j < 8; j++){
				//If j is an even number and i is an even number
				if(j % 2 == 0 && i % 2 == 0){
					//Set color to black and fill a square at that position
					g2.setColor(Color.orange);
					g2.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}
				//Else if j is not even (odd) and i is odd
				else if(j % 2 != 0 && i % 2 != 0){
					g2.setColor(Color.orange);
					g2.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}
			}
		}
		if(boxToHighlight && pieceInSpace){
			//Copy current stroke
			Stroke oldStroke = g2.getStroke();
			//Set Stroke Thickness
			int thickness = 4;
			//Set the new stroke
			g2.setStroke(new BasicStroke(thickness));
			//Set color to blue
			g2.setColor(Color.red);
			//Draw the rectangle
			g2.drawRect((boxToHighlightX+(thickness/2)), (boxToHighlightY+(thickness/2)), (spaceSize-thickness), (spaceSize-thickness));
			//Reset the stroke
			g2.setStroke(oldStroke);
		}
		if(canMoveToHighlight){
			//Copy current stroke
			Stroke oldStroke = g2.getStroke();
			//Set Stroke Thickness
			int thickness = 2;
			//Set the new stroke
			g2.setStroke(new BasicStroke(thickness));
			//Set color to blue
			g2.setColor(Color.blue);
			for(List<Integer> i : canMoveTo){
				g2.drawRect((i.get(0)+(thickness/2)), (i.get(1)+(thickness/2)), (spaceSize-thickness), (spaceSize-thickness));
			}
			//Reset the stroke
			g2.setStroke(oldStroke);
		}
	}

	public void getBox(int x, int y){
		tempBoxToHighlightX = -1;
		tempBoxToHighlightY = -1;
		boxToHighlight = true;
		for(int i = 0; i < boardSize; i+=spaceSize){
			if(x >= i && x < (i + spaceSize)){
				tempBoxToHighlightX = i;
			}
			if(y >= i && y < (i + spaceSize)){
				tempBoxToHighlightY = i;
			}
		}
		if(tempBoxToHighlightX == boxToHighlightX && tempBoxToHighlightY == boxToHighlightY){
			boxToHighlight = false;
			boxToHighlightX = -1;
			boxToHighlightY = -1;
			return;
		}else{
			boxToHighlightX = tempBoxToHighlightX;
			boxToHighlightY = tempBoxToHighlightY;
			return;
		}
	}

	public void setCanMoveTo(List<List<Integer>> canMoveToTheseSpaces){
		canMoveTo = canMoveToTheseSpaces;
	}

	public void setPieceInSpace(boolean que){
		pieceInSpace = que;
		canMoveToHighlight = que;
	}

	public int gethightlightedBoxXPosition(){
		return boxToHighlightX;
	}

	public int gethightlightedBoxYPosition(){
		return boxToHighlightY;
	}

}