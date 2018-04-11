import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;

public class pieces{

	private String colour;
	private pawn[] pawns = new pawn[8];
	private castle[] castles = new castle[2];
	private bishop[] bishops = new bishop[2];
	private knight[] knights = new knight[2];
	private king theKing;
	private queen theQueen;
	private int pawnRow;
	private int mainRow;
	private int moveForward;

	public pieces(String colour, int spaceSize){
		this.colour = colour;
		if(colour.equals("black")){
			mainRow = 0;
			pawnRow = spaceSize;
			moveForward = spaceSize;
		}else if(colour.equals("white")){
			pawnRow = (6 * spaceSize);
			mainRow = (7 * spaceSize);
			moveForward = -spaceSize;
		}
		int xPosition = 0;
		for(int i = 0; i < 8; i++){
			pawns[i] = new pawn(xPosition, pawnRow, colour, moveForward, spaceSize);
			xPosition += spaceSize;
		}
		theKing = new king((spaceSize * 3), mainRow, colour, moveForward, spaceSize);
		theQueen = new queen((spaceSize * 4), mainRow, colour, moveForward, spaceSize);
		castles[0] = new castle(0, mainRow, colour, moveForward, spaceSize);
		castles[1] = new castle((spaceSize * 7), mainRow, colour, moveForward, spaceSize);
		bishops[0] = new bishop((spaceSize * 2), mainRow, colour, moveForward, spaceSize);
		bishops[1] = new bishop((spaceSize * 5), mainRow, colour, moveForward, spaceSize);
		knights[0] = new knight(spaceSize, mainRow, colour, moveForward, spaceSize);
		knights[1] = new knight((spaceSize * 6), mainRow, colour, moveForward, spaceSize);
	}

	public void paintTeam(Graphics g, JPanel panel){
		for(pawn i : pawns){
			i.paintPiece(g, panel);
		}
		for(int i = 0; i < 2; i++){
			castles[i].paintPiece(g, panel);
			bishops[i].paintPiece(g, panel);
			knights[i].paintPiece(g, panel);
		}
		theKing.paintPiece(g, panel);
		theQueen.paintPiece(g, panel);
	}

	public boolean isPieceInSquare(int x, int y){
		for(pawn i : pawns){
			if(x == i.getX() && y == i.getY()){
				return true;
			}
		}
		for(int i = 0; i < 2; i++){
			if(x == castles[i].getX() && y == castles[i].getY()){
				return true;
			}
			if(x == bishops[i].getX() && y == bishops[i].getY()){
				return true;
			}
			if(x == knights[i].getX() && y == knights[i].getY()){
				return true;
			}
		}
		if(x == theKing.getX() && y == theKing.getY()){
			return true;
		}
		if(x == theQueen.getX() && y == theQueen.getY()){
			return true;
		}
		return false;
	}

	public List<List<Integer>> getPieceInSquare(int x, int y){
		for(pawn i : pawns){
			if(x == i.getX() && y == i.getY()){
				return i.movablePositions();
			}
		}
		for(int i = 0; i < 2; i++){
			if(x == castles[i].getX() && y == castles[i].getY()){
				return castles[i].movablePositions();
			}
			if(x == bishops[i].getX() && y == bishops[i].getY()){
				return bishops[i].movablePositions();
			}
			if(x == knights[i].getX() && y == knights[i].getY()){
				return knights[i].movablePositions();
			}
		}
		if(x == theKing.getX() && y == theKing.getY()){
			return theKing.movablePositions();
		}
		if(x == theQueen.getX() && y == theQueen.getY()){
			return theQueen.movablePositions();
		}
		return null;
	}

}