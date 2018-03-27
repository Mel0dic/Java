import javax.swing.JPanel;

public class pongBall{

	private int x;
	private int xSpeed=1;
	private int y;
	private int ySpeed=	1;
	private int points = 0;
	private int panelWidth;
	private int panelHeight;

	public pongBall(JPanel panel){
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
		x = panelWidth/2;
		y = panelHeight/2;
	}

	public void update(){
		moveDot();
		changeDirection();
	}

	public void moveDot(){
		x += xSpeed;
		y += ySpeed;
	}

	public boolean touches(padel playerPadel){
		int tempPadelPos = playerPadel.getPadelY();
		if(x == 15 && y >= tempPadelPos && y <= (tempPadelPos + 30)){return true;}
		// if((x >= 5 && x <= 15) && ((y == tempPadelPos)||(y == (tempPadelPos + 30)))){return true;}
		return false;
	}

	public void changeDirection(){
		//If puck reaches the top / bottom change the direction of the puck
		if(y <= 5 || y >= (panelHeight-15) ){ySpeed*=-1;}
		//If puck reaches either side change direction
		if(x >= (panelWidth-15) ){xSpeed*=-1;}

		//If ball hits padel
		// if(x == 15 && y >= panelY && y <= (panelY + 30)){xSpeed*=-1;}

		//If ball passes past homepoint
		if(x < 0){
			x = 150;
			y = 150;
			xSpeed = 1;
			points++;
		}
	}

	public void switchDirection(){
		xSpeed*=-1;
	}

	public int getXpos(){
		return x;
	}

	public int getYpos(){
		return y;
	}

	public int getPoints(){
		return points;
	}

}