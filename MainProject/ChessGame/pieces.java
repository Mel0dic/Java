import javax.swing.JPanel;
import java.awt.Graphics;

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

	public pieces(String colour, int spaceSize){
		this.colour = colour;
		if(colour.equals("black")){
			mainRow = 0;
			pawnRow = spaceSize;
		}else if(colour.equals("white")){
			pawnRow = (6 * spaceSize);
			mainRow = (7 * spaceSize);
		}
		int xPosition = 0;
		for(int i = 0; i < 8; i++){
			pawns[i] = new pawn(xPosition, pawnRow, colour);
			xPosition += spaceSize;
		}
		theKing = new king((spaceSize * 3), mainRow, colour);
		theQueen = new queen((spaceSize * 4), mainRow, colour);
		castles[0] = new castle(0, mainRow, colour);
		castles[1] = new castle((spaceSize * 7), mainRow, colour);
		bishops[0] = new bishop((spaceSize * 2), mainRow, colour);
		bishops[1] = new bishop((spaceSize * 5), mainRow, colour);
		knights[0] = new knight(spaceSize, mainRow, colour);
		knights[1] = new knight((spaceSize * 6), mainRow, colour);
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

}