package com.bgrummitt;

import java.awt.*;

public class SudokuCanvas extends Canvas {

	public SudokuCanvas(){
		super();
	}

	private static final float lineThickness = 5f;
	private static final float halfLineThickness = lineThickness / 2;
	private static final float quaterLineThickness = halfLineThickness / 2;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		float boxWidth = (getWidth() - (lineThickness * 3 + (lineThickness / 2) * 6)) / 9;

		paintLines(g, boxWidth, getWidth());

	}

	private void paintLines(Graphics g, float widthPerBox, int width){
		Graphics2D g2 = (Graphics2D)g;

		g2.setStroke(new BasicStroke(lineThickness));
		g2.setColor(Color.BLACK);

		// Borders
		g2.drawLine((int)(0 + halfLineThickness), (int)(0 + halfLineThickness), (int)(width - halfLineThickness), (int)(0 + halfLineThickness));
		g2.drawLine((int)(0 + halfLineThickness), (int)(0 + halfLineThickness), (int)(0 + halfLineThickness), (int)(width - halfLineThickness));
		g2.drawLine((int)(0 + halfLineThickness), (int)(width - halfLineThickness), (int)(width - halfLineThickness), (int)(width - halfLineThickness));
		g2.drawLine((int)(width - halfLineThickness), (int)(0 + halfLineThickness), (int)(width - halfLineThickness), (int)(width - halfLineThickness));

		// Thick Left To Right
		g2.drawLine((int)(0 + halfLineThickness), (int)(widthPerBox * 3 + lineThickness * 2 + halfLineThickness), (int)(width - halfLineThickness), (int)(widthPerBox * 3 + lineThickness * 2 + halfLineThickness));
		g2.drawLine((int)(0 + halfLineThickness), (int)(widthPerBox * 6 + lineThickness * 4 + halfLineThickness), (int)(width - halfLineThickness), (int)(widthPerBox * 6 + lineThickness * 4 + halfLineThickness));

		// Thick Top To Bottom
		g2.drawLine((int)(widthPerBox * 3 + lineThickness + 3 * halfLineThickness), (int)(0 + halfLineThickness), (int)(widthPerBox * 3 + lineThickness + 3 * halfLineThickness), (int)(width - halfLineThickness));
		g2.drawLine((int)(widthPerBox * 6 + 2 * lineThickness + 5 * halfLineThickness), (int)(0 + halfLineThickness), (int)(widthPerBox * 6 + 2 * lineThickness + 5 * halfLineThickness), (int)(width - halfLineThickness));

		g2.setStroke(new BasicStroke(halfLineThickness));

		// Thin Left To Right
		float yPos = widthPerBox + lineThickness + quaterLineThickness;
		int xPos = (int)(width - halfLineThickness);
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));
		yPos = yPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));
		yPos = yPos + 2 * widthPerBox + halfLineThickness + lineThickness;
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));
		yPos = yPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));
		yPos = yPos + 2 * widthPerBox + halfLineThickness + lineThickness;
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));
		yPos = yPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(halfLineThickness), (int)(yPos), xPos, (int)(yPos));

		// Thin Top To Bottom
		float xPos = (widthPerBox + lineThickness + quaterLineThickness);
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
		xPos = xPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
		xPos = xPos + 2 * widthPerBox + halfLineThickness + lineThickness;
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
		xPos = xPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
		xPos = xPos + 2 * widthPerBox + halfLineThickness + lineThickness;
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
		xPos = xPos + widthPerBox + halfLineThickness;
		g2.drawLine((int)(xPos), (int)(halfLineThickness), (int)(xPos), (int)(width - halfLineThickness));
	}

}
